import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:sqlite:users.db";
    private Connection connection;
    
    @Override
    public void init() throws ServletException {
        try {
            // Initialize database connection
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
            
            // Create users table if not exists
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("""
                    CREATE TABLE IF NOT EXISTS users (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        email TEXT UNIQUE,
                        age INTEGER
                    )
                """);
            }
            
            System.out.println("UserServlet initialized successfully");
        } catch (Exception e) {
            throw new ServletException("Failed to initialize UserServlet", e);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            String pathInfo = request.getPathInfo();
            
            if (pathInfo == null || pathInfo.equals("/")) {
                // List all users
                List<User> users = getAllUsers();
                out.println("<html><body>");
                out.println("<h2>User List</h2>");
                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th></tr>");
                
                for (User user : users) {
                    out.println("<tr>");
                    out.println("<td>" + user.getId() + "</td>");
                    out.println("<td>" + user.getName() + "</td>");
                    out.println("<td>" + user.getEmail() + "</td>");
                    out.println("<td>" + user.getAge() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<br><a href='users/form.html'>Add New User</a>");
                out.println("</body></html>");
            } else {
                // Get specific user
                String[] parts = pathInfo.split("/");
                if (parts.length == 2) {
                    int userId = Integer.parseInt(parts[1]);
                    User user = getUserById(userId);
                    if (user != null) {
                        out.println("<html><body>");
                        out.println("<h2>User Details</h2>");
                        out.println("<p>ID: " + user.getId() + "</p>");
                        out.println("<p>Name: " + user.getName() + "</p>");
                        out.println("<p>Email: " + user.getEmail() + "</p>");
                        out.println("<p>Age: " + user.getAge() + "</p>");
                        out.println("<br><a href='../users'>Back to List</a>");
                        out.println("</body></html>");
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
                    }
                }
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            
            // Insert new user
            try (PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO users (name, email, age) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setInt(3, age);
                pstmt.executeUpdate();
                
                // Redirect to user list
                response.sendRedirect(request.getContextPath() + "/users");
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    
    @Override
    public void destroy() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            System.out.println("UserServlet destroyed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            
            while (rs.next()) {
                User user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("age")
                );
                users.add(user);
            }
        }
        return users;
    }
    
    private User getUserById(int id) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "SELECT * FROM users WHERE id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                    );
                }
            }
        }
        return null;
    }
    
    private static class User {
        private final int id;
        private final String name;
        private final String email;
        private final int age;
        
        public User(int id, String name, String email, int age) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.age = age;
        }
        
        public int getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public int getAge() { return age; }
    }
} 