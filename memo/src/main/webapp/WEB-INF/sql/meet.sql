insert into members(id,password,name)values('user1','1234','회원1');
insert into members(id,password,name)values('user2','1234','회원2');
insert into members(id,password,name)values('user3','1234','회원3');

insert into rooms(num,name)values(seq_rooms.nextval,'파이썬');
insert into rooms(num,name)values(seq_rooms.nextval,'스위프트');
insert into rooms(num,name)values(seq_rooms.nextval,'루비');
insert into rooms(num,name)values(seq_rooms.nextval,'PHP');

COMMIT;

CREATE TABLE members(
	id					varchar2(20)		PRIMARY KEY
	,password		varchar2(20)		NOT NULL
	,name			varchar2(30)		NOT NULL
);

CREATE TABLE rooms(
	num			number			PRIMARY KEY
	,name		varchar2(60)		UNIQUE NOT NULL
);

CREATE TABLE reservations(
	num				number			PRIMARY KEY
	,startTime		timestamp		NOT NULL
	,endTime		timestamp		NOT NULL
	,title				varchar2(100)	NOT NULL
	,memberId	varchar2(20)		REFERENCES members(id)
	,roomNum		number			REFERENCES rooms(num)
);

CREATE TABLE member_groups(
	num							number			PRIMARY KEY
	,reservationNum		number			REFERENCES reservations(num) on delete cascade
	,memberId				varchar2(20)		REFERENCES members(id)
);

CREATE SEQUENCE seq_rooms;
CREATE SEQUENCE seq_member_groups;
CREATE SEQUENCE seq_reservations;
