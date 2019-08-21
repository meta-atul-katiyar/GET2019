# order, product, category

# timestamp often called in where clause
ALTER TABLE shopperorder  ADD INDEX time_index(timestamp);

# quantity must be checked before any order
ALTER TABLE product  ADD INDEX quant_index(quantity);


ALTER TABLE category  ADD INDEX name_index(categoryName);
