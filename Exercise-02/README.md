# Training System – Java Implementation

## 📌 Problem Description

A training system needs to keep track of students and the courses they are enrolled in.

### Requirements
- Each student can register for multiple courses
- The system must efficiently:
    - Retrieve all courses for a given student
    - Determine which student(s) are enrolled in the highest number of courses
- Prevent duplicate course enrollment
- Handle invalid operations with meaningful exceptions

---

## 🧠 Design Overview

The system is built using core Java collections:

- `Map<Student, Set<Course>>`
    - **Key** → Student
    - **Value** → Set of enrolled courses

This design provides:
- **O(1)** average-time lookups
- No duplicate course registrations
- Clean separation between domain and logic

---

## 🏗️ Project Structure
    org.TechPioneers.exercise02
    │
    ├── TrainingSystem.java
    ├── Student.java
    ├── Course.java
    ├── Main.java
    │
    └── exceptions
        ├── StudentNotFoundException.java
        └── CourseNotEnrolledException.java


---

## ⚙️ Key Classes

### `Student`
- Immutable
- Identified uniquely by `id`
- Safe to use as a `Map` key

### `Course`
- Identified uniquely by `id`
- Stored inside `Set` to prevent duplicates

### `TrainingSystem`
Responsible for:
- Registering students
- Subscribing / unsubscribing courses
- Retrieving enrolled courses
- Finding students with the highest course count

---

## 🚨 Exception Handling

Custom domain exceptions are used:

- `StudentNotFoundException`  
  → Thrown when an operation is attempted on a non-existing student

- `CourseNotEnrolledException`  
  → Thrown when attempting to remove a course the student is not enrolled in

---

## 🧪 Testing

Manual tests are provided in `Main.java` and cover:
- Normal enrollment flow
- Course removal
- Exception scenarios
- Tie cases for highest enrolled students

Run `Main.java` to execute all tests.

---

## ⏱️ Complexity Analysis

| Operation | Time Complexity |
|--------|----------------|
| Subscribe | O(1) |
| Unsubscribe | O(1) |
| Retrieve courses | O(1) |
| Find top students | O(n) |

Space Complexity: **O(n + m)**  
(where `n` = students, `m` = enrollments)

---

## ✅ Summary

This solution:
- Uses efficient data structures
- Follows Java best practices
- Is readable, testable, and extensible
- Is suitable for interviews and production-level code

