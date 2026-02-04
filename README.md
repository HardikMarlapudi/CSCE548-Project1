# CSCE548 – Project 1  
## Weather Management System

### Author
Hardik Marlapudi  

### Course
CSCE 548 – Database Systems / Software Engineering  

---

## Project Overview
The Weather Management System is a console-based Java application designed to store, manage, and retrieve weather data using a relational database. The system tracks weather conditions by city and station, including temperature, humidity, and recorded dates. It also supports location-based weather alerts.

This project demonstrates database design, SQL scripting, CRUD operations, and integration between a Java data access layer and a MySQL database.

---

## Technologies Used
- **Java (JDK 21)**
- **MySQL Community Edition**
- **JDBC (MySQL Connector/J)**
- **MySQL Workbench**
- **GitHub**

---

## Database Design

### Tables
The database consists of the following five tables:
1. `locations` – Stores city, state, and country information
2. `stations` – Represents weather stations associated with locations
3. `weather_conditions` – Defines possible weather conditions (Sunny, Rainy, Cloudy)
4. `weather_records` – Stores daily weather data (temperature, humidity, date)
5. `alerts` – Stores weather alerts associated with locations

### Relationships
- A location can have multiple stations
- A station can have multiple weather records
- Each weather record references a weather condition
- A location can have multiple alerts

---

## Test Data
The database is populated with **50 weather records** across multiple cities and stations to satisfy project requirements. Test data is inserted using SQL scripts.

---

## Project Structure

src/
├── main/
│   └── Main.java
├── db/
│   └── DBConnection.java
├── model/
│   ├── WeatherRecord.java
│   ├── Alert.java
│   └── Station.java
├── dao/
│   ├── WeatherRecordDAO.java
│   ├── AlertDAO.java
│   └── StationDAO.java
