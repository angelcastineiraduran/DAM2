-- alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';
drop table if exists produtos  cascade;


create table produtos(
codigo varchar(3),
descricion varchar(15),
prezo integer,
datac date,
primary key (codigo));

commit;


show datestyle;
set datestyle = "ISO, DMY";
set datestyle to DMY, SQL;
