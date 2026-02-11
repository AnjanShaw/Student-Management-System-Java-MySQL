# Student Management System (Java + MySQL)

This is a simple console-based project built using **Java and MySQL**.
It connects Java to a MySQL database using **JDBC** and allows basic student record management.

## Features

* Add student details to database
* View all students
* Delete student by ID
* Uses PreparedStatement for safe SQL queries
* Console menu-based interface

## Tech Used

* Java
* MySQL
* JDBC
* VS Code

## Database Table

**students**

* id (Auto Increment, Primary Key)
* name
* course
* marks

## How to Run

1. Create database in MySQL:

```sql
CREATE DATABASE student_db;
```

2. Create table:

```sql
CREATE TABLE students(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  course VARCHAR(50),
  marks INT
);
```

3. Compile:

```
javac -cp ".;lib/mysql-connector-j-9.6.0.jar" Main.java
```

4. Run:

```
java -cp ".;lib/mysql-connector-j-9.6.0.jar" Main
```

## Author

Anjan Shaw
BCA Student
