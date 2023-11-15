

drop table if exists composicion cascade ;
drop table if exists componentes cascade ;

create table composicion(codp varchar(3),codc varchar(3),peso integer, primary key (codp,codc));
insert into composicion values ('p1','c1',400);
insert into composicion values ('p1','c3',600);
insert into composicion values ('p2','c2','600');
insert into composicion values ('p2','c3','300');
insert into composicion values ('p2','c4','200');
insert into composicion values ('p3','c1','100');
insert into composicion values ('p3','c2','200');
insert into composicion values ('p4','c1','200');
insert into composicion values ('p4','c3','200');

create table componentes(codc varchar(3),nomec varchar(15),graxa integer, primary key (codc));
insert into componentes values ('c1','vacuno',5);
insert into componentes values ('c2','ovino',20);
insert into componentes values ('c3','avicola',10);
insert into componentes values ('c4','avicola',5);


select * from composicion;
select * from componentes;


/*


composicion

COD COD       PESO
--- --- ----------
p1  c1	       400
p1  c3	       600
p2  c2	       600
p2  c3	       300
p2  c4	       200
p3  c1	       100
p3  c2	       200
p4  c1	       200
p4  c3	       200

9 rows selected.

componentes

COD NOMEC		 GRAXA
--- --------------- ----------
c1  vacuno		     5
c2  ovino		    20
c3  avicola		    10
c4  avicola		     5

*/
