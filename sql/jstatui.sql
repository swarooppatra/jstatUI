CREATE DATABASE IF NOT EXISTS `jstatui`;

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
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_compiler`;
CREATE TABLE `jstatui`.`jstat_compiler` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `compiled` INTEGER DEFAULT -9,
  `failed` INTEGER DEFAULT -9,
  `invalid` INTEGER DEFAULT -9,
  `time_spent` FLOAT DEFAULT -9,
  `failed_type` INTEGER DEFAULT -9,
  `failed_method` VARCHAR(200) DEFAULT '',
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_compiler_jstat_host` FOREIGN KEY `FK_jstat_compiler_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_gc`;
CREATE TABLE `jstatui`.`jstat_gc` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `S0C`  FLOAT DEFAULT -9,
  `S1C` FLOAT DEFAULT -9,
  `S0U` FLOAT DEFAULT -9,
  `S1U` FLOAT DEFAULT -9,
  `EC` FLOAT DEFAULT -9,
  `EU` FLOAT DEFAULT -9,
  `OC` FLOAT DEFAULT -9,
  `OU` FLOAT DEFAULT -9,
  `PC` FLOAT DEFAULT -9,
  `PU` FLOAT DEFAULT -9,
  `YGC` INTEGER DEFAULT -9,
  `YGCT` FLOAT DEFAULT -9,
  `FGC` INTEGER DEFAULT -9,
  `FGCT` FLOAT DEFAULT -9,
  `GCT` FLOAT DEFAULT -9,
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_gc_jstat_host` FOREIGN KEY `FK_jstat_gc_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_gccapacity`;
CREATE TABLE `jstatui`.`jstat_gccapacity` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `NGCMN` FLOAT DEFAULT -9,
  `NGCMX` FLOAT DEFAULT -9,
  `NGC` FLOAT DEFAULT -9,
  `S0C` FLOAT DEFAULT -9,
  `S1C` FLOAT DEFAULT -9,
  `EC` FLOAT DEFAULT -9,
  `OGCMN` FLOAT DEFAULT -9,
  `OGCMX` FLOAT DEFAULT -9,
  `OGC` FLOAT DEFAULT -9,
  `OC` FLOAT DEFAULT -9,
  `PGCMN` FLOAT DEFAULT -9,
  `PGCMX` FLOAT DEFAULT -9,
  `PGC` FLOAT DEFAULT -9,
  `PC` FLOAT DEFAULT -9,
  `YGC` INTEGER DEFAULT -9,
  `FGC` INTEGER DEFAULT -9,
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_gccapacity_jstat_host` FOREIGN KEY `FK_jstat_gccapacity_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_gccause`;
CREATE TABLE `jstatui`.`jstat_gccause` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `S0` FLOAT DEFAULT -9, 
  `S1` FLOAT DEFAULT -9,
  `E` FLOAT DEFAULT -9,
  `O` FLOAT DEFAULT -9,
  `P` FLOAT DEFAULT -9,
  `YGC` INTEGER DEFAULT -9,
  `YGCT` FLOAT DEFAULT -9,
  `FGC` INTEGER DEFAULT -9,
  `FGCT` FLOAT DEFAULT -9,
  `GCT` FLOAT DEFAULT -9,
  `LGCC` VARCHAR(200) DEFAULT '-9',
  `GCC`  VARCHAR(200) DEFAULT '-9',
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_gccause_jstat_host` FOREIGN KEY `FK_jstat_gccause_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_gcnew`;
CREATE TABLE `jstatui`.`jstat_gcnew` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `S0C` FLOAT DEFAULT -9,
  `S1C` FLOAT DEFAULT -9,
  `S0U` FLOAT DEFAULT -9,
  `S1U` FLOAT DEFAULT -9,
  `TT` INTEGER DEFAULT -9,
  `MTT` INTEGER DEFAULT -9,
  `DSS` FLOAT DEFAULT -9,
  `EC` FLOAT DEFAULT -9,
  `EU` FLOAT DEFAULT -9,
  `YGC` INTEGER DEFAULT -9,
  `YGCT` FLOAT DEFAULT -9,
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_gcnew_jstat_host` FOREIGN KEY `FK_jstat_gcnew_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_gcnewcapacity`;
CREATE TABLE `jstatui`.`jstat_gcnewcapacity` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `NGCMN` FLOAT DEFAULT -9,
  `NGCMX` FLOAT DEFAULT -9,
  `NGC` FLOAT DEFAULT -9,
  `S0CMX` FLOAT DEFAULT -9,
  `S0C` FLOAT DEFAULT -9,
  `S1CMX` FLOAT DEFAULT -9,
  `S1C` FLOAT DEFAULT -9,
  `ECMX` FLOAT DEFAULT -9,
  `EC` FLOAT DEFAULT -9,
  `YGC` INTEGER DEFAULT -9,
  `FGC` INTEGER DEFAULT -9,
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_gcnewcapacity_jstat_host` FOREIGN KEY `FK_jstat_gcnewcapacity_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_gcold`;
CREATE TABLE `jstatui`.`jstat_gcold` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `PC` FLOAT DEFAULT -9,
  `PU` FLOAT DEFAULT -9,
  `OC` FLOAT DEFAULT -9,
  `OU` FLOAT DEFAULT -9,
  `YGC` INTEGER DEFAULT -9,
  `FGC` INTEGER DEFAULT -9,
  `FGCT` FLOAT DEFAULT -9,
  `GCT` FLOAT DEFAULT -9,
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_gcold_jstat_host` FOREIGN KEY `FK_jstat_gcold_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_gcoldcapacity`;
CREATE TABLE `jstatui`.`jstat_gcoldcapacity` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `OGCMN` FLOAT DEFAULT -9,
  `OGCMX` FLOAT DEFAULT -9,
  `OGC` FLOAT DEFAULT -9,
  `OC` FLOAT DEFAULT -9,
  `YGC` INTEGER DEFAULT -9,
  `FGC` INTEGER DEFAULT -9,
  `FGCT` FLOAT DEFAULT -9,
  `GCT` FLOAT DEFAULT -9,
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_gcoldcapacity_jstat_host` FOREIGN KEY `FK_jstat_gcoldcapacity_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_gcpermcapacity`;
CREATE TABLE `jstatui`.`jstat_gcpermcapacity` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `PGCMN` FLOAT DEFAULT -9,
  `PGCMX` FLOAT DEFAULT -9,
  `PGC` FLOAT DEFAULT -9,
  `PC` FLOAT DEFAULT -9,
  `YGC` INTEGER DEFAULT -9,
  `FGC` INTEGER DEFAULT -9,
  `FGCT` FLOAT DEFAULT -9,
  `GCT` FLOAT DEFAULT -9,
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_gcpermcapacity_jstat_host` FOREIGN KEY `FK_jstat_gcpermcapacity_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_gcutil`;
CREATE TABLE `jstatui`.`jstat_gcutil` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `S0` FLOAT DEFAULT -9,
  `S1` FLOAT DEFAULT -9,
  `E` FLOAT DEFAULT -9,
  `O` FLOAT DEFAULT -9,
  `P` FLOAT DEFAULT -9,
  `YGC` INTEGER DEFAULT -9,
  `YGCT` FLOAT DEFAULT -9,
  `FGC` INTEGER DEFAULT -9,
  `FGCT` FLOAT DEFAULT -9,
  `GCT` FLOAT DEFAULT -9,
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_gcutil_jstat_host` FOREIGN KEY `FK_jstat_gcutil_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jstatui`.`jstat_printcompilation`;
CREATE TABLE `jstatui`.`jstat_printcompilation` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` INTEGER UNSIGNED NOT NULL,
  `time_elasped` FLOAT UNSIGNED NOT NULL,
  `compiled` INTEGER DEFAULT -9, 
  `size` INTEGER DEFAULT -9,
  `type` INTEGER DEFAULT -9,
  `method` VARCHAR(100) DEFAULT '-9',
  PRIMARY KEY(`id`),
  CONSTRAINT `FK_jstat_printcompilation_jstat_host` FOREIGN KEY `FK_jstat_printcompilation_jstat_host` (`host_id`)
    REFERENCES `jstat_host` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `jstatui`.`jstat_custom_plot`;
CREATE  TABLE `jstatui`.`jstat_custom_plot` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `plot_name` VARCHAR(150) NOT NULL ,
  `type_and_param` VARCHAR(500) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `plot_name_UNIQUE` (`plot_name` ASC)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

truncate table jstat_class;
truncate table jstat_compiler;
truncate table jstat_gc;
truncate table jstat_gccapacity;
truncate table jstat_gccause;
truncate table jstat_gcnew;
truncate table jstat_gcnewcapacity;
truncate table jstat_gcold;
truncate table jstat_gcoldcapacity;
truncate table jstat_gcpermcapacity;
truncate table jstat_gcutil;
truncate table jstat_printcompilation;
truncate table jstat_custom_plot;