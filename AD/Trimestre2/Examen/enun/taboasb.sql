drop table if exists carne cascade ;
drop table if exists consumo cascade;

create  table consumo (
id integer,
dni varchar(9),
dia integer,
gramos integer,
tipocarne varchar (10),
primary key (id)
);

insert into consumo  values(1 , '361a' , 1 , 400 , 'pavo');
insert into consumo  values(2 , '361a' , 3 , 400 , 'coello');
insert into consumo  values(3 , '361a' , 4 , 500 , 'vaca');
insert into consumo  values(4 , '361a' , 6 , 400 , 'veado');
insert into consumo  values(5 , '362b' , 1 , 300 , 'pavo');
insert into consumo  values(6 , '362b' , 3 , 100 , 'polo');
insert into consumo  values(7 , '363c' , 1 , 600 , 'vaca');
insert into consumo  values(8 , '363c' , 3 , 300 , 'polo');
insert into consumo  values(9 , '363c' , 5 , 300 , 'coello');


create  table carne (
nome varchar(9),
colesterol numeric(4,3),
primary key (nome)
);

insert into carne values('cabalo' , 0.068);
insert into carne values('coello' ,0.123);
insert into carne values('pavo' , 0.109);
insert into carne values('polo' , 0.088);
insert into carne values('porco' , 0.08);
insert into carne values('vaca' , 0.09);
insert into carne values('veado' , 0.112);
insert into carne values('xabarin' , 0.045);




