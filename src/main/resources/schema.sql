DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS phones;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    mail VARCHAR(255),
    created TIMESTAMP,
    modified TIMESTAMP,
    password VARCHAR(255));

CREATE TABLE phones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(10),
    city_code VARCHAR(10),
    country_code VARCHAR(10),
    users_id INT,
    FOREIGN KEY (users_id) REFERENCES users(id));