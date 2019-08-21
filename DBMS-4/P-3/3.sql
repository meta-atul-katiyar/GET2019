# order, product, category PRIMARYPRIMARY

ALTER TABLE shopperorder  ADD PRIMARY KEY(shopperorderId);
ALTER TABLE product  ADD PRIMARY KEY(productId);
ALTER TABLE category  ADD PRIMARY KEY(categoryId);