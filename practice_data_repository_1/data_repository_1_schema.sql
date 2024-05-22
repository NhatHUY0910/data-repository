-- create database data_repository_1;

use data_repository_1;

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    province_id INT NOT NULL,
    FOREIGN KEY (province_id) REFERENCES provinces(id)
);

-- create table provinces(
-- 	id int auto_increment primary key,
--     name varchar(255) not null
-- );