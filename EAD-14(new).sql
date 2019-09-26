
create database `EAD14`;
use EAD14;
show tables;

CREATE  TABLE IF NOT EXISTS `EAD14`.`user` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `firstName` VARCHAR(40) NOT NULL ,

  `lastName` VARCHAR(40) NOT NULL ,

  `fatherName` VARCHAR(40) NOT NULL ,
  
  `email` VARCHAR(100) NOT NULL ,
  
  `contactNumber` VARCHAR(10) NOT NULL ,
  
  `username` VARCHAR(20) NOT NULL ,
  `password` VARCHAR(100) NOT NULL ,
  `role` VARCHAR(20) NOT NULL ,
  
  `enabled` VARCHAR(10) NOT NULL,

  PRIMARY KEY (`ID`) ,
  UNIQUE (email),
  UNIQUE (userName),
  UNIQUE(ID)

  );
  

# user table
INSERT INTO `ead14`.`user` (`ID`, `firstName`, `lastName`, `fatherName`, `email`, `contactNumber`, `username`, `password`, `enabled`)
VALUES (1, 'abc', 'abc', 'abc', 'abc@gm.co', '9090909090', 'abc123', '$2a$10$ZBjl5f45NJ4/We56VNi3NOE5EFlm.I6mRwgvxRu30p.gf3mOaXoVu', 'true');
# abc123 = $2a$10$ZBjl5f45NJ4/We56VNi3NOE5EFlm.I6mRwgvxRu30p.gf3mOaXoVu
INSERT INTO `ead14`.`user` (`ID`, `firstName`, `lastName`, `fatherName`, `email`, `contactNumber`, `username`, `password`, `enabled`)
VALUES (2, 'abcd', 'd', 'abcd', 'abcd@gm.co', '9090909091', 'abcd123', '$2a$10$ZBjl5f45NJ4/We56VNi3NOE5EFlm.I6mRwgvxRu30p.gf3mOaXoVu', 'true');

#INSERT INTO `ead14`.`user` (`ID`, `firstName`, `lastName`, `fatherName`, `email`, `contactNumber`, `username`, `password`, `enabled`)
#VALUES (4, 'abcd', 'd', 'abcd', 'abcsd', '90909091', 'abcd12', 'abcd12', 'true');
