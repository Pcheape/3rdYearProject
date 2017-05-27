# Users schema

# --- !Ups

INSERT INTO User (usertype,email,password) values ('admin','admin','admin');

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
INSERT INTO Level6data (type,username,password)values ('admin','admin','getting tricky');INSERT INTO Level5data (type,username) values ('user','phill');
INSERT INTO Level6data (type,username) values ('user','bart');
INSERT INTO Level6data (type,username) values ('user','fred');
INSERT INTO Level6data (type,username,password)values ('admin','admin','getting tricky');
# --- !Downs
delete  from Vulndata;
delete  from Level3data;
delete  from Level4data;
delete  from Level5data;
delete from level6data;