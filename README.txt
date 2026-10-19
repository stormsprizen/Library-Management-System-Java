PROJECT REPORT
PROJECT ASSESSMENT — LIBRARY MANAGEMENT SYSTEM
JAVA TRAINING • AIMT

Student Name: ______________________________
Class / Section: ____________________________
Roll Number: _______________________________
College: Ambalika Institute of Management and Technology (AIMT)

1. PROJECT OBJECTIVE
The objective of this project is to create a simple, menu-driven Library Management System using Core Java and Object-Oriented Programming (OOP). It helps a staff member view books, search by title, borrow a book, return a book, and check the library summary.

2. PROBLEM STATEMENT
Keeping track of books manually can take time and may cause mistakes. This program stores a fixed collection of books and updates their availability when books are borrowed or returned. It is a console-based project and does not require a database or graphical user interface.

3. FEATURES
1. Display all books with ID, title, author, and availability.
2. Search using a full title or part of a title. The search is case-insensitive.
3. Borrow a book using its ID.
4. Return a borrowed book using its ID.
5. Show total, available, and borrowed book counts.
6. Validate invalid menu choices, invalid IDs, and non-numeric input.
7. Exit safely using menu option 0.

4. OOP CONCEPTS USED
• Class: Book represents an individual book. Library manages the collection. Main starts the program and displays the menu.
• Object: Each Book object represents one book. A Library object manages the books.
• Encapsulation: Book fields are private. Public getter methods and methods for borrowing/returning control access to the data.
• Constructor: The Book constructor initializes each book's ID, title, author, and initial availability.
• Methods: Separate methods handle displaying, searching, borrowing, returning, and summary calculations.

5. USE OF ARRAYS
A Book[] array stores the six sample Book objects. Loops process the array to display books, search by title, find an ID, and count available and borrowed books. The collection is fixed in this beginner-level version.

6. USE OF STRINGS
String variables store book titles, authors, menu input, and search text. The search uses trim() to remove extra spaces and toLowerCase() with contains() to find a title or part of a title without case sensitivity.

7. JAVA FUNDAMENTALS USED
• Scanner for keyboard input.
• while loop to repeat the menu.
• for-each loops to process the books array.
• if-else conditions to check availability and validate book IDs.
• switch statement to handle the main menu.
• try-catch to handle non-numeric input without crashing.
• Boolean values to track whether a book is available.

8. MENU OPTIONS
1 — Display all books
2 — Search book by title
3 — Borrow a book
4 — Return a book
5 — Show library summary
0 — Exit

9. SAMPLE INPUT / OUTPUT
Example: Borrowing book ID 101

Enter your choice: 3
Enter book ID to borrow: 101
Book borrowed successfully: Java Basics

Example: Showing summary after borrowing book ID 101

========== LIBRARY SUMMARY ==========
Total books     : 6
Available books : 5
Borrowed books  : 1
=====================================

Example: Searching for "java"

Enter your choice: 2
Enter full title or part of title: java
ID    Title                              Author                      Status
-------------------------------------------------------------------------------
101   Java Basics                        Herbert Schildt              Borrowed

10. TESTING
• Display all books: verifies that all six books appear with their details.
• Search an existing title: displays matching books.
• Search a missing title: displays a clear “No book found” message.
• Borrow an available book: changes its status to Borrowed.
• Borrow the same book again: prevents a second borrowing.
• Return a borrowed book: changes its status to Available.
• Return an available book: displays a helpful message.
• Invalid book ID or menu choice: displays an error message without crashing.
• Summary: available books plus borrowed books always equals the total.

11. CHALLENGES FACED
The main challenges were keeping the availability status correct, searching titles without case sensitivity, checking book IDs, and handling invalid user input. These were managed using methods, conditions, loops, and input validation.

12. LIMITATIONS
This is a beginner console application. Book status is stored in memory, so changes are reset when the program is closed. It does not use a database, GUI, or member accounts, as these are outside the required scope.

13. CONCLUSION
The Library Management System demonstrates the basic use of classes, objects, constructors, encapsulation, arrays, strings, loops, conditions, switch statements, and methods in Java. It provides the main functions required for a small library and can be extended in the future.

HOW TO RUN
1. Install a Java JDK.
2. Keep Main.java and README.txt in the same project folder.
3. Open Command Prompt/Terminal in that folder.
4. Compile: javac Main.java
5. Run: java Main

Note: Replace the blank student details at the top of this report before submitting.
