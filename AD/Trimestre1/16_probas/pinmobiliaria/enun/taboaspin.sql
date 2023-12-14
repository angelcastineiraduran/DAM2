drop table if exists pisos cascade ;
drop table if exists zonas cascade ;
create table zonas(
 codz varchar(3),
 nomz varchar(20),
 prezom2 numeric);
create table pisos(
codp varchar(3),
 enderezo varchar(5),
 m2 numeric,
 codz varchar(3),
 nif varchar(5));

insert into zonas values('z1','calvario',2300);
insert into zonas values('z2','teis',2100);
insert into zonas values('z3','rosalia',1000);
insert into zonas values('z4','centro',3000);
insert into zonas values('z5','principe',4000);
insert into zonas values('z6','lavadores',2000);
insert into zonas values('z7','travesia',1000);
insert into zonas values('z8','traviesas',1600);
insert into zonas values('z9','navia',1600);
insert into zonas values('z10','bouzas',3000);
insert into zonas values('z11','cabral',1400);

insert into pisos values('p1','aaa',60,'z1','368l');
insert into pisos values('p2','bbb',70,'z2','3611a');
insert into pisos values('p3','ccc',80,'z3','368l');
insert into pisos values('p4','ddd',65,'z4','3616c');
insert into pisos values('p5','aaa',100,'z1','3614m');
insert into pisos values('p6','bbb',50,'z2','3611a');
insert into pisos values('p7','zzz',75,'z10','3612u');
insert into pisos values('p8','xxx',60,'z11','3611a');
insert into pisos values('p9','rrr',80,'z11','3612u');
insert into pisos values('p10','www',90,'z1','365a');
insert into pisos values('p11','yyy',120,'z5','365a');
insert into pisos values('p12','ddd',200,'z4','365a');
insert into pisos values('p13','sss',100,'z3','362b');
insert into pisos values('p14','aaa',65,'z1','362b');
insert into pisos values('p15','hhh',60,'z8','363c');
insert into pisos values('p16','yyy',70,'z5','364d');
insert into pisos values('p17','mmm',75,'z9','364d');
insert into pisos values('p18','eee',80,'z2','3611a');
insert into pisos values('p19','bbb',90,'z2','364d');
insert into pisos values('p20','ccc',100,'z3','3611a');
insert into pisos values('p21','www',60,'z1','367g');
insert into pisos values('p22','lll',40,'z5','369f');
insert into pisos values('p23','mmm',30,'z9','369f');
insert into pisos values('p24','sss',90,'z3','3614m');
insert into pisos values('p25','nnn',55,'z6','367g');
insert into pisos values('p26','ppp',65,'z7','369f');
insert into pisos values('p27','sss',75,'z3','3614m');


