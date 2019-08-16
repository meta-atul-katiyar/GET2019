
CREATE SCHEMA `StoreFront` ;




//category
CREATE  TABLE `storefront`.`category` (

  `categoryId` INT UNSIGNED NOT NULL ,

  `categoryName` VARCHAR(100) NOT NULL ,

  `parentCategoryId` INT UNSIGNED NULL ,

  PRIMARY KEY (`categoryId`) ,

  UNIQUE INDEX `categoryId_UNIQUE` (`categoryId` ASC) ,

  UNIQUE INDEX `categoryName_UNIQUE` (`categoryName` ASC) );


// userRole
CREATE  TABLE `storefront`.`userRole` (

  `userRoleId` INT UNSIGNED NOT NULL ,

  `roleName` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`userRoleId`) ,

  UNIQUE INDEX `roleName_UNIQUE` (`roleName` ASC) ,

  UNIQUE INDEX `userRole_UNIQUE` (`userRoleId` ASC) );




//brand
CREATE  TABLE IF NOT EXISTS `storefront`.`brand` (

  `brandId` INT UNSIGNED NOT NULL ,

  `brandName` VARCHAR(100) NOT NULL ,

  PRIMARY KEY (`brandId`) );


//product
CREATE  TABLE IF NOT EXISTS `storefront`.`product` (

  `productId` INT UNSIGNED  NOT NULL ,

  `brandId` INT UNSIGNED NOT NULL ,

  `productDescription` VARCHAR(45) NOT NULL ,

  `unitPrice` DOUBLE NOT NULL ,

  `quantity` INT UNSIGNED  NOT NULL ,
  `addTime` DateTime NOT NULL ,

  PRIMARY KEY (`productId`) ,
  FOREIGN KEY(`brandId`) REFERENCES brands(brandId)
  ON DELETE CASCADE
  ON UPDATE CASCADE,

  INDEX `brandId` (`brandId` ASC) );


//user
CREATE  TABLE `storefront`.`user` (

  `userId` INT UNSIGNED NOT NULL ,

  `userName` VARCHAR(45) NOT NULL ,

  `mobileNumber` DECIMAL(10) NOT NULL ,

  `emailId` VARCHAR(100) NOT NULL ,

  `userRoleId` INT UNSIGNED NOT NULL ,

  PRIMARY KEY (`userId`) ,
  FOREIGN KEY(`userRoleId` ) REFERENCES userRole (`userRoleId` )
  ON DELETE CASCADE
  ON UPDATE CASCADE 

  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) ,

  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) ,

  UNIQUE INDEX `mobileNumber_UNIQUE` (`mobileNumber` ASC) ,

  UNIQUE INDEX `emailId_UNIQUE` (`emailId` ASC) );




//shippingAddress
CREATE  TABLE IF NOT EXISTS `storefront`.`shippingAddress` (

  `shippingAddressId` INT UNSIGNED  NOT NULL ,

  `houseNumber` INT UNSIGNED NOT NULL ,

  `streetName` VARCHAR(45) NULL ,

  `landMark` VARCHAR(45) NULL ,

  `city` VARCHAR(45) NOT NULL ,

  `state` VARCHAR(45) NOT NULL ,

  `country` VARCHAR(45) NOT NULL ,

  `zip` DECIMAL(6) NOT NULL ,
  `userId` INT UNSIGNED NOT NULL ,

  PRIMARY KEY (`shippingAddressId`) ,
  FOREIGN KEY(`userId` ) REFERENCES user(`userId` )
  ON DELETE CASCADE
  ON UPDATE CASCADE );






//shopperOrders
CREATE  TABLE IF NOT EXISTS `storefront`.`shopperOrders` (

  `idshopperOrders` INT UNSIGNED  NOT NULL ,

  `timestamp` DATETIME NULL ,

  `totalamount` DOUBLE NULL ,

  `shippingAddressId` INT UNSIGNED  NULL REFERENCES shippingAddress(shippingAddressId),

  `status` VARCHAR(20) NULL ,
  `userId` INT UNSIGNED NOT NULL ,

  PRIMARY KEY (`shopperOrderId`) ,
  FOREIGN KEY (`userId`) REFERENCES user(`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,

  INDEX `shippingAddressId` (`shippingAddressId` ASC));



//orderDetail
CREATE  TABLE IF NOT EXISTS `storefront`.`orderDetail` (

  `orderDetailId` INT UNSIGNED  NOT NULL ,

  `shopperOrderId` INT UNSIGNED  NOT NULL REFERENCES shopperOrders(idshopperOrders),

  `products` INT UNSIGNED  NOT NULL REFERENCES products(idproducts),

  `quantity` INT NOT NULL ,

  `unirPrice` DOUBLE NOT NULL ,

  PRIMARY KEY (`idorderDetail`) ,
  FOREIGN KEY(`shopperOrderId` ) REFERENCES shopperOrder(`shopperOrderId` )
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (`productId`) REFERENCES products(`productId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,

  UNIQUE INDEX `orderDetailId_UNIQUE` (`orderDetailId` ASC) ,

  INDEX `shopperOrderID` (`shopperOrderId` ASC) ,

  INDEX `productId` (`productId` ASC) );



//productImage
CREATE  TABLE IF NOT EXISTS `storefront`.`productImage` (

  `productImageId` INT UNSIGNED  NOT NULL ,

  `imageName` VARCHAR(45) NOT NULL ,

  `productsId` INT UNSIGNED  NOT NULL ,

  PRIMARY KEY (`productImageId`) ,
  FOREIGN KEY (`productId`) REFERENCES product(`productId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,

  INDEX `productId` (`productId` ASC) );




//productCategory
CREATE  TABLE IF NOT EXISTS `storefront`.`productCategory` (
  `productCategoryId` INT UNSIGNED NOT NULL ,
  `productId` INT UNSIGNED NOT NULL ,
  `categoryId` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`productCategoryId`),
  FOREIGN KEY (`productId`) REFERENCES product(`productId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (`categoryId`) REFERENCES category(`categoryId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE);

//
SET FOREIGN_KEY_CHECKS=0; DROP IF EXISTS TABLE products; SET FOREIGN_KEY_CHECKS=1;
