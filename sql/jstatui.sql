CREATE DATABASE jstatui;

DROP TABLE IF EXISTS `jstatui`.`jstat_host`;
CREATE TABLE `jstatui`.`jstat_host` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host` VARCHAR(45) NOT NULL,
  `port` INTEGER UNSIGNED NOT NULL,
  `jvm_process_id` VARCHAR(45) NOT NULL,
  `jvm_start_time` TIMESTAMP NOT NULL,
  `active` TINYINT UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY(`id`),
  UNIQUE `unique_indx` (`host`, `port`, `jvm_process_id`, `jvm_start_time`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `jstatui`.`jstat_class`;
CREATE TABLE `jstatui`.`jstat_class` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `loaded_classes` INTEGER DEFAULT -9,
  `loaded_bytes` FLOAT DEFAULT -9,
  `unloaded_classes` INTEGER DEFAULT -9,
  `unloaded_bytes` FLOAT DEFAULT -9,
  `time_consumed` FLOAT DEFAULT -9,
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_class_jstat_host` FOREIGN KEY `FK_jstat_class_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
ENGINE = InnoDB DEFAULT CHARSET=utf8;