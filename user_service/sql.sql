create database user_db;
use user_db;
CREATE TABLE user (
                      user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      email varchar(100),
                      phone varchar(20),
                      gmt_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);