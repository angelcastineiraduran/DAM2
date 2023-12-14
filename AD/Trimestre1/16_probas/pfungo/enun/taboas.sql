drop table if exists fungos cascade;
drop table if exists areas cascade;
create table areas(
coda integer,
noma varchar(3),
hummedia integer,
superficie numeric(6,1),
numerofungos integer,
primary key(coda)
);
create table fungos(
id integer,
nomf varchar(1),
humlimite integer,
primary key(id)
);

insert into areas values(1,'pos',23,1000.0,0);
insert into areas values(2,'pon',21,2000.0,0);
insert into areas values(3,'poe',22,1500.0,0);
insert into areas values(4,'poo',19,1600.0,0);
insert into areas values(5,'poc',20,2100.0,0);
insert into areas values(6,'pus',24,1000.0,0);
insert into areas values(7,'oun',22,1200.0,0);
insert into areas values(8,'oue',23,1100.0,0);
insert into areas values(9,'ouo',24,1200.0,0);
insert into areas values(10,'ouc',21,1400.0,0);
insert into areas values(11,'pos',19,1500.0,0);
insert into areas values(12,'pon',18,1300.0,0);
insert into areas values(13,'poe',20,1200.0,0);
insert into areas values(14,'poo',22,1000.0,0);
 insert into areas values(15,'poc',21,1100.0,0);
insert into areas values(16,'lus',17,1400.0,0);
insert into areas values(17,'lun',18,2100.0,0);
insert into areas values(18,'lue',17,2300.0,0);
insert into areas values(19,'luo',18,1200.0,0);


insert into fungos values(1,'a',23);
insert into fungos values(2,'b',25);
insert into fungos values(3,'c',25);
insert into fungos values(4,'d',26);
insert into fungos values(5,'f',17);
insert into fungos values(6,'g',24);
insert into fungos values(7,'h',20);
insert into fungos values(8,'i',19);
insert into fungos values(9,'k',22);
insert into fungos values(10,'j',23);
insert into fungos values(11,'m',24);
insert into fungos values(12,'n',18);
insert into fungos values(13,'t',18);
insert into fungos values(14,'p',19);
insert into fungos values(15,'q',20);



