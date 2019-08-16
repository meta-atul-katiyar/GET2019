
// Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.

SELECT  P.productId, P.productDescription, count(PC.productId) as categoryCount 
FROM product AS P NATURAL JOIN productCategory AS PC group by PC.productId HAVING categoryCount > 1;
-----------------
1203012	al	2
-----------------


// Display Count of products as per below price range

(SELECT "0-100" AS "RANGE", count(*)AS COUNT  FROM product WHERE unitPrice  BETWEEN 0 and 10) 
Union
(SELECT "101-500", count(*)  FROM product WHERE unitPrice  BETWEEN 10 and 20)
Union ALL
(SELECT "Above 500", count(*)  FROM product WHERE unitPrice  > 30);
-----------------
0-100		3
101-500		6
Above 500	3
-----------------


// Display the Categories along with number of products under each category.

SELECT categoryName, count(productId) FROM category natural join productCategory GROUP BY productId
---------
aa	1
ah	1
ab	1
ai	1
ac	1
aj	1
ad	1
ac	1
ag	1
af	1
ac	1
ag	2
---------


