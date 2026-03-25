# CSCE 548 – Weather Microservices System

**Author:** Hardik Marlapudi  
**Course:** CSCE 548 – Enterprise Software Architecture  
**University:** University of South Carolina  

---

# Project Overview

This project implements a **Weather Information System using a microservices architecture in Java**.  
The application manages weather records, alerts, and locations through separate services and provides a **web-based UI dashboard** to interact with the system.

The system demonstrates:

- REST-style service communication  
- Microservice separation  
- CRUD operations  
- JSON-based data exchange  
- Frontend UI integration  
- Database-backed persistence  

---

# System Architecture

The system consists of **three backend services and a frontend UI**.

Frontend UI (GitHub Pages / Local Web UI)  
↓  
Weather Service (Port 8081)  
↓  
Alert Service (Port 8082)  
↓  
Location Service (Port 8083)  
↓  
MySQL Database  

---

# Services

## Weather Service (Port 8081)

Handles all weather record operations.

### Features
- View weather records  
- Add new weather records  
- Update weather records  
- Delete weather records  
- Returns weather data in JSON format  

### API Endpoints
- GET /weather  
- POST /weather  
- PUT /weather/{id}  
- DELETE /weather/{id}  

---

## Alert Service (Port 8082)

Handles weather alerts.

### Features
- Retrieve alert list  
- Add new alerts  

### API Endpoints
- GET /alerts  
- POST /alerts  

---

## Location Service (Port 8083)

Handles location information.

### Features
- Retrieve weather station locations  

### API Endpoints
- GET /locations  

---

# Frontend UI

The project includes a **simple weather dashboard UI** built with:

- HTML  
- CSS  
- JavaScript  

### Features
- View weather records  
- Add new weather record  
- Edit existing weather record  
- Delete weather record  
- View alerts  
- View locations  

Weather cards display:
- City  
- State  
- Condition  
- Temperature  
- Humidity  
- Date  

---

# Technologies Used

## Backend
- Java  
- Java HTTP Server  
- JDBC  
- MySQL  
- JSON  

## Frontend
- HTML  
- CSS  
- JavaScript  
- Fetch API  

## Tools
- VS Code  
- Git  
- GitHub  
- GitHub Pages  
- Node.js  

---

# Project Folder Structure

CSCE548-SemesterProject
│
├── src
│ ├── WeatherService.java
│ ├── AlertService.java
│ ├── LocationService.java
│ ├── DAO classes
│ └── Business logic classes
│
├── web
│ ├── index.html
│ ├── script.js
│ └── styles.css
│
├── sql
│ └── database schema and setup
│
├── screenshots
│ └── UI screenshots
│
├── package.json
└── README.md


---

# Database Setup

### Step 1 – Install MySQL
Make sure MySQL server is installed.

---

### Step 2 – Start MySQL (IMPORTANT)

You must start MySQL before running the backend services.

#### Mac (Homebrew)
```bash
brew services start mysql

mysql.server start

Windows
Open Services
Find MySQL
Click Start

Linux
sudo systemctl start mysql

Step 3 – Verify MySQL is Running
mysql -u root -p

Step 4 – Create Database
CREATE DATABASE weatherdb;

Step 5 – Import Database Schema
mysql -u root -p weatherdb < sql/weatherdb.sql


Step 6 – Configure Database Connection
Update credentials inside:

src/DBConnection.java

Example:
String url = "jdbc:mysql://localhost:3306/weatherdb";
String username = "root";
String password = "your_password";

MySQL Troubleshooting
If MySQL fails to start:

Common Error
ERROR! The server quit without updating PID file

Fix
pkill mysqld
rm -rf /opt/homebrew/var/mysql/*.pid
rm -rf /opt/homebrew/var/mysql/*.err
brew services restart mysql

Quick Fix (30 seconds)
pkill mysqld
brew services restart mysql

How to Compile and Run the Application

Step 1 – Clone the Repository

git clone https://github.com/HardikMarlapudi/CSCE548-SemesterProject.git
cd CSCE548-SemesterProject

Step 2 – Compile the Java Services

cd src
javac -cp ".:../lib/*" *.java

Step 3 – Start the Microservices

java -cp ".:../lib/*" ServiceLauncher

Expected output:

Starting Weather Microservices...
All services initialized.

Weather Service running at http://localhost:8081/weather
Alert Service running at http://localhost:8082/alerts
Location Service running at http://localhost:8083/locations

Step 4 – Start the Frontend UI

cd ../web

Open:

index.html

Or:

npx live-server

Accessing the System

Frontend UI:

web/index.html

Weather API:

http://localhost:8081/weather

Alert API:

http://localhost:8082/alerts

Location API:

http://localhost:8083/locations
GitHub Pages Deployment
npm install
npm run deploy

URL:

https://HardikMarlapudi.github.io/CSCE548-SemesterProject/

Example Startup Flow
git clone https://github.com/HardikMarlapudi/CSCE548-SemesterProject.git
cd CSCE548-SemesterProject/src
javac -cp ".:../lib/*" *.java
java -cp ".:../lib/*" ServiceLauncher

Future Improvements
Docker containerization
Cloud deployment
Authentication
UI improvements
Real-time API integration
Kubernetes
