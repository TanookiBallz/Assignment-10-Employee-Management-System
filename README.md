﻿# Assignment-10-Employee-Management-System
![image](https://github.com/user-attachments/assets/50f6104e-d127-44bf-9551-57799178aa10)
![Screenshot 2024-12-01 001506](https://github.com/user-attachments/assets/cf3f8bbf-3870-437f-aaf0-0b46394cff73)

Instructions on How to Run the Program
1. Prerequisites
Before running the program, ensure you have the following installed and configured:

Java Development Kit (JDK) 17 or later.
JavaFX SDK (Download from the JavaFX official site).
An Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans (recommended for easier setup).
2. Setup
Download/Clone the Project Files:

Place the Java source files (EmployeeManagementApp.java, FullTimeEmployee.java, PartTimeEmployee.java, Contractor.java) in the same project or package.
Add JavaFX to the Project:

IntelliJ IDEA:
Go to File > Project Structure > Libraries.
Add the path to your JavaFX SDK's lib folder.
Update the VM options:
css

--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
Eclipse:
Right-click the project and select Build Path > Configure Build Path.
Add the JavaFX SDK lib folder to the library.
Add the VM options as shown above.
3. Run the Program
Open the EmployeeManagementApp.java file.
Run the program:
In IntelliJ IDEA: Right-click on the EmployeeManagementApp class and select Run 'EmployeeManagementApp'.
In Eclipse: Right-click on the class, select Run As > Java Application.
From Command Line:
Navigate to the project directory.
Compile the code:
bash

javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml *.java
Run the application:
bash

java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml EmployeeManagementApp
4. Using the Application
Add Employees:
Fill in the name, type (Full-time, Part-time, Contractor), salary, and (if applicable) hours worked.
Click the "Add Employee" button to add the employee to the table.
View Employees:
The table displays the list of employees with their names, types, and calculated salaries.
Remove Employees:
Select an employee in the table and click the "Remove Selected" button to delete the record.
Calculate Salaries:
Salaries are automatically updated and displayed in the table.
