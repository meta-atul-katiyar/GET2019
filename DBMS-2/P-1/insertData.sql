INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (1, 'a');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (2, 'b');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (3, 'c');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (4, 'd');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (5, 'e');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (6, 'f');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (7, 'g');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (8, 'h');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (9, 'i');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (10, 'j');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (11, 'k');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (12, 'l');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (13, 'm');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (14, 'n');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (15, 'o');
INSERT INTO `storefront`.`brand` (`brandId`, `brandName`) VALUES (16, 'p');


INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (1, 'aa', null);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (2, 'ab', 1);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (3, 'ac', 1);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (4, 'ad', 3);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (5, 'ae', 2);
INSERT INTO `storefront`.`category` (`categoryID`, `categoryName`, `parentCategoryId`) VALUES (6, 'af', 2);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (7, 'ag', 3);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (8, 'ah', 3);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (9, 'ai', 2);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (10, 'aj', 3);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (11, 'ak', 2);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (12, 'al', 2);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (13, 'am', 3);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (14, 'an', 3);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (15, 'ao', 2);
INSERT INTO `storefront`.`category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES (16, 'ap', 3);



INSERT INTO `storefront`.`userrole` (`userRoleId`, `roleName`) VALUES (1, 'shopper');
INSERT INTO `storefront`.`userrole` (`userRoleId`, `roleName`) VALUES (2, 'developer');
INSERT INTO `storefront`.`userrole` (`userRoleId`, `roleName`) VALUES (3, 'analyst');
INSERT INTO `storefront`.`userrole` (`userRoleId`, `roleName`) VALUES (4, 'modifier');
INSERT INTO `storefront`.`userrole` (`userRoleId`, `roleName`) VALUES (5, 'manager');
INSERT INTO `storefront`.`userrole` (`userRoleId`, `rolename`) VALUES (6, 'constructor');


INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (20101, 2, 'a', 10, 200, now(), 0);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (30202, 3, 'ab', 20, 1000, now(), 1);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (40303, 4, 'ac', 30, 2000, now(), 1);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (50404, 5, 'ad', 40, 3000, now(), 0);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (60505, 6, 'ae', 50, 100, now(), 1);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (20606, 2, 'af', 10, 100, now(), 1);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (30707, 3, 'ag', 20, 50, now(), 1);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (40808, 4, 'ah', 30, 300, now(), 1);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (50909, 5, 'ai', 40, 200, now(), 1);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (1001010, 10, 'aj', 10, 100, now(), 1);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (1102011, 11, 'ak', 20, 200, now(), 1);
INSERT INTO `storefront`.`product` (`productId`, `brandId`, `productDescription`, `unitPrice`, `quantity`, `addTime`, `status`) VALUES (1203012, 12, 'al', 30, 300, now(), 1);


INSERT INTO `storefront`.`productimage` (`productImageId`, `imageName`, `productId`) VALUES (1, 'a', 20101);
INSERT INTO `storefront`.`productimage` (`productImageId`, `imageName`, `productId`) VALUES (2, 'a', 30202);
INSERT INTO `storefront`.`productimage` (`productImageId`, `imageName`, `productId`) VALUES (3, 'a', 30202);
INSERT INTO `storefront`.`productimage` (`productImageId`, `imageName`, `productId`) VALUES (4, 'a', 40303);
INSERT INTO `storefront`.`productimage` (`productImageId`, `imageName`, `productId`) VALUES (5, 'a', 20101);
INSERT INTO `storefront`.`productimage` (`productImageId`, `imageName`, `productId`) VALUES (6, 'a', 60505);
INSERT INTO `storefront`.`productimage` (`productImageId`, `imageName`, `productId`) VALUES (7, 'a', 30707);
INSERT INTO `storefront`.`productimage` (`productImageId`, `imageName`, `productId`) VALUES (8, 'a', 30202);


INSERT INTO `storefront`.`user` (`userId`, `userName`, `emailId`, `mobileNumber`, `userRoleId`) VALUES (1, 'a', 'a1', 'a111', 1);
INSERT INTO `storefront`.`user` (`userId`, `userName`, `emailId`, `mobileNumber`, `userRoleId`) VALUES (2, 'ab', '1a', '11a', 2);
INSERT INTO `storefront`.`user` (`userId`, `userName`, `emailId`, `mobileNumber`, `userRoleId`) VALUES (3, 'abc', '2a', '111a', 3);
INSERT INTO `storefront`.`user` (`userId`, `userName`, `emailId`, `mobileNumber`, `userRoleId`) VALUES (4, 'abcd', '3a', '55a', 1);
INSERT INTO `storefront`.`user` (`userId`, `userName`, `emailId`, `mobileNumber`, `userRoleId`) VALUES (5, 'abcde', 'a11', '555a', 5);
INSERT INTO `storefront`.`user` (`userId`, `userName`, `emailId`, `mobileNumber`, `userRoleId`) VALUES (6, 'abcdef', '22a', 'a55', 2);
INSERT INTO `storefront`.`user` (`userId`, `userName`, `emailId`, `mobileNumber`, `userRoleId`) VALUES (7, 'abcdefg', '12a', 'a5', 1);
INSERT INTO `storefront`.`user` (`userId`, `userName`, `emailId`, `mobileNumber`, `userRoleId`) VALUES (8, 'abcdefgh', '13a', 'a552', 1);

INSERT INTO `storefront`.`user` (`userId`, `userName`, `emailId`, `mobileNumber`, `userRoleId`) VALUES (9, 'aabcdefgh', '13aa', 'aa552', 1);


INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (1, 11, 'a', 'a', 'a', 'a', 'a', 'a', 1);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (2, 15, 'a', 'a', 'a', 'a', 'a', 'a', 4);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (3, 18, 'a', 'a', 'a', 'a', 'a', 'a', 7);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (4, 20, 'a', 'a', 'a', 'a', 'a', 'a', 8);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (5, 22, 'a', 'a', 'a', 'a', 'a', 'a', 1);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (6, 34, 'a', 'a', 'a', 'a', 'a', 'a', 4);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (7, 12, 'a', 'a', 'a', 'a', 'a', 'a', 7);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (8, 111, 'a', 'a', 'a', 'a', 'a', 'a', 8);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (9, 90, 'a', 'a', 'a', 'a', 'a', 'a', 1);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (10, 19, 'a', 'a', 'a', 'a', 'a', 'a', 4);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (11, 26, 'a', 'a', 'a', 'a', 'a', 'a', 7);
INSERT INTO `storefront`.`shippingaddress` (`shippingAddressId`, `houseNumber`, `streetName`, `landMark`, `city`, `state`, `country`, `zip`, `userId`) VALUES (12, 100, 'a', 'a', 'a', 'a', 'a', 'a', 8);



INSERT INTO `storefront`.`shopperorder` (`shopperOrderId`, `timestamp`, `shippingAddressId`, `totalamount`, `userId`) VALUES (1, now(), 1,  150, 1);
INSERT INTO `storefront`.`shopperorder` (`shopperOrderId`, `timestamp`, `shippingAddressId`, `totalamount`, `userId`) VALUES (2, now(), 2,  180, 4);
INSERT INTO `storefront`.`shopperorder` (`shopperOrderId`, `timestamp`, `shippingAddressId`, `totalamount`, `userId`) VALUES (3, now(), 3,  30, 7);
INSERT INTO `storefront`.`shopperorder` (`shopperOrderId`, `timestamp`, `shippingAddressId`, `totalamount`, `userId`) VALUES (4, now(), 4,  50, 8);
INSERT INTO `storefront`.`shopperorder` (`shopperOrderId`, `timestamp`, `shippingAddressId`, `totalamount`, `userId`) VALUES (5, now(), 5,  100, 1);
INSERT INTO `storefront`.`shopperorder` (`shopperOrderId`, `timestamp`, `shippingAddressId`, `totalamount`, `userId`) VALUES (6, now(), 6,  40, 4);
INSERT INTO `storefront`.`shopperorder` (`shopperOrderId`, `timestamp`, `shippingAddressId`, `totalamount`, `userId`) VALUES (7, now(), 7,  150, 7);
INSERT INTO `storefront`.`shopperorder` (`shopperOrderId`, `timestamp`, `shippingAddressId`, `totalamount`, `userId`) VALUES (8, now(), 8,  250, 8);

INSERT INTO `storefront`.`shopperorder` (`shopperOrderId`, `timestamp`, `shippingAddressId`, `totalamount`, `userId`) VALUES (10, "20190710200000", 8,  250, 9);



INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (1, 1, 20101, 1, 10, "shipped");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (2, 1, 20606, 2, 10, "shipped");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (3, 1, 40303, 4, 30, "dispatched");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (4, 2, 20101, 2, 10, "shipped");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (5, 2, 1203012, 2, 30, "dispatched");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (6, 2, 1102011, 5, 20, "dispatched");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (7, 3, 20101, 3, 10, "shipped");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (8, 4, 60505, 1, 50, "dispatched");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (9, 5, 60505, 2, 50, "dispatched");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (10, 6, 20101, 4, 10, "dispatched");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (11, 7, 60505, 3, 50, "shipped");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (12, 8, 20101, 5, 10, "dispatched");
INSERT INTO `storefront`.`orderdetail` (`orderDetailId`, `shopperOrderId`, `productID`, `quantity`, `unitPrice`, `status`) VALUES (13, 8, 60505, 4, 50, "dispatched");



INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (1, 20101, 1);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (2, 30202, 2);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (3, 40303, 3);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (4, 50404, 4);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (5, 60505, 7);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (6, 20606, 8);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (7, 30707, 9);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (8, 40808, 10);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (9, 50909, 3);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (10, 1001010, 6);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (11, 1102011, 3);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (12, 1203012, 7);
INSERT INTO `storefront`.`productcategory` (`productCategoryId`, `productId`, `categoryId`) VALUES (13, 1203012, 4);







