--mysql，前三行为解决[Err] 1055 - Expression #1 of ORDER BY clause is not in GROUP BY clause and报错问题
--SHOW VARIABLES LIKE '%sql_mode%';
--set sql_mode = '';
-- -set sql_mode = 'NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES';
drop table ch_bl_cake;
create table ch_bl_cake(
personid VARCHAR(8) not null,
cakedate int not null,
cakeid VARCHAR(8) not null,
state int not null,
taskid varchar(32)
);
alter table ch_bl_cake add constraint pk_ch_bl_cake primary key (personid,cakedate,cakeid);



--以下为oracle的语法
--drop table ch_bl_cake;
--create table ch_bl_cake(
--personid VARCHAR2(8) not null,
--cakedate number(8) not null,
--cakeid VARCHAR2(8) not null,
--state number(2) not null,
--taskid varchar2(32)
--);
--alter table ch_bl_cake add constraint pk_ch_bl_cake primary key (personid,cakedate,cakeid);