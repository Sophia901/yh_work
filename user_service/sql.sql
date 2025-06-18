

create database db0;
use db0;
CREATE TABLE user_0 (
                      user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      email varchar(100),
                      phone varchar(20),
                      gmt_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create database db1;
use db1;
CREATE TABLE user_1 (
                        user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(50) NOT NULL UNIQUE,
                        password VARCHAR(255) NOT NULL,
                        email varchar(100),
                        phone varchar(20),
                        gmt_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);