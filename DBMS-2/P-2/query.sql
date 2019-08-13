SELECT idproducts, categoryName, unitPrice FROM storefront.products as p natural join storefront.category as c
WHERE status = 1
ORDER BY addTime DESC;


SELECT * FROM products 
WHERE idproducts not in(SELECT idproducts FROM productImages );


SELECT C.idcategory, C.categoryName, (SELECT categoryName FROM category where idcategory = C.parentCategoryId) FROM category as C
ORDER BY C.parentCategoryId ASC , C.idcategory ASC;


SELECT C.idcategory, C.categoryName FROM category as C WHERE (C.idcategory NOT IN 
(SELECT distinct parentCategoryId as idcategory FROM category where parentCategoryId <> 0))


SELECT idproducts, productDescription, unitPrice FROM products WHERE idcategory = (SELECT idcategory FROM category WHERE categoryName = "aa");


SELECT * FROM products WHERE quantity > 50;


