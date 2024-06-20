### **JDBC (Java DataBase Connectivity)**

-   자바 어플리케이션에서 데이터베이스에 접근할 수 있도록 하는 API

#### **JDBC API Process**

(1) JDBC 드라이버를 로딩한다.

-   **PostgreSQL**  
    Class Name : org.postgresql.Driver  
    Url : jdbc:postgresql://\[HOST\]:\[PORT\]/\[DATABASE\]
-   **Oracle**  
    Class Name : oracle.jdbc.driver.OracleDriver  
    Url : jdbc:oracle:thin:@\[HOST\]:\[PORT\]:\[SID\]
-   **MySQL**  
    Class Name : com.mysql.cj.jdbc.Driver  
    Url : jdbc:mysql://\[HOST\]:\[PORT\]/\[DATABASE\]\[?PropertyName1\]\[=PropertyValue1\]\[&PropertyName2\]\[=PropertyValue2\]...

-   **MariaDB**  
    Class Name : org.mariadb.jdbc.Driver  
    Url : jdbc:mariadb\[mysql\]:\[HOST\]\[:PORT\]/\[DATABASE\]\[?PropertyName1\]\[=PropertyValue1\]\[&PropertyName2\]\[=PropertyValue2\]...

(2) Connection 객체를 생성한다.

```
String url = "jdbc:postgresql://[HOST]:[PORT]/[DATABASE]";
String username = "[USERNAME]";
String password = "[PASSWORD]";

Connection connection = null;

try {

    Class.forName("org.postgresql.Driver");
    connection = DriverManager.getConnection(url, username, password);

} catch (ClassNotFoundException e) {
    // Exception
} catch (SQLException e) {
    // Exception
}
```

(3) Statement 객체를 생성한다.

(4) ResultSet 객체를 생성한다.

(5) Query를 실행한다.

(6) ResultSet 객체로부터 데이터를 조회한다.

(7) ResultSet 객체를 닫는다.

(8) Statement 객체를 닫는다.

(9) Connection 객체를 닫는다. 

```
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;

List<Map<String, Object>> list = new ArrayList<>();

try {

    preparedStatement = dbConnection.prepareStatement("SELECT ID, NAME FROM USER");
    resultSet = preparedStatement.executeQuery();

    while (resultSet.next()) {
        System.out.println("ID : " + resultSet.getString("ID"));
        System.out.println("NAME : " + resultSet.getString("NAME"));
    }

} catch (SQLException e) {
    // Exception
} finally {
    resultSet.close();
    preparedStatement.close();
    dbConnection.close();
}
```

▷ 출처

[https://ittrue.tistory.com/250](https://ittrue.tistory.com/250)