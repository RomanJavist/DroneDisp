CREATE TABLE `drone`
(
    `id`           varchar(5)  NOT NULL,
    `model`        varchar(40) NOT NULL,
    `load`         int         DEFAULT 0,
    `load_max`     int         DEFAULT 100,
    `battery_left` int         DEFAULT 100,
    `state`        varchar(20) DEFAULT 'IDLE',
    PRIMARY KEY (`id`)
);
CREATE TABLE `medication`
(
    `code`   varchar(5)  NOT NULL,
    `name`   varchar(40) NOT NULL,
    `weight` int          DEFAULT 10,
    `image`  varchar(100) DEFAULT NULL,
    PRIMARY KEY (`code`)
);
CREATE TABLE `load`
(
    `id`         varchar(5) NOT NULL,
    `drone`      varchar(5) NOT NULL,
    `medication` varchar(5) NOT NULL,
    `quantity`   int DEFAULT 0,
    PRIMARY KEY (`id`)
);