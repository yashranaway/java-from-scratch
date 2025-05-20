# Student Record System

A simple student record management system that demonstrates inheritance, JDBC, and GUI concepts.

## Features
- Add/Edit/Delete student records
- View student list
- Search students
- Calculate grades
- Store data in SQLite database

## ER Diagram
```
[Person]
    |
    | (inherits)
    v
[Student]
    |
    | (has many)
    v
[Course]
    |
    | (has many)
    v
[Grade]
```

## Database Schema
```sql
CREATE TABLE students (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    age INTEGER,
    email TEXT UNIQUE
);

CREATE TABLE courses (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    credits INTEGER
);

CREATE TABLE grades (
    student_id INTEGER,
    course_id INTEGER,
    grade REAL,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);
```

## How to Run
1. Ensure SQLite JDBC driver is in classpath
2. Run `StudentRecordSystem.java`
3. Use the GUI to manage student records

## Dependencies
- SQLite JDBC Driver
- Java Swing 