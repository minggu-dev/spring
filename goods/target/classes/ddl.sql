
create database goods;

drop table if exists goods.goods;

create table goods.goods (
goodsId bigint(20) auto_increment primary key,
goodsName varchar(255),
price bigint(20),
soldOut tinyint,
createdAt TIMESTAMP
);