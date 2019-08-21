

DELIMITER //
DROP PROCEDURE IF EXISTS avg_sale //
CREATE PROCEDURE `storefront`.`avg_sale`(month_value INT, year_value INT )
BEGIN 
 DECLARE number INT;
 SELECT sum(OD.Quantity) INTO number FROM orderdetail AS OD NATURAL JOIN shopperorder AS SO 
 WHERE MONTH(SO.timestamp) = month_value AND YEAR(SO.timestamp) = year_value;
 
 DROP TEMPORARY TABLE IF EXISTS product_sale;
 CREATE TEMPORARY TABLE IF NOT EXISTS product_sale
 SELECT P.productId AS ID, P.productDescription AS prodDes, sum(OD.Quantity) AS quantity FROM 
 (product AS P INNER JOIN orderdetail AS OD ON P.productId = OD.productId) 
 INNER JOIN shopperorder AS SO ON SO.shopperorderId = OD.shopperorderId
 WHERE MONTH(SO.timestamp) = month_value AND YEAR(SO.timestamp) = year_value
 GROUP BY MONTH(SO.timestamp), P.productId;
 
 SET number = (SELECT SUM(quantity) FROM product_sale);
 
 SELECT ID, prodDes, Quantity/number AS averageSales FROM product_sale;
 
 DROP TEMPORARY TABLE IF EXISTS product_sale;
  
END 

//

DELIMITER ;

call avg_sale(8,2019);