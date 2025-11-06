CREATE DATABASE IF NOT EXISTS zipcode;
USE zipcode;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET NAMES utf8mb4 */;

-- ======================
-- Tabelas "pai" primeiro
-- ======================

CREATE TABLE `states` (
                          `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
                          `name` VARCHAR(95) NOT NULL,
                          `initials` VARCHAR(10) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `cities` (
                          `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
                          `state_id` INT(10) UNSIGNED NOT NULL,
                          `name` VARCHAR(95) NOT NULL,
                          `slug` VARCHAR(95) NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `ix_cities_state` (`state_id`)
) ENGINE=InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `districts` (
                             `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `city_id` INT(10) UNSIGNED NOT NULL,
                             `name` VARCHAR(95) NOT NULL,
                             `slug` VARCHAR(95) NOT NULL,
                             PRIMARY KEY (`id`),
                             KEY `ix_districts_city` (`city_id`)
) ENGINE=InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `address_searchs` (
                                   `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
                                   `city_id` INT(10) UNSIGNED NOT NULL,
                                   `district_id` INT(11) DEFAULT NULL,
                                   `address` VARCHAR(255) DEFAULT NULL,
                                   `postal_code` VARCHAR(15) DEFAULT NULL,
                                   `latitude` VARCHAR(20) DEFAULT NULL,
                                   `longitude` VARCHAR(20) DEFAULT NULL,
                                   `ddd` INT(2) DEFAULT NULL,
                                   PRIMARY KEY (`id`),
                                   KEY `ix_as_city` (`city_id`),
                                   KEY `ix_as_district` (`district_id`),
                                   KEY `ix_as_postal_code` (`postal_code`)
) ENGINE=InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- ==========================
-- Tabela dependente (filha)
-- ==========================

CREATE TABLE `address_points` (
                                  `id` INT(10) NOT NULL AUTO_INCREMENT,
                                  `address_search_id` INT(10) UNSIGNED NOT NULL,  -- **bate com o pai (UNSIGNED)**
                                  `number` VARCHAR(20) NOT NULL,
                                  `complement` VARCHAR(80) NULL,
                                  `reference_note` VARCHAR(120) NULL,
                                  `postal_code` CHAR(9) NOT NULL,
                                  `latitude` DECIMAL(9,6) NULL,
                                  `longitude` DECIMAL(9,6) NULL,
                                  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- colunas geradas (sem COLLATE aqui; herdam o da coluna base)
                                  `number_norm` VARCHAR(20) AS (LOWER(TRIM(`number`))) STORED,
                                  `complement_norm` VARCHAR(80) AS (LOWER(TRIM(IFNULL(`complement`,'')))) STORED,

                                  UNIQUE KEY `ux_ap_unique` (`address_search_id`, `number_norm`, `complement_norm`, `postal_code`),
                                  KEY `ix_ap_address_search` (`address_search_id`),
                                  KEY `ix_ap_postal_code` (`postal_code`),

                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- ======================
-- FKs ao final (ordem!)
-- ======================

ALTER TABLE `cities`
    ADD CONSTRAINT `fk_cities_states`
        FOREIGN KEY (`state_id`) REFERENCES `states`(`id`)
            ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE `districts`
    ADD CONSTRAINT `fk_districts_city`
        FOREIGN KEY (`city_id`) REFERENCES `cities`(`id`)
            ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE `address_searchs`
    ADD CONSTRAINT `fk_address_searchs_cities`
        FOREIGN KEY (`city_id`) REFERENCES `cities`(`id`)
            ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE `address_points`
    ADD CONSTRAINT `fk_ap_address_search`
        FOREIGN KEY (`address_search_id`) REFERENCES `address_searchs`(`id`)
            ON UPDATE CASCADE ON DELETE RESTRICT;

-- ======================
-- (Opcional) seeds de AI
-- ======================
-- Caso precise iniciar os AUTO_INCREMENT de forma específica:
-- ALTER TABLE `states`          AUTO_INCREMENT = 28;
-- ALTER TABLE `cities`          AUTO_INCREMENT = 10531;
-- ALTER TABLE `districts`       AUTO_INCREMENT = 47811;
-- ALTER TABLE `address_searchs` AUTO_INCREMENT = 1010043;

COMMIT;
