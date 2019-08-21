
DELIMITER //
DROP PROCEDURE IF EXISTS avg_sale //
CREATE PROCEDURE `storefront`.`avg_sale`(month_value INT, year_value INT )
BEGIN 
 DECLARE number INT;
 
 DROP TEMPORARY TABLE IF EXISTS product_sale;
 CREATE TEMPORARY TABLE IF NOT EXISTS product_sale
 SELECT P.productId AS ID, P.productDescription AS prodDes, sum(OD.Quantity * OD.unitprice) AS sales FROM 
 (product AS P INNER JOIN orderdetail AS OD ON P.productId = OD.productId) 
 INNER JOIN shopperorder AS SO ON SO.shopperorderId = OD.shopperorderId
 WHERE MONTH(SO.timestamp) = month_value AND YEAR(SO.timestamp) = year_value
 GROUP BY MONTH(SO.timestamp), P.productId;
 
 SET number = (SELECT SUM(sales) FROM product_sale);
 
 SELECT ID, prodDes, number/sales AS averageSales FROM product_sale;
 
 DROP TEMPORARY TABLE IF EXISTS product_sale;
  
END 

//

DELIMITER ;

call avg_sale(8,2019);




DELIMITER //
DROP PROCEDURE IF EXISTS order_status //
CREATE PROCEDURE `storefront`.`order_status`(IN start_date DATE, end_date DATE )
BEGIN
  IF(start_date >= end_date) THEN
   SET start_date = end_date - INTERVAL DAY(end_date) DAY;
   END IF;
  Select OD.orderdetailId, OD.productId, OS.status, OS.ondate 
  FROM orderDetail AS OD NATURAL JOIN orderstatus AS OS
  WHERE DATE(OS.ondate) >= start_date AND DATE(OS.ondate) <= end_date;
END 

//

DELIMITER ;

CALL order_status('2019-07-12', '2019-05-31');

