
// Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
with latest ordered items should be displayed first for last 60 days.

CREATE OR REPLACE VIEW orderInfromation AS  
SELECT distinct U.userId, OD.unitPrice, U.userName, U.EmailId, S.timestamp, OD.Status 
 FROM (user AS U NATURAL JOIN shopperorder AS S) NATURAL JOIN orderdetail AS OD
 WHERE S.timestamp > (now()-INTERVAL 60 DAY)
 ORDER BY S.timestamp DESC;

select * FROM orderInfromation;
-------------------------------------------------------------------------
20606	10	a		a1	2019-08-15 23:35:48	shipped
1102011	20	abcd		3a	2019-08-15 23:35:48	cancelled
20101	10	abcd		3a	2019-08-15 23:35:48	cancelled
20101	10	a		a1	2019-08-15 23:35:48	shipped
1203012	30	abcd		3a	2019-08-15 23:35:48	cancelled
60505	50	a		a1	2019-08-15 23:35:48	cancelled
20101	10	abcd		3a	2019-08-15 23:35:48	shipped
60505	50	abcdefgh	13a	2019-08-15 23:35:48	cancelled
20101	10	abcdefgh	13a	2019-08-15 23:35:48	cancelled
40303	30	a		a1	2019-08-15 23:35:48	cancelled
20101	10	abcdefg		12a	2019-08-15 23:35:48	shipped
60505	50	abcdefg		12a	2019-08-15 23:35:48	shipped
-------------------------------------------------------------------------


// Use the above view to display the Products(Items) which are in ‘shipped’ state.

select * FROM orderInfromation AS OI WHERE OI.status = 'shipped' ;
---------------------------------------------------------------
20606	10	a	a1	2019-08-15 23:35:48	shipped
20101	10	a	a1	2019-08-15 23:35:48	shipped
20101	10	abcd	3a	2019-08-15 23:35:48	shipped
20101	10	abcdefg	12a	2019-08-15 23:35:48	shipped
60505	50	abcdefg	12a	2019-08-15 23:35:48	shipped
---------------------------------------------------------------


// Use the above view to display the top 5 most selling products.

SELECT OI.productId , count(OI.productId) FROM orderInfromation AS OI GROUP BY OI.productId
---------
20101	5
20606	1
40303	1
60505	3
1102011	1
1203012	1
---------


