
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
  
  `enabled` VARCHAR(10) NOT NULL,

  PRIMARY KEY (`ID`) ,
  UNIQUE (email),
  UNIQUE (userName),
  UNIQUE(ID)

  );
  
  CREATE  TABLE IF NOT EXISTS `EAD14`.`role_list` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `role` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE(ID)

  );
  
   CREATE  TABLE IF NOT EXISTS `EAD14`.`user_role` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `userID` INT UNSIGNED NOT NULL ,
  `roleId` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`) ,
    FOREIGN KEY(`userID`) REFERENCES user(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
    FOREIGN KEY(`roleId`) REFERENCES role_list(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  UNIQUE(ID)

  );

# role list
INSERT INTO `ead14`.`role_list` (`ID`, `role`) VALUES (1, 'admin');
INSERT INTO `ead14`.`role_list` (`ID`, `role`) VALUES (2, 'user');
  
# user table
INSERT INTO `ead14`.`user` (`ID`, `firstName`, `lastName`, `fatherName`, `email`, `contactNumber`, `username`, `password`, `enabled`)
VALUES (1, 'abc', 'abc', 'abc', 'abc', '90909090', 'abc123', '$2a$10$ZBjl5f45NJ4/We56VNi3NOE5EFlm.I6mRwgvxRu30p.gf3mOaXoVu', 'true');
# abc123 = $2a$10$ZBjl5f45NJ4/We56VNi3NOE5EFlm.I6mRwgvxRu30p.gf3mOaXoVu
INSERT INTO `ead14`.`user` (`ID`, `firstName`, `lastName`, `fatherName`, `email`, `contactNumber`, `username`, `password`, `enabled`)
VALUES (2, 'abcd', 'd', 'abcd', 'abcd', '90909091', 'abcd123', 'abcd123', 'true');

INSERT INTO `ead14`.`user` (`ID`, `firstName`, `lastName`, `fatherName`, `email`, `contactNumber`, `username`, `password`, `enabled`)
VALUES (4, 'abcd', 'd', 'abcd', 'abcsd', '90909091', 'abcd12', 'abcd12', 'true');

# user role map
INSERT INTO `ead14`.`user_role` (`ID`, `userID`, `roleId`) VALUES (1, 1, 1);

INSERT INTO `ead14`.`user_role` (`ID`, `userID`, `roleId`) VALUES (2, 2, 2);
INSERT INTO `ead14`.`user_role` (`ID`, `userID`, `roleId`) VALUES (4, 4, 1);

SELECT userName, password, enabled FROM user WHERE userName = 'abc1234';

SELECT * FROM user_role AS UR Inner JOIN role_list AS RL;

SELECT * FROM (user AS U NATURAL JOIN user_role AS UR) Inner JOIN role_list AS RL ON RL.ID=UR.roleId WHERE U.username = 'abc1234';