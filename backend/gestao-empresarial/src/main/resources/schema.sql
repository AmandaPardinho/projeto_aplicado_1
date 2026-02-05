CREATE TABLE products(
    id BIGINT AUTO_INCREMENT PRIMARY KEY
    name VARCHAR(255) NOT NULL,
    barcode VARCHAR(50) NOT NULL,
    description VARCHAR(255), 
    purchase_price DECIMAL(15, 2) NOT NULL,
    selling_price DECIMAL(15, 2) NOT NULL,
    stock_quantity INT NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME
)