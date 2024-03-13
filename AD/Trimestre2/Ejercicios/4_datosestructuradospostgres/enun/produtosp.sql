show datestyle;
set datestyle = "ISO, DMY";
set datestyle to DMY, SQL;

drop table if exists produtos  cascade;
drop type if exists cida cascade;


CREATE TYPE cida AS
(
cidade varchar(25),
cp integer
);

create table produtos(
codigo varchar(3),
descricion varchar(17),
prezo numeric(6,2),
datac date,
ci cida,
primary key (codigo));


insert into produtos values ('p1','mistos',4,null,('vigo',3));
insert into produtos values ('p2','escobas',5,null,('lugo',35));
select *  from produtos;
select ci from produtos;
select (ci).cidade from produtos;
select (ci).cidade from produtos where (ci).cp=35;
update produtos set ci.cp=(ci).cp +1 where (ci).cidade='vigo';

