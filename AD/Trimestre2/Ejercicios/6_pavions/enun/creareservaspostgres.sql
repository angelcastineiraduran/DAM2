set datestyle = "ISO, DMY";
set datestyle to DMY, SQL;

drop table if exists reservas cascade;
drop type if exists public.tipo_voos;
create type public.tipo_voos as(
idvooida numeric,
idvoovolta numeric
);

create table reservas (
codr numeric,
dni varchar(4),
voos tipo_voos,
primary key (codr)
);


insert into reservas values(1,'361a',(1,2)::public.tipo_voos);
insert into reservas values(2,'362b',(3,4)::public.tipo_voos);		
insert into reservas values(3,'361a',(5,6)::public.tipo_voos);
insert into reservas values(4,'363c',(9,10)::public.tipo_voos);
insert into reservas values(5,'363c',(11,12)::public.tipo_voos);

