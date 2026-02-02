CREATE DATABASE weather_db;
USE weather_db;

CREATE TABLE locations (
    location_id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(100),
    state VARCHAR(50),
    country VARCHAR(50)
);

CREATE TABLE weather_conditions (
    condition_id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(50)
);

CREATE TABLE weather_records (
    record_id INT AUTO_INCREMENT PRIMARY KEY,
    location_id INT,
    condition_id INT,
    temperature DECIMAL(5,2),
    humidity INT,
    record_date DATE,
    FOREIGN KEY (location_id) REFERENCES locations(location_id),
    FOREIGN KEY (condition_id) REFERENCES weather_conditions(condition_id)
);

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE alerts (
    alert_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    location_id INT,
    message VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (location_id) REFERENCES locations(location_id)
);
