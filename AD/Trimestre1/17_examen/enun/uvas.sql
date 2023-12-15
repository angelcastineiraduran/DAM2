

drop table if exists uvas cascade ;
drop table if exists clientes cascade ;



create table uvas (
tipo varchar(1),
nomeu varchar(10),
acidezmin integer,
acidezmax integer,
primary key (tipo)
);

insert into uvas values('a' , 'alvarinho',10,14);
insert into uvas values('m' , 'mencia',8,12);
insert into uvas values('c' , 'cainho',7,10);
insert into uvas values('p' , 'pedral',8,11);
insert into uvas values('l' , 'loureiro',6,10);
insert into uvas values('g' , 'garnacha',8,14);


create table clientes(
dni varchar(9),
nome varchar(15),
telf integer,
numerodeanalisis integer
);

insert into clientes values('36598767j','luis',986876565,6);
insert into clientes values('36898976z','ana',986212323,16);
insert into clientes values('36878745p','pedro',986437654,10);
insert into clientes values('36434321m','jose',986923412,0);




select * from uvas;
select * from clientes;


