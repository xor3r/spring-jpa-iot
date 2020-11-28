/* Inserting sample values into tables */

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (1, 'I See You', 2017);
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (2, 'Coexist', 2012);
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (3, 'XX', 2009);
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (4, 'Hybrid Theory', 2000);
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (5, 'Meteora', 2003);
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (6, 'One More Light', 2017);
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (7, 'Xero', 1997);
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (8, 'Comatose', 2006);
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (9, 'Rise', 2013);
INSERT INTO `pazyniuk_jpa`.`album` (`id`, `name`, `year`) VALUES (10, 'Awake', 2009);
COMMIT;

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (1, 'Rock');
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (2, 'Pop');
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (3, 'Trance');
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (4, 'Folk');
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (5, 'Hip Hop');
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (6, 'Metal');
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (7, 'Electro');
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (8, 'Synthwave');
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (9, 'Indie');
INSERT INTO `pazyniuk_jpa`.`genre` (`id`, `name`) VALUES (10, 'Contemporary');
COMMIT;

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (1, 'Sony', 1929);
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (2, 'Universal', 1948);
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (3, 'Warner', 1931);
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (4, 'Island', 1959);
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (5, 'BMG', 2008);
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (6, 'ABC', 1994);
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (7, 'Virgin Records', 1972);
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (8, 'Red Hill', 1995);
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (9, 'Atlantic', 1947);
INSERT INTO `pazyniuk_jpa`.`record_label` (`id`, `title`, `year_established`) VALUES (10, 'Def Jam', 2004);
COMMIT;

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (1, 'Male');
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (2, 'Female');
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (3, 'Not Applicable');
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (4, 'Transsexual');
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (5, 'Transgender Man');
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (6, 'Transgender Woman');
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (7, 'Neither');
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (8, 'Both');
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (9, 'Intersex');
INSERT INTO `pazyniuk_jpa`.`gender` (`id`, `gender_type`) VALUES (10, 'Gender Fluid');
COMMIT;

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (1, 'UK');
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (2, 'USA');
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (3, 'Ukraine');
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (4, 'Russia');
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (5, 'Canada');
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (6, 'Spain');
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (7, 'Ireland');
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (8, 'Switzerland');
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (9, 'Germany');
INSERT INTO `pazyniuk_jpa`.`country` (`id`, `name`) VALUES (10, 'France');
COMMIT;

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (1, 'John Lennon', 1, 1);
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (2, 'Paul McCartney', 1, 1);
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (3, 'George Harrison', 1, 1);
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (4, 'Chester Charles Bennington', 1, 1);
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (5, 'Dolores O\'Riordan', 2, 2);
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (6, 'Robert Plant', 1, 1);
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (7, 'Jimmy Page', 1, 1);
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (8, 'Andriy Kuzmenko', 3, 1);
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (9, 'Neil Leslie Diamond', 2, 1);
INSERT INTO `pazyniuk_jpa`.`artist` (`id`, `name`, `country`, `gender`) VALUES (10, 'John Cooper', 1, 1);
COMMIT;

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (1, 1, 7, 'She Couldn\'t', 2, 4.99, 12342, 4);
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (2, 1, 7, 'In The End', 2, 4.99, 3453456, 4);
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (3, 1, 7, 'What I\'ve Done', 2, 5.99, 352341, 5);
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (4, 9, 8, 'I Dare You', 1, 9.99, 567215, 3);
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (5, 1, 10, 'Zombie', 3, 12.99, 4565672, 1);
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (6, 1, 6, 'Awake and Alive', 2, 4.99, 346235, 10);
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (7, 1, 6, 'Attack', 2, 4.99, 6478222, 10);
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (8, 1, 6, 'Hero', 2, 4.99, 3495295, 9);
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (9, 2, 4, 'Televisions', 6, 6.99, 293045, 3);
INSERT INTO `pazyniuk_jpa`.`song` (`id`, `genre`, `artist`, `name`, `record_label`, `price`, `download_count`, `album`) VALUES (10, 5, 2, 'If You Go Away', 1, 13.99, 1934938598, 5);
COMMIT;

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (1, '1234567890123456');
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (2, '1234567890123456');
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (3, '1234567890123456');
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (4, '1234567890123456');
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (5, '1234567890123456');
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (6, '1234567890123456');
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (7, '1234567890123456');
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (8, '1234567890123456');
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (9, '1234567890123456');
INSERT INTO `pazyniuk_jpa`.`credit_card` (`id`, `number`) VALUES (10, '1234567890123456');
COMMIT;

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (1, 'user_1', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'John', 'Smith', 1, 1);
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (2, 'user_2', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'John', 'Doe', 7, 3);
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (3, 'user_3', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'Alice', 'Cooper', 2, 5);
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (4, 'user_4', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'John', 'Cooper', 1, 2);
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (5, 'user_5', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'Patrick', 'Wirdle', 1, 10);
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (6, 'user_6', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'John', 'Cameron', 10, 8);
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (7, 'user_7', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'James', 'Oster', 9, 7);
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (8, 'user_8', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'Ann', 'Springs', 2, 9);
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (9, 'user_9', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'Mary', 'Caleb', 5, 6);
INSERT INTO `pazyniuk_jpa`.`itunes_user` (`id`, `username`, `password`, `joined_date`, `name`, `surname`, `gender`, `credit_card`) VALUES (10, 'user_10', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '1970-01-01 00:00:01', 'John', 'Rich', 1, 4);
COMMIT;

START TRANSACTION;
USE `pazyniuk_jpa`;
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (1, 2);
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (1, 4);
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (4, 3);
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (4, 5);
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (4, 7);
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (5, 4);
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (9, 6);
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (9, 7);
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (9, 10);
INSERT INTO `pazyniuk_jpa`.`user_song` (`user_id`, `song_id`) VALUES (10, 3);
COMMIT;

/* Creating indexes for faster searches */

CREATE UNIQUE INDEX `name_UNIQUE` ON `pazyniuk_jpa`.`artist` (`name` ASC);
CREATE INDEX `fk_artist_1_idx` ON `pazyniuk_jpa`.`artist` (`gender` ASC);
CREATE INDEX `fk_artist_2_idx` ON `pazyniuk_jpa`.`artist` (`country` ASC);

CREATE UNIQUE INDEX `song_UNIQUE` ON `pazyniuk_jpa`.`song` (`name` ASC);
CREATE INDEX `fk_song_1_idx` ON `pazyniuk_jpa`.`song` (`album` ASC);
CREATE INDEX `fk_song_2_idx` ON `pazyniuk_jpa`.`song` (`genre` ASC);
CREATE INDEX `fk_song_3_idx` ON `pazyniuk_jpa`.`song` (`record_label` ASC);
CREATE INDEX `fk_song_4_idx` ON `pazyniuk_jpa`.`song` (`album` ASC);

CREATE UNIQUE INDEX `username_UNIQUE` ON `pazyniuk_jpa`.`itunes_user` (`username` ASC);
CREATE INDEX `fk_itunes_user_1_idx` ON `pazyniuk_jpa`.`itunes_user` (`gender` ASC);

CREATE UNIQUE INDEX `credit_card_UNIQUE` ON `pazyniuk_jpa`.`itunes_user` (`credit_card` ASC);

CREATE INDEX `fk_user_song_1_idx` ON `pazyniuk_jpa`.`user_song` (`song_id` ASC);

/* The end */

SHOW INDEXES FROM `pazyniuk_jpa`.`song`;







