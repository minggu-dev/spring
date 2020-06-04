create database `order`;

drop table if exists `order`.`order`;

create table `order`.`order` (
orderId bigint(20) auto_increment primary key,
totalPrice bigint(20),
shippingAddress varchar(255),
createdAt TIMESTAMP
);


drop table if exists `order`.order_line_item;

create table `order`.order_line_item (
orderLineItemId bigint(20) auto_increment primary key,
orderId bigint(20),
goodsId bigint(20),
orderQuantity bigint(20),
unitPrice bigint(20)
);