CREATE TABLE users ( 
	id                   bigserial  NOT NULL,
	login                 varchar(64)  NOT NULL,
	creation_date        timestamp DEFAULT current_timestamp NOT NULL,
	update_date          timestamp DEFAULT current_timestamp NOT NULL,
	CONSTRAINT pk_users PRIMARY KEY ( id )
 );

CREATE TABLE trip_group ( 
	id                   bigserial  NOT NULL,
	group_name                 varchar(64)  NOT NULL,
	gorup_key		varchar(128) not Null,
	creation_date        timestamp DEFAULT current_timestamp NOT NULL,
	update_date          timestamp DEFAULT current_timestamp NOT NULL,
	CONSTRAINT pk_group PRIMARY KEY ( id )
 );



