// Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.

SELECT p.productId, pc.categoryId, p.unitPrice
FROM storefront.product as p natural join storefront.productCategory as pc
WHERE status = 1
ORDER BY p.addTime DESC;


// Display the list of products which don't have any images.

SELECT * FROM product AS P
WHERE P.productId NOT IN(SELECT PI.productId FROM productImage AS PI );

// Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. 
(If Category is top category then Parent Category Title column should display “Top Category” as value.)

SELECT  C.categoryId, C.categoryName,  IFNULL(P.categoryName,'topCategory')
FROM category as C LEFT OUTER JOIN category as P ON P.categoryId = C.parentCategoryId
ORDER BY P.categoryName ASC , C.categoryName ASC;


// Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)

SELECT C.categoryId, C.categoryName FROM category as C WHERE (C.categoryId NOT IN 
(SELECT distinct parentCategoryId as categoryId FROM category where parentCategoryId <> 0));


// Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)

SELECT productId, productDescription, unitPrice 
FROM product natural join productCategory 
WHERE categoryId = (SELECT categoryId FROM category WHERE categoryName = "aa");


// Display the list of Products whose Quantity on hand (Inventory) is under 50.

SELECT * FROM product WHERE quantity > 50;


