
CREATE SCHEMA IF NOT EXISTS `bcbs_light` ;

use bcbs_light;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS exchangerate;


CREATE TABLE user
(
	IDMail varchar(30) NOT NULL,
	firstName varchar(30) NOT NULL,
	lastName varchar(25) NOT NULL,
	userAdress varchar(25) NOT NULL,
	zipCode int NOT NULL,
	userAge int NOT NULL,
	userPhone varchar(12) NOT NULL,
	userBTCBalance double NOT NULL,
	Password varchar(20) NOT NULL,
	isAdmin boolean DEFAULT '0',
	PRIMARY KEY (IDMail)
);

CREATE TABLE exchangerate
(
	ID int NOT NULL UNIQUE,
	btcratedkk double DEFAULT 1 NOT NULL
);

INSERT INTO `bcbs_light`.`exchangerate` (`ID`, `btcratedkk`) VALUES ('1', '3000');

/* 
Adds one main admin user, and one user
*/
INSERT INTO `bcbs_light`.`user` (`IDMail`, `firstName`, `lastName`, `userAdress`, `zipCode`, `userAge`, `userPhone`, `userBTCBalance`, `Password`, `isAdmin`) VALUES ('admin', 'Tobias', 'Andersen', 'Lærkevej 22', '2750', '25', '24425009', '5', 'admin', '1');
INSERT INTO `bcbs_light`.`user` (`IDMail`, `firstName`, `lastName`, `userAdress`, `zipCode`, `userAge`, `userPhone`, `userBTCBalance`, `Password`, `isAdmin`) VALUES ('user', 'Tobias', 'Andersen', 'Lærkevej 22', '2750', '25', '24425009', '5', 'user', '0');

