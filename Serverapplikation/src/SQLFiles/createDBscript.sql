CREATE DATABASE IF NOT EXISTS cbscalendar;
use cbscalendar;

/* Create Tables */

CREATE TABLE IF NOT EXISTS Calendar
(
	calendarid int NOT NULL AUTO_INCREMENT,
	calendarname varchar(255) NOT NULL,
	createdby varchar(255) NOT NULL,
	privatepublic tinyint NOT NULL COMMENT '1 = public
	2 = private',
	active tinyint(4) NOT NULL,
	PRIMARY KEY (calendarid)
);


CREATE TABLE IF NOT EXISTS dailyupdate
(
	date datetime NOT NULL UNIQUE,
	apparenttemperature double,
	summary text,
	qotd varchar(300) NOT NULL,
	msg_type varchar (100) NOT NULL,
	update_timestamp TIMESTAMP DEFAULT NOW() ON UPDATE NOW(),
	PRIMARY KEY (date)
);


CREATE TABLE IF NOT EXISTS events
(
	eventid int NOT NULL AUTO_INCREMENT,
	location int,
	createdby int NOT NULL,
	start datetime NOT NULL,
	end datetime NOT NULL,
	eventname varchar(100) NOT NULL,
	description varchar(300) NOT NULL,
	-- Decides wether the event is an import-event or user created
	-- 
	calendarid int NOT NULL,
	PRIMARY KEY (eventid),
	active tinyint(4) NOT NULL,

	customevent boolean COMMENT 'Decides wether the event is an import-event or user created
'
);


CREATE TABLE IF NOT EXISTS locationdata
(
	locationdataid int NOT NULL AUTO_INCREMENT,
	longitude int NOT NULL,
	latitude int UNIQUE,
	PRIMARY KEY (locationdataid)
);


CREATE TABLE IF NOT EXISTS notes
(
	noteid int NOT NULL AUTO_INCREMENT,
	eventid int NOT NULL,
	createdby varchar(255) NOT NULL,
	note varchar(2000),
	dateTime datetime NOT NULL,
	active tinyint(4) NOT NULL,
	PRIMARY KEY (noteid)
);


CREATE TABLE IF NOT EXISTS userevents
(
	userid int NOT NULL,
	calendarid int NOT NULL
);


CREATE TABLE IF NOT EXISTS users
(
	userid int NOT NULL AUTO_INCREMENT,
	email varchar(40) NOT NULL,
	active tinyint(5) NOT NULL,
	created datetime DEFAULT CURRENT_TIMESTAMP,
	type varchar(20) NOT NULL,
	password varchar(200) NOT NULL,
	PRIMARY KEY (userid)
);



/* Create Foreign Keys */

ALTER TABLE events
	ADD FOREIGN KEY (calendarid)
	REFERENCES calendar (calendarid)
	ON UPDATE RESTRICT
;


ALTER TABLE userevents
	ADD FOREIGN KEY (calendarid)
	REFERENCES Calendar (calendarid)
	ON UPDATE RESTRICT
;


ALTER TABLE notes
	ADD FOREIGN KEY (eventid)
	REFERENCES events (eventid)
	ON UPDATE RESTRICT
;


ALTER TABLE events
	ADD FOREIGN KEY (location)
	REFERENCES locationdata (locationdataid)
	ON UPDATE RESTRICT
;


ALTER TABLE events
	ADD FOREIGN KEY (createdby)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;



ALTER TABLE userevents
	ADD FOREIGN KEY (userid)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;


ALTER TABLE notes
	ADD FOREIGN KEY (createdby)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;


INSERT INTO `cbscalendar`.`users` (`userid`, `email`, `active`, `created`, `type`, `password`) VALUES ('1', 'admin', '1', '2014-05-12 10:00:00', 'admin', 'admin');

INSERT INTO `cbscalendar`.`users` (`userid`, `email`, `active`, `created`, `type`, `password`) VALUES ('2', 'user', '1', '2014-05-12 10:01:00', 'user', 'user');


