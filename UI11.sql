
create database `UI11`;
use UI11;


CREATE  TABLE IF NOT EXISTS `UI11`.`user` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `firstName` VARCHAR(40) NOT NULL ,

  `lastName` VARCHAR(40) NOT NULL ,

  `email` VARCHAR(100) NOT NULL ,
  
  `contactNumber` VARCHAR(10) NOT NULL ,

  PRIMARY KEY (`ID`) ,
  UNIQUE (email),
  UNIQUE(ID)

  );
  
  CREATE  TABLE IF NOT EXISTS `UI11`.`category_list` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `name` VARCHAR(40) NOT NULL ,

  PRIMARY KEY (`ID`) ,
  UNIQUE(ID)

  );
  
  
  CREATE  TABLE IF NOT EXISTS `UI11`.`products` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `name` VARCHAR(40) NOT NULL ,

  `price` DOUBLE NOT NULL ,

  `description` VARCHAR(40) NOT NULL ,
  
  `imagePath` VARCHAR(100) NOT NULL ,
  
  `categoryId` INT UNSIGNED NOT NULL ,

  PRIMARY KEY (`ID`) ,
   FOREIGN KEY(`categoryId`) REFERENCES category_list(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  UNIQUE(ID)

  );
  
  CREATE  TABLE IF NOT EXISTS `UI11`.`cart` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `userId` INT UNSIGNED NOT NULL ,

  `productId` INT UNSIGNED NOT NULL ,

  `quantity` INT UNSIGNED NOT NULL ,


  PRIMARY KEY (`ID`) ,
  
  FOREIGN KEY(`productId`) REFERENCES products(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  
  FOREIGN KEY(`userId`) REFERENCES user(ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  
  UNIQUE(ID)

  );
  
  CREATE  TABLE IF NOT EXISTS `UI11`.`shipping_address` (

  `ID` INT UNSIGNED  NOT NULL AUTO_INCREMENT,

  `address` VARCHAR(500) NULL ,

  `city` VARCHAR(45) NOT NULL ,

  `state` VARCHAR(45) NOT NULL ,

  `country` VARCHAR(45) NOT NULL ,

  `zip` DECIMAL(6) NOT NULL ,
  `userId` INT UNSIGNED NOT NULL ,

  PRIMARY KEY (`ID`) ,
  FOREIGN KEY(`userId` ) REFERENCES user(`ID` )
  ON DELETE CASCADE
  ON UPDATE CASCADE );


CREATE  TABLE IF NOT EXISTS `UI11`.`shopper_orders` (

  `ID` INT UNSIGNED  NOT NULL AUTO_INCREMENT,

  `timeStamp` DATETIME NULL ,

  `totalAmount` DOUBLE NULL ,

 # `shippingAddressId` INT UNSIGNED  NULL REFERENCES shipping_address(`ID`),

  `status` VARCHAR(20) NULL ,
  
  `userId` INT UNSIGNED NOT NULL ,

  PRIMARY KEY (`ID`) ,
  FOREIGN KEY (`userId`) REFERENCES user(`ID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
  );




CREATE  TABLE IF NOT EXISTS `UI11`.`order_detail` (

  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,

  `shopperOrderId` INT UNSIGNED NOT NULL ,

  `productID` INT UNSIGNED NOT NULL ,

  `quantity` INT UNSIGNED NOT NULL ,

  `unitPrice` DOUBLE NOT NULL ,
  `status` VARCHAR(20) NULL ,
  PRIMARY KEY (`ID`) ,
  
  FOREIGN KEY(`shopperOrderId` ) REFERENCES shopper_orders(`ID` )
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (`productId`) REFERENCES products(`ID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);



  #into user
  INSERT INTO `ui11`.`user` (`ID`, `firstName`, `lastName`, `email`, `contactNumber`) VALUES (1, 'ab', 'ab', 'a@gm.co', '9090909090');


  
  #into category_list
  INSERT INTO `ui11`.`category_list` (`ID`, `name`) VALUES (1, 'Bread');
  INSERT INTO `ui11`.`category_list` (`ID`, `name`) VALUES (2, 'Dairy');
  INSERT INTO `ui11`.`category_list` (`ID`, `name`) VALUES (3, 'Fruits');
  INSERT INTO `ui11`.`category_list` (`ID`, `name`) VALUES (4, 'Seasonings And Spices');
  INSERT INTO `ui11`.`category_list` (`ID`, `name`) VALUES (5, 'Vegetables');


  
  # into products
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (1, 'Basic Bread', 10, 'aabb', 'bread/1496-3-large.jpg', 1);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (2, 'Brown Bread', 10, 'aabbb', 'bread/1557773598888.jpeg', 1);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (3, 'Decorative Bread', 10, 'aabb', 'bread/MBAK-1004-Decorative-Breads.jpg', 1);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (4, 'Pan Cake', 10, 'aabbb', 'bread/paul_hollywoods_crusty_83536_16x9.jpg', 1);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (5, 'Cheese', 10, 'aabb', 'dairy/All Vol Cheese samples web.jpg', 2);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (6, 'Buttermilk', 10, 'aabbb', 'dairy/Fotolia_104140802_M.jpg', 2);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (7, 'Mozzarella', 10, 'aabb', 'dairy/iStock-544807136.jpg', 2);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (8, 'ShreeKhand', 10, 'aabbb', 'dairy/jpg.jpg', 2);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (9, 'Oranges', 10, 'aabb', 'fruits/orange.jpg', 3);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (10, 'Banana', 10, 'aabbb', 'fruits/20175355001_lrg_1_@1x.jpg', 3);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (11, 'Apple', 10, 'aabb', 'fruits/Do_Apples_Affect_Diabetes_and_Blood_Sugar_Levels-732x549-thumbnail.jpg', 3);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (12, 'Mango', 10, 'aabbb', 'fruits/mangoes-chopped-and-fresh.jpg', 3);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (13, 'Salt', 10, 'aabbb', 'seasoning&spices/1552355676010.jpg', 4);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (14, 'Black Pepper', 10, 'aabb', 'seasoning&spices/black-pepper-ground-750x650-2.jpg', 4);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (15, 'Turmeric Powder', 10, 'aabbb', 'seasoning&spices/blended-turmeric-powder-500x500.jpg', 4);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (16, 'Coriander powder', 10, 'aabb', 'seasoning&spices/dhaniya-power-500x500-500x500.jpg', 4);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (17, 'Potato', 10, 'aabbb', 'vegetables/81459bqY2HL._SX679_.jpg', 5);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (18, 'Spinach', 10, 'aabb', 'vegetables/11464050-3x2-xlarge.jpg', 5);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (19, 'Mushroom', 10, 'aabbb', 'vegetables/Champignons_Agaricus.jpg', 5);
  INSERT INTO `ui11`.`products` (`ID`, `name`, `price`, `description`, `imagePath`, `categoryId`) VALUES (20, 'Cabbage', 10, 'aabb', 'vegetables/Headsofgreencabbage-5bfda38346e0fb00264606e3.jpg', 5);


  
  select P.name AS name, P.price, P.description, P.imagePath, C.name AS categoryName from 
  products P inner join category_list C on P.categoryId=C.Id;