CREATE TABLE PRODUCTS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(64),
    description VARCHAR(128),
    brand VARCHAR(64),
    category VARCHAR(64),
    listPrice DOUBLE,
    cost DOUBLE
);
