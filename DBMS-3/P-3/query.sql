
// Display Shopper’s information along with number of orders he/she placed during last 30 days.


SELECT u.userId, u.userName, u.emailId, u.mobileNumber, count(c.userId) as "num of order" 
FROM user as u natural join shopperorder as c 
WHERE u.userRoleId=1 AND u.userId = c.userId AND c.timestamp >(now() - INTERVAL 30 DAY)
GROUP BY userId;


// Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.

SELECT u.userId, u.userName, u.emailId, u.mobileNumber, sum(c.totalamount) as amt FROM user as u natural join shopperorder as c 
WHERE u.userRoleId=1 AND u.userId = c.userId AND c.timestamp >(now() - INTERVAL 30 DAY)
GROUP BY userId
ORDER BY amt DESC
LIMIT 10;



// Display top 20 Products which are ordered most in last 60 days along with numbers.

SELECT P.productId, sum(O.quantity) as Quantity
FROM product as P INNER JOIN orderdetail as O ON P.productId = O.productId
GROUP BY P.productId
ORDER BY Quantity DESC
LIMIT 20;


// Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.

SELECT sum(totalamount), month(timestamp), year(timestamp) FROM shopperorder where timestamp > now()-INTERVAL 6 MONTH
GROUP BY MONTH(timestamp)
--------------------
500	7	2019
950	8	2019
--------------------

// Mark the products as Inactive which are not ordered in last 90 days.

UPDATE product SET status = 0
WHERE productId NOT IN (SELECT distinct OD.productId FROM shopperorder AS S NATURAL JOIN orderdetail AS OD
WHERE S.timestamp > now()-INTERVAL 90 DAY 
ORDER BY timestamp DESC) AND productId > 0;


// Given a category search keyword, display all the Products present in this category/categories. 

SELECT * FROM product WHERE productId IN (SELECT PC.productId FROM productCategory AS PC 
WHERE categoryId = (SELECT categoryId FROM category WHERE categoryName = 'ac'));
-----------------------------------------------------------------
40303	4	ac	30	2000	2019-08-15 22:23:13	1
50909	5	ai	40	200	2019-08-15 22:23:32	1
1102011	11	ak	20	200	2019-08-15 22:23:38	1
-----------------------------------------------------------------


// Display top 10 Items which were cancelled most.

SELECT productId, count(status) AS cancelNumber FROM orderdetail 
WHERE status = 'cancelled'
GROUP BY productId
ORDER BY cancelNumber DESC
LIMIT 10;
---------
60505	3
20101	2
40303	1
1102011	1
1203012	1
---------

