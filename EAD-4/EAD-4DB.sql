
create database `EAD-4`;

use `EAD-4`;

CREATE  TABLE IF NOT EXISTS `EAD-4`.`employee_detail` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `fullName` VARCHAR(100) NOT NULL ,

  `gender` VARCHAR(10) NOT NULL ,

  `email` VARCHAR(100) NOT NULL ,
  
  `password` VARCHAR(100) NOT NULL ,
  
  `contactNumber` INT UNSIGNED NULL ,
  
  `organization` VARCHAR(100) NOT NULL ,

  PRIMARY KEY (`ID`) ,
  UNIQUE (email),
  UNIQUE(ID)

  );
  
  
CREATE  TABLE IF NOT EXISTS `EAD-4`.`vehicle_detail` (

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

  
  
  
  CREATE  TABLE IF NOT EXISTS `EAD-4`.`profile` (

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
  

  
  
    CREATE  TABLE IF NOT EXISTS `EAD-4`.`pass_details` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `amount` DOUBLE UNSIGNED NOT NULL,
  
  `planName` VARCHAR(20) NOT NULL, 
  
  `generationTime` DATETIME,
  
  `vehicleId` INT UNSIGNED NOT NULL  ,

  PRIMARY KEY (`ID`) ,
  FOREIGN KEY(`vehicleId`) REFERENCES vehicle_detail(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  UNIQUE(ID)

  );
  
  
    CREATE  TABLE IF NOT EXISTS `EAD-4`.`friends_list` (

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
  
  CREATE  TABLE IF NOT EXISTS `EAD-4`.`price_list` (

  `ID` INT UNSIGNED AUTO_INCREMENT,

  `vehicleType` VARCHAR(30) NOT NULL,
  
  `dailyPrice` INT UNSIGNED NOT NULL  ,
  `monthlyPrice` INT UNSIGNED NOT NULL  ,
  `yearlyPrice` INT UNSIGNED NOT NULL  ,

  PRIMARY KEY (`ID`) ,

  UNIQUE(ID)

  );
  
  
  INSERT INTO `EAD-4`.`price_list` VALUES(1, "cycle", 5,100,500);
  INSERT INTO `EAD-4`.`price_list` VALUES(2, "twoWheeler", 10,200,1000);
  INSERT INTO `EAD-4`.`price_list` VALUES(3, "fourWheeler", 20,500,3500);
  

  
  INSERT INTO `EAD-4`.`friends_list` VALUES (1, 1, `male`, 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-4`.`friends_list` VALUES (2, 1, `male`, 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-4`.`friends_list` VALUES (3, 2, `male`, 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-4`.`friends_list` VALUES (4, 2, `male`, 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-4`.`friends_list` VALUES (5, 3, `male`, 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-4`.`friends_list` VALUES (6, 3, `male`, 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-4`.`friends_list` VALUES (7, 4, `male`, 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
  INSERT INTO `EAD-4`.`friends_list` VALUES (8, 1, `male`, 'abc', 'visual-reverse-image-search-v2_intro.jpg', 'address1', '111111111');
   
  
