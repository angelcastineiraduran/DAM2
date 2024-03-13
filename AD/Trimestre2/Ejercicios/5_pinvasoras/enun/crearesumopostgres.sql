drop table if exists resumo;
drop type if exists tipo_danos;
create type public.tipo_danos as  (
extensiondanada numeric,
porcentaxedanos numeric
);

create table resumo (
codz numeric,
nomez varchar(4),
nomei varchar(2),
danos tipo_danos,
primary key (codz,nomei)
);

