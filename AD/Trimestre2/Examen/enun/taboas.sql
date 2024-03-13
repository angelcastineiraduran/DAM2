set datestyle = "ISO, DMY";
set datestyle to DMY, SQL;
drop table if exists evolucion cascade;
drop type if exists evl ;
create type evl as (
maxcolesterol numeric(6,3),
novo numeric(6,3),
evoluci varchar
);

create  table evolucion (
dni varchar(9),
evolve evl,
primary key (dni)
);
insert into evolucion  values('361a',(null,null,null));
insert into evolucion  values('362b',(null,null,null));
insert into evolucion  values('363c',(null,null,null));
insert into evolucion  values('364d',(null,null,null));
insert into evolucion  values('365e',(null,null,null));
insert into evolucion  values('366f',(null,null,null));
insert into evolucion  values('367g',(null,null,null));







