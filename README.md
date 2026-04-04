# Personal Finance Dashboard - Backend

Namaste! This is the backend service for my Finance Dashboard project. 
I built this using **Spring Boot** to help manage personal expenses and income effectively.

## Features
- **User Management**: Simple registration for different roles.
- **Financial Tracking**: Add, view, and calculate income/expenses.
- **Dashboard Summary**: Real-time calculation of Net Balance.
- **Role-Based Security**: 
  - `ADMIN`: Full access (can delete records).
  - `ANALYST`: Can add and view data.
  - `VIEWER`: Read-only access to dashboard.

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Security (Basic Auth)
- MySQL Database
- Hibernate/JPA

## How I Ran This
1. Configured MySQL in `application.properties`.
2. Tested all endpoints using **Postman**.
3. Verified data integrity directly in MySQL terminal.

## 🧪 Default Test Accounts
When you run the application, it automatically creates these users for testing Role-Based Access:

* **Admin:** `admin@zorvyn.com` | Password: `admin123` *(Can view, add, and delete)*
* **Analyst:** `analyst@zorvyn.com` | Password: `analyst123` *(Can view and add)*
* **Viewer:** `viewer@zorvyn.com` | Password: `viewer123` *(Can only view dashboard)*