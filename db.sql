
create database `EAD-9`;

use `EAD-9`;

CREATE  TABLE IF NOT EXISTS `EAD-9`.`employee_detail` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `fullName` VARCHAR(100) NOT NULL ,

  `gender` VARCHAR(10) NOT NULL ,

  `email` VARCHAR(100) NOT NULL ,
  
  `password` VARCHAR(100) NOT NULL ,
  
  `contactNumber` VARCHAR(10) NULL ,
  
  `organization` VARCHAR(100) NOT NULL ,

  PRIMARY KEY (`ID`) ,
  UNIQUE (email),
  UNIQUE(ID)

  );
  
  
CREATE  TABLE IF NOT EXISTS `EAD-9`.`vehicle_detail` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `vehicleName` VARCHAR(100) NOT NULL ,

  `type` VARCHAR(20) NOT NULL ,

  `vehicleNumber` VARCHAR(20) NOT NULL ,
  
  `employeeId` INT UNSIGNED NOT NULL  ,
  
  `identification` TEXT ,

  PRIMARY KEY (`ID`) ,
  FOREIGN KEY(`employeeId`) REFERENCES employee_detail(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  UNIQUE (vehicleNumber),
  UNIQUE(ID)

  );

  
  
  
  CREATE  TABLE IF NOT EXISTS `EAD-9`.`profile` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `image`  VARCHAR(45) NOT NULL ,
  
  `employeeId` INT UNSIGNED NOT NULL  ,
  
  `timeOfUpload` DATETIME NOT NULL ,

  PRIMARY KEY (`ID`) ,
  FOREIGN KEY(`employeeId`) REFERENCES employee_detail(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  UNIQUE(ID)

  );
  

  
  
    CREATE  TABLE IF NOT EXISTS `EAD-9`.`pass_details` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  
  `priceListId` INT UNSIGNED NOT NULL, 
  
  `generationTime` DATETIME,
  
  `vehicleId` INT UNSIGNED NOT NULL  ,

  PRIMARY KEY (`ID`) ,
  
  FOREIGN KEY(`vehicleId`) REFERENCES vehicle_detail(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY(`priceListId`) REFERENCES price_list(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  
  
  UNIQUE(ID)

  );
  
  
    CREATE  TABLE IF NOT EXISTS `EAD-9`.`friends_list` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `userId` INT UNSIGNED NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `friendName` VARCHAR(30)  NOT NULL  ,
  `imageName` VARCHAR(40) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `contactNumber` VARCHAR(10) NOT NULL,

  PRIMARY KEY (`ID`) ,
  FOREIGN KEY(`userId`) REFERENCES employee_detail(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  UNIQUE(ID)

  );
  
  #drop table friends_list
  
  CREATE  TABLE IF NOT EXISTS `EAD-9`.`price_list` (

  `ID` INT UNSIGNED AUTO_INCREMENT,

  `vehicleType` VARCHAR(30) NOT NULL,
  
  `planName` VARCHAR(30) NOT NULL  ,
  `price` DOUBLE UNSIGNED NOT NULL  ,

  PRIMARY KEY (`ID`) ,

  UNIQUE(ID)

  );
  
  #SET FOREIGN_KEY_CHECKS = 0;  SET FOREIGN_KEY_CHECKS = 1;
  
  INSERT INTO `EAD-9`.`price_list` VALUES(1, "Cycle", "Daily",5);
  INSERT INTO `EAD-9`.`price_list` VALUES(2, "Cycle", "Monthly",100);
  INSERT INTO `EAD-9`.`price_list` VALUES(3, "Cycle", "Yearly",500);
  
  INSERT INTO `EAD-9`.`price_list` VALUES(4, "Two Wheeler", "Daily", 10);
  INSERT INTO `EAD-9`.`price_list` VALUES(5, "Two Wheeler", "Monthly",200);
  INSERT INTO `EAD-9`.`price_list` VALUES(6, "Two Wheeler", "Yearly",1000);
    
  INSERT INTO `EAD-9`.`price_list` VALUES(7, "Four Wheeler", "Daily",20);
  INSERT INTO `EAD-9`.`price_list` VALUES(8, "Four Wheeler", "Monthly",500);
  INSERT INTO `EAD-9`.`price_list` VALUES(9, "Four Wheeler", "Yearly",3500);
  

  
  INSERT INTO `EAD-9`.`friends_list` VALUES (1, 2, 'male', 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-9`.`friends_list` VALUES (2, 1, 'male', 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-9`.`friends_list` VALUES (3, 2, 'male', 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-9`.`friends_list` VALUES (4, 2, 'male', 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-9`.`friends_list` VALUES (5, 1, 'male', 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-9`.`friends_list` VALUES (6, 2, 'male', 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-9`.`friends_list` VALUES (7, 1, 'male', 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-9`.`friends_list` VALUES (8, 1, 'male', 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
   
