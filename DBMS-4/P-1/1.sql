
DELIMITER //
DROP FUNCTION IF EXISTS no_of_orders //
CREATE FUNCTION `storefront`.`no_of_orders`(month_value INT, year_value INT ) RETURNS int DETERMINISTIC
BEGIN
 DECLARE number INT;
  Select count(SO.shopperorderId) INTO number FROM shopperorder AS SO 
  WHERE MONTH(timestamp) = month_value AND YEAR(timestamp) = year_value;
  RETURN number;
END 

//

DELIMITER ;

SELECT no_of_orders(8,2019);




DELIMITER //
DROP FUNCTION IF EXISTS month_of_max_orders //
CREATE FUNCTION `storefront`.`month_of_max_orders`( year_value INT ) RETURNS int 
BEGIN 
 DECLARE number INT;
 SET number = (Select MONTH(SO.timestamp) AS monthNumber  FROM shopperorder AS SO 
  WHERE YEAR(timestamp) = 2019 GROUP BY MONTH(timestamp) 
  ORDER BY count(SO.shopperorderId) DESC LIMIT 1);
  RETURN number;
END 

//

DELIMITER ;

SELECT month_of_max_orders(2019);
