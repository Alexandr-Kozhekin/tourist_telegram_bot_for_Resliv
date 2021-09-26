SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS TOURIST_TELEGRAM_BOT_V0_2 DEFAULT CHARACTER SET utf8 ;
USE TOURIST_TELEGRAM_BOT_V0_2 ;

CREATE TABLE IF NOT EXISTS CITIES (
    city_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(100) NOT NULL
)

ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS INFOS (
    info_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    city_info TEXT NOT NULL
)

ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS CITIES_INFOS (
    city_id BIGINT NOT NULL,
    info_id BIGINT NOT NULL,
	FOREIGN KEY (city_id) REFERENCES CITIES (city_id),
    FOREIGN KEY (info_id) REFERENCES INFOS (info_id)
);

CREATE INDEX ix_city_info_city_id
ON CITIES_INFOS (city_id);