drop table if exists pisos cascade ;
drop table if exists propiedades cascade ;


create table propiedades(
codp varchar(5),
codz varchar(20));

create table pisos(
codp varchar(3),
enderezo varchar(5),
m2 numeric,
nif varchar(5),
ano numeric);


insert into propiedades values('p1','z2');
insert into propiedades values('p2','z3');
insert into propiedades values('p3','z4');
insert into propiedades values('p4','z5');
insert into propiedades values('p5','z1');
insert into propiedades values('p6','z8');
insert into propiedades values('p7','z9');
insert into propiedades values('p8','z8');
insert into propiedades values('p9','z2');
insert into propiedades values('p10','z3');
insert into propiedades values('p11','z7');
insert into propiedades values('p12','z3');
insert into propiedades values('p13','z2');
insert into propiedades values('p14','z8');
insert into propiedades values('p15','z1');

insert into pisos values('p1','aaa',60,'368l',1991);
insert into pisos values('p2','bbb',70,'3611a',1992);
insert into pisos values('p3','ccc',80,'368l',2000);
insert into pisos values('p4','ddd',65,'3616c',2001);
insert into pisos values('p5','aaa',100,'3614m',2010);
insert into pisos values('p6','bbb',50,'3611a',2019);
insert into pisos values('p7','zzz',75,'3612u',2021);
insert into pisos values('p8','xxx',60,'3611a',1991);
insert into pisos values('p9','rrr',80,'3612u',1990);
insert into pisos values('p10','www',90,'365a',1995);
insert into pisos values('p11','yyy',120,'365a',1996);
insert into pisos values('p12','ddd',200,'365a',2005);
insert into pisos values('p13','sss',100,'362b',2015);
insert into pisos values('p14','aaa',65,'362b',2020);
insert into pisos values('p15','hhh',60,'363c',1989);
insert into pisos values('p16','yyy',70,'364d',1988);
insert into pisos values('p17','mmm',75,'364d',2003);
insert into pisos values('p18','eee',80,'3611a',2007);
insert into pisos values('p19','bbb',90,'364d',2010);
insert into pisos values('p20','ccc',100,'3611a',2013);
insert into pisos values('p21','www',60,'367g',2014);
insert into pisos values('p22','lll',40,'369f',2018);
insert into pisos values('p23','mmm',30,'369f',2021);
insert into pisos values('p24','sss',90,'3614m',2022);
insert into pisos values('p25','nnn',55,'367g',1995);
insert into pisos values('p26','ppp',65,'369f',2001);
insert into pisos values('p27','sss',75,'3614m',2003);


