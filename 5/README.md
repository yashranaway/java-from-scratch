# Java Database Connectivity (JDBC)

## 📚 Theory

### JDBC Setup
1. **Database Drivers**
   - MySQL Connector/J
   - SQLite JDBC
   - Oracle JDBC
   - PostgreSQL JDBC

2. **Driver Types**
   - Type 1: JDBC-ODBC Bridge
   - Type 2: Native-API Driver
   - Type 3: Network Protocol Driver
   - Type 4: Thin Driver (Pure Java)

3. **Classpath Configuration**
   - Add driver JAR to classpath
   - Maven/Gradle dependency
   - Driver registration

### Database Connection
1. **Connection Steps**
   - Load driver class
   - Create connection URL
   - Get connection object
   - Handle SQLException

2. **Connection Properties**
   - URL format
   - Username/Password
   - Auto-commit
   - Connection pooling

3. **Best Practices**
   - Use try-with-resources
   - Close connections
   - Connection pooling
   - Error handling

### CRUD Operations
1. **Create (Insert)**
   - INSERT statement
   - Batch inserts
   - Auto-generated keys
   - Error handling

2. **Read (Select)**
   - SELECT statement
   - ResultSet handling
   - Column types
   - Null handling

3. **Update**
   - UPDATE statement
   - Multiple rows
   - Conditional updates
   - Affected rows

4. **Delete**
   - DELETE statement
   - Cascading deletes
   - Conditional deletes
   - Safe deletion

### PreparedStatement
1. **Benefits**
   - SQL injection prevention
   - Better performance
   - Type safety
   - Reusability

2. **Parameter Types**
   - setString()
   - setInt()
   - setDate()
   - setObject()

3. **Batch Processing**
   - addBatch()
   - executeBatch()
   - Batch size
   - Error handling

### Transaction Processing
1. **ACID Properties**
   - Atomicity
   - Consistency
   - Isolation
   - Durability

2. **Transaction Control**
   - setAutoCommit()
   - commit()
   - rollback()
   - savepoint

3. **Isolation Levels**
   - READ_UNCOMMITTED
   - READ_COMMITTED
   - REPEATABLE_READ
   - SERIALIZABLE

### Stored Procedures
1. **CallableStatement**
   - IN parameters
   - OUT parameters
   - INOUT parameters
   - Result sets

2. **Procedure Types**
   - Simple procedures
   - Functions
   - Cursors
   - Error handling

3. **Best Practices**
   - Parameter validation
   - Error handling
   - Resource cleanup
   - Performance

### Join Queries & ResultSet
1. **Join Types**
   - INNER JOIN
   - LEFT JOIN
   - RIGHT JOIN
   - FULL JOIN

2. **ResultSet Types**
   - TYPE_FORWARD_ONLY
   - TYPE_SCROLL_INSENSITIVE
   - TYPE_SCROLL_SENSITIVE

3. **ResultSet Methods**
   - next()
   - previous()
   - absolute()
   - relative()

4. **Metadata**
   - ResultSetMetaData
   - Column information
   - Type information
   - Nullability

### Best Practices
1. **Resource Management**
   - Close resources
   - Use try-with-resources
   - Connection pooling
   - Statement pooling

2. **Performance**
   - Use PreparedStatement
   - Batch processing
   - Proper indexing
   - Connection pooling

3. **Security**
   - SQL injection prevention
   - Password encryption
   - Access control
   - Input validation

4. **Error Handling**
   - SQLException
   - BatchUpdateException
   - DataTruncation
   - SQLWarning
