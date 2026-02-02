INSERT INTO locations (city, state, country) VALUES
('Columbia', 'SC', 'USA'),
('New York', 'NY', 'USA');

INSERT INTO weather_conditions (description) VALUES
('Sunny'),
('Rainy'),
('Cloudy');

INSERT INTO weather_records (location_id, condition_id, temperature, humidity, record_date) VALUES
(1, 1, 75.5, 60, '2025-01-01'),
(1, 2, 68.2, 80, '2025-01-02');

INSERT INTO users (name, email) VALUES
('Alice', 'alice@email.com'),
('Bob', 'bob@email.com');

INSERT INTO alerts (user_id, location_id, message) VALUES
(1, 1, 'Heavy rain expected'),
(2, 2, 'High temperature warning');
