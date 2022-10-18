create database Metro;
use Metro;
create table MetroUsers (
	 userId int not null auto_increment primary key,
     userFName varchar(30),
     userSName varchar(30),
     userPass varchar(30),
     userBal double);

create table MetroStations(
	stationId int not null primary key,
    stationName varchar(30));
    
create table MetroTrans(
	transId int not null auto_increment primary key,
    cardId int not null,
    startStation int,
    destStation int,
    swipeInTime datetime,
    swipeOutTime datetime,
	constraint UserCard foreign key(cardId) references MetroUsers(userId),
    constraint FirstStation foreign key(startStation) references MetroStation(stationId),
	constraint SecondStation foreign key(destStation) references MetroStation(stationId));
    
insert into MetroUsers(userFName, userSName, userPass) values ("Albert","Sufaj","1234", 100);
insert into MetroUsers(userFName, userSName, userPass) values ("Jamie","Grant","123", 100);
insert into MetroUsers(userFName, userSName, userPass) values ("Charlie","Carroll","00001", 100);
insert into MetroUsers(userFName, userSName, userPass) values ("Georgia","Antoniou","password", 100);

insert into metrostation values (1, "London"), (2,"Birmingham"), (3,"Sheffield"), (4,"Newcastle"), (5,"Edinburgh");

select * from metrousers;
select * from metrostations;