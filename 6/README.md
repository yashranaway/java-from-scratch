# Java Servlets

## 📚 Theory

### Servlet Lifecycle
1. **Initialization (init())**
   - Called once when servlet is created
   - Loads configuration
   - Initializes resources
   - Throws ServletException

2. **Service (service())**
   - Handles client requests
   - Calls appropriate doXXX() method
   - Multiple threads can execute
   - Thread-safe implementation needed

3. **Destruction (destroy())**
   - Called when servlet is unloaded
   - Cleans up resources
   - Saves persistent state
   - Called only once

### HTTP Methods
1. **GET (doGet())**
   - Retrieves data
   - Parameters in URL
   - Bookmarkable
   - Limited data size

2. **POST (doPost())**
   - Submits data
   - Parameters in body
   - Not bookmarkable
   - No size limit

3. **Other Methods**
   - PUT (doPut())
   - DELETE (doDelete())
   - HEAD (doHead())
   - OPTIONS (doOptions())

### ServletConfig vs ServletContext
1. **ServletConfig**
   - Servlet-specific configuration
   - One per servlet
   - Initialization parameters
   - Servlet name

2. **ServletContext**
   - Application-wide configuration
   - Shared by all servlets
   - Web application parameters
   - Resource management

### Request & Response Handling
1. **Request Object**
   - Parameter handling
   - Header information
   - Session management
   - Cookie handling

2. **Response Object**
   - Content type setting
   - Header manipulation
   - Cookie creation
   - Output stream

3. **Request Dispatcher**
   - Forward requests
   - Include responses
   - URL patterns
   - Error handling

### Deployment on Tomcat
1. **Web Application Structure**
   - WEB-INF directory
   - web.xml configuration
   - Class files
   - JAR files

2. **Deployment Methods**
   - WAR file
   - Exploded directory
   - Auto-deployment
   - Manual deployment

3. **Configuration**
   - Context path
   - Servlet mapping
   - Security constraints
   - Error pages

### Connecting Servlet with JDBC
1. **Database Connection**
   - Connection pooling
   - Resource management
   - Error handling
   - Transaction management

2. **Best Practices**
   - Use connection pool
   - Close resources
   - Handle exceptions
   - Use prepared statements

3. **Security**
   - SQL injection prevention
   - Password encryption
   - Access control
   - Input validation

### Best Practices
1. **Thread Safety**
   - Synchronize shared resources
   - Avoid instance variables
   - Use local variables
   - Thread-safe collections

2. **Performance**
   - Connection pooling
   - Resource caching
   - Efficient logging
   - Proper exception handling

3. **Security**
   - Input validation
   - Output encoding
   - Session management
   - Access control

4. **Error Handling**
   - Custom error pages
   - Logging
   - User-friendly messages
   - Exception handling
