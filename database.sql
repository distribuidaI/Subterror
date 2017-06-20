use subterror;

CREATE TABLE `event_type`(
  `id` int(255) AUTO_INCREMENT not NULL ,
  `description` VARCHAR(255),
  CONSTRAINT PRIMARY KEY(`id`)
)ENGINE=InnoDb;

CREATE TABLE `station`(
  `id` int(255) AUTO_INCREMENT not NULL ,
  `line` varchar(255),
  `station` varchar(255),
  CONSTRAINT PRIMARY KEY(`id`)
)ENGINE=InnoDb;

CREATE TABLE `event`(
  `id` int(255) AUTO_INCREMENT not null ,
  `station` int(255) not null,
  `event_type` int(255) not null,
  `date` DATETIME,
  `sense` varchar(255),
  CONSTRAINT PRIMARY KEY(`id`),
  CONSTRAINT FOREIGN KEY(`station`) REFERENCES station(`id`),
  CONSTRAINT FOREIGN KEY(`event_type`) REFERENCES event_type(`id`)
)ENGINE=InnoDb;