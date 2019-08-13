
SELECT idshopperorders, timestamp, totalamount FROM storefront.shopperorders
ORDER BY timestamp DESC
LIMIT 50;


SELECT idshopperorders, timestamp, totalamount FROM storefront.shopperorders
ORDER BY totalamount DESC
LIMIT 10;


SELECT * FROM shopperorders as S  WHERE timestamp < NOW() - INTERVAL 10 DAY AND
(SELECT count(*) FROM orderdetail WHERE idshopperorders = S.idshopperorders AND status <> "shipped") > 0;


SELECT * FROM user WHERE iduser NOT IN (SELECT iduser FROM shopperorders WHERE timestamp > (NOW() - INTERVAL 30 DAY));


SELECT * FROM user AS U WHERE U.iduser IN (SELECT iduser FROM shopperorders WHERE timestamp >= NOW() - INTERVAL 15 DAY);


SELECT * FROM orderDetails WHERE idshopperOrders = 1020 AND OD.status = "shipped" ;



SELECT OD.idproducts, SO.timestamp FROM shopperorders AS SO NATURAL JOIN orderDetails AS OD WHERE OD.unitPrice BETWEEN 20 AND 50;