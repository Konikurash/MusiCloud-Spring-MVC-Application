# MusiCloud Spring MVC Application
This project was created by Brendan Brooks and William Bierer for their CST-341 (Open Source Computing) course at GCU. This project is to exemplify full-stack knowledge for building a Spring MVC application.
The idea behind this project was to create a web application that would serve as a cloud storage for people to keep and stream all of their music. This is not intended to become a real product.

### Project Features
- Account creation and registration
- Update account information and password
- Add a song to your library
- edit song information from your library
- Modern UI using custom CSS with Bootstrap CSS as the foundation
  - jQuery was used throughout the application as well

## N-Layer Architecture
This project features an N-Layer architecture:
- Data Access Layer
- Business Service Layer
- Presentation Layer

## User Accounts
User accounts work by authenticating login credentials with the database, using the `LoginCredentialsModel`. A `UserModel` is then stored in the HTTP session so the application can know if the user is logged-in or not. If the user tries accessing any non-login page, they will be automatically redirected out.

## ER Diagram
![alt text](https://cdn.discordapp.com/attachments/210313100342067201/525215274522116120/unknown.png)

## UML Class Diagrams
![alt text](https://cdn.discordapp.com/attachments/210313100342067201/525214683720974346/UMLClassDiagrams-Page-1.png)
