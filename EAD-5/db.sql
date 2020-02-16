drop  database if exists mvc2;

create database mvc2;
use mvc2;

drop table if exists product;

CREATE  TABLE product (

  `productId` INT AUTO_INCREMENT,

  `productName` VARCHAR(45) NULL ,

  `productType` VARCHAR(45) NULL ,

  `productPrice` FLOAT NULL ,

  PRIMARY KEY (`productId`) );

INSERT INTO product VALUES (NULL, 'Puma 101', 'footwear', 4000.0);
INSERT INTO product VALUES (NULL, 'Puma 102', 'footwear', 6000.0);
INSERT INTO product VALUES (NULL, 'Titan 101', 'accessories', 3000.0);

select * from product;

drop table if exists user;

create table user(
    userId int not null auto_increment,
    email varchar(60),
    password varchar(40),
    primary key (userId)
);


insert into user values(null, "atul.katiyar@metacube.com", "777");

select * from user;

drop table if exists userCartMap;

create table userCartMap(
    cartId int not null auto_increment,
    userId int not null,
    primary key (cartId)
    );

insert into userCartMap values(null, 1);
select * from userCartMap;

drop table if exists cart;

create table cart(
    cartId int not null, 
    productId int not null,
    Quantity int not null,
    primary key(cartId, productId),
    FOREIGN KEY(productId) REFERENCES product(productId)
    );

select cartId from userCartMap where userId = 1;

select * from cart;


 
