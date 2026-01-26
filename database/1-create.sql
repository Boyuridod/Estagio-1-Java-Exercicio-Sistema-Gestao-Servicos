CREATE DATABASE IF NOT EXISTS service_management;

USE service_management;

CREATE TABLE IF NOT EXISTS services(
	id INTEGER NOT NULL AUTO_INCREMENT,
    descrip VARCHAR(1000),
    service_type VARCHAR(100),
    begin_date DATETIME,
    end_date DATETIME,
    stats VARCHAR(50),
    priority VARCHAR(50),
    lang VARCHAR(100),
    where_happened VARCHAR(1000),
    what_happened VARCHAR(1000),
    how_solved VARCHAR(1000),
    
    PRIMARY KEY (id)
);