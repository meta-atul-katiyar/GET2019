
// Display Recent 50 Orders placed (Id, Order Date, Order Total).

SELECT shopperorderId, timestamp, totalamount FROM storefront.shopperorder
ORDER BY timestamp DESC
LIMIT 50;
-----------------------------------
1	2019-08-15 23:35:48	150
8	2019-08-15 23:35:48	250
7	2019-08-15 23:35:48	150
6	2019-08-15 23:35:48	40
5	2019-08-15 23:35:48	100
4	2019-08-15 23:35:48	50
3	2019-08-15 23:35:48	30
2	2019-08-15 23:35:48	180
9	2019-07-10 20:00:00	250
10	2019-07-10 20:00:00	250
-----------------------------------

// Display 10 most expensive Orders.

SELECT shopperorderId, timestamp, totalamount FROM storefront.shopperorder
ORDER BY totalamount DESC
LIMIT 10;
-------------------
8	7	250
2	7	180
1	7	150
7	7	150
5	7	100
4	7	50
6	7	40
3	7	30
-------------------


// Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.

SELECT * FROM shopperorder as S  WHERE timestamp < NOW() - INTERVAL 10 DAY AND
(SELECT count(*) FROM orderdetail WHERE shopperorderId = S.shopperorderId AND status <> "shipped") > 0;
-----------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------

// Display list of shoppers which haven't ordered anything since last month.

SELECT * FROM user WHERE userId NOT IN (SELECT userId FROM shopperorder 
WHERE MONTH(timestamp) > ( MONTH(NOW())-1)) AND userRoleId = 1;
-----------------------------------------
9	aabcdefgh	aa552	13aa	1
-----------------------------------------

// Display list of shopper along with orders placed by them in last 15 days. 

SELECT * FROM user AS U NATURAL JOIN shopperorder AS SO WHERE  SO.timestamp >= NOW() - INTERVAL 15 DAY;
-----------------------------------------------------------------------------------------
1	a		a111	a1	1	1	2019-08-15 23:35:48	150	1
4	abcd		55a	3a	1	2	2019-08-15 23:35:48	180	2
7	abcdefg		a5	12a	1	3	2019-08-15 23:35:48	30	3
8	abcdefgh	a552	13a	1	4	2019-08-15 23:35:48	50	4
1	a		a111	a1	1	5	2019-08-15 23:35:48	100	5
4	abcd		55a	3a	1	6	2019-08-15 23:35:48	40	6
7	abcdefg		a5	12a	1	7	2019-08-15 23:35:48	150	7
8	abcdefgh	a552	13a	1	8	2019-08-15 23:35:48	250	8
------------------------------------------------------------------------------------------

// Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))

SELECT * FROM orderDetail WHERE shopperorderId = 1020 AND status = "shipped" ;
-----------------------------------------------
1	1	20101	1	10	shipped
2	1	20606	2	10	shipped
-----------------------------------------------

// Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.

SELECT OD.productId, SO.timestamp FROM shopperorder AS SO NATURAL JOIN orderDetail AS OD WHERE OD.unitPrice BETWEEN 20 AND 50;
---------------------------
40303	2019-08-15 23:35:48
1203012	2019-08-15 23:35:48
1102011	2019-08-15 23:35:48
60505	2019-08-15 23:35:48
60505	2019-08-15 23:35:48
60505	2019-08-15 23:35:48
60505	2019-08-15 23:35:48
---------------------------
