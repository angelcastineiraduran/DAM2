drop table if exists clave2 cascade;
drop table if exists referencia cascade;
create table referencia(
p integer,
c1 varchar(1),
c2 varchar(1),
primary key (p));
insert into referencia values (1,'F','B');
insert into referencia values(2,'L','M');
insert into referencia values(3,'J','F');
insert into referencia values(4,'P','M');
insert into referencia values(5,'R','M');
insert into referencia values(6,'J','A');
insert into referencia values(7,'R','G');
insert into referencia values(8,'F','F');
insert into referencia values(9,'P','L');
insert into referencia values(10,'H','U');

create table clave2(
cla2 varchar(1),
num2 integer,
primary key (cla2));


insert into clave2 values('C',2);
insert into clave2 values('G',13);
insert into clave2 values('P',1);
insert into clave2 values('B',7);
insert into clave2 values('R',12);
insert into clave2 values('F',3);
insert into clave2 values('L',33);
insert into clave2 values('A',8);
insert into clave2 values('U',27);
insert into clave2 values('M',8);





