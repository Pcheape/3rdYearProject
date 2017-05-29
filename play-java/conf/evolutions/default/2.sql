# Users schema

# --- !Ups

INSERT INTO User (usertype,email,password) values ('admin','admin','2253d2fe001d024c8105cd62d125ec7b465a2c23f53576f5f1e03969ce8720db468fc6376ad945c2deb38bf654451cefadd3f8eb9534f46dca27f15019fa39a7');


INSERT INTO Level (id,password,first_Solved,second_Solved,points) values(1,'insecure',false,false,12);
INSERT INTO Level (id,password,first_Solved,second_Solved,points) values(2,'fuzzy blue cheese',false,false,12);
INSERT INTO Level (id,password,first_Solved,second_Solved,points) values(3,'Getting Good at this',false,false,12);
INSERT INTO Level (id,password,first_Solved,second_Solved,points) values(4,'Bingo was his nameo',false,false,12);
INSERT INTO Level (id,password,first_Solved,second_Solved,points) values(5,'getting tricky',false,false,12);
INSERT INTO Level (id,password,first_Solved,second_Solved,points) values(6,'Bravo you did it',false,false,12);



INSERT INTO Vulndata (type,username) values ('user','fred');
INSERT INTO Vulndata (type,username) values ('user','bart');
INSERT INTO Vulndata (type,username) values ('user','phill');
INSERT INTO Vulndata (type,username,password)values ('admin','admin','fuzzy blue cheese');



INSERT INTO Level3data (type,username) values ('user','phill');
INSERT INTO Level3data (type,username) values ('user','bart');
INSERT INTO Level3data (type,username) values ('user','fred');
INSERT INTO Level3data (type,username,password)values ('admin','admin','Getting Good at this');


INSERT INTO Level4data (type,username) values ('user','phill');
INSERT INTO Level4data (type,username) values ('user','bart');
INSERT INTO Level4data (type,username) values ('user','fred');
INSERT INTO Level4data (type,username,password)values ('admin','admin','Bingo was his nameo');


INSERT INTO Level5data (type,username) values ('user','phill');
INSERT INTO Level5data (type,username) values ('user','bart');
INSERT INTO Level5data (type,username) values ('user','fred');
INSERT INTO Level5data (type,username,password)values ('admin','admin','getting tricky');

INSERT INTO Level6data (type,username) values ('user','phill');
INSERT INTO Level6data (type,username) values ('user','bart');
INSERT INTO Level6data (type,username) values ('user','fred');
INSERT INTO Level6data (type,username,password)values ('admin','admin','getting tricky');

# --- !Downs
delete from User;
delete from level;
delete  from Vulndata;
delete  from Level3data;
delete  from Level4data;
delete  from Level5data;
delete from level6data;