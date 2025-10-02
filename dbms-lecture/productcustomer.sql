-- 고객
CREATE TABLE customers (
  cust_id       NUMBER PRIMARY KEY,
  name          VARCHAR2(50) NOT NULL,
  city          VARCHAR2(50),
  referrer_id   NUMBER,                 -- 추천인(자기참조)
  CONSTRAINT fk_cust_referrer FOREIGN KEY (referrer_id)
    REFERENCES customers(cust_id)
);

-- 공급사
CREATE TABLE suppliers (
  supplier_id   NUMBER PRIMARY KEY,
  name          VARCHAR2(50) NOT NULL,
  country       VARCHAR2(50)
);

-- 카테고리
CREATE TABLE categories (
  category_id   NUMBER PRIMARY KEY,
  name          VARCHAR2(50) NOT NULL
);

-- 상품
CREATE TABLE products (
  product_id    NUMBER PRIMARY KEY,
  name          VARCHAR2(50) NOT NULL,
  category_id   NUMBER NOT NULL,
  supplier_id   NUMBER NOT NULL,
  price         NUMBER(10,2) NOT NULL,
  CONSTRAINT fk_prod_cat FOREIGN KEY (category_id) REFERENCES categories(category_id),
  CONSTRAINT fk_prod_sup FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
);

-- 배송사
CREATE TABLE shippers (
  shipper_id    NUMBER PRIMARY KEY,
  name          VARCHAR2(50) NOT NULL
);

-- 주문(헤더)
CREATE TABLE orders (
  order_id      NUMBER PRIMARY KEY,
  cust_id       NUMBER NOT NULL,
  order_date    DATE NOT NULL,
  shipper_id    NUMBER,                 -- 아직 미지정/미배송 가능
  CONSTRAINT fk_ord_cust FOREIGN KEY (cust_id) REFERENCES customers(cust_id),
  CONSTRAINT fk_ord_ship FOREIGN KEY (shipper_id) REFERENCES shippers(shipper_id)
);

-- 주문 상세(아이템)
CREATE TABLE order_items (
  order_id      NUMBER NOT NULL,
  product_id    NUMBER NOT NULL,
  quantity      NUMBER NOT NULL,
  unit_price    NUMBER(10,2) NOT NULL,
  CONSTRAINT pk_order_items PRIMARY KEY (order_id, product_id),
  CONSTRAINT fk_oi_order FOREIGN KEY (order_id) REFERENCES orders(order_id),
  CONSTRAINT fk_oi_product FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 가격대(비등가 조인용)
CREATE TABLE price_grade (
  grade   CHAR(1) PRIMARY KEY,
  lo      NUMBER(10,2) NOT NULL,
  hi      NUMBER(10,2) NOT NULL
);

------------------------------------------------------------
-- 샘플 데이터
INSERT INTO customers VALUES (1, 'Alice', 'Seoul',    NULL);
INSERT INTO customers VALUES (2, 'Bob',   'Busan',    1);
INSERT INTO customers VALUES (3, 'Carol', 'Daegu',    1);
INSERT INTO customers VALUES (4, 'Dave',  'Incheon',  NULL);
INSERT INTO customers VALUES (5, 'Erin',  'Daejeon',  2);

INSERT INTO suppliers VALUES (1, 'HanSup',     'Korea');
INSERT INTO suppliers VALUES (2, 'GlobalParts','Japan');

INSERT INTO categories VALUES (1, 'Electronics');
INSERT INTO categories VALUES (2, 'Home');
INSERT INTO categories VALUES (3, 'Books');

INSERT INTO products VALUES (101, 'Phone',  1, 1,  800);
INSERT INTO products VALUES (102, 'Laptop', 1, 2, 1500);
INSERT INTO products VALUES (103, 'Vacuum', 2, 1,  300);
INSERT INTO products VALUES (104, 'Mug',    2, 2,   20);
INSERT INTO products VALUES (105, 'Novel',  3, 2,   15);

INSERT INTO shippers VALUES (1, 'QuickShip');
INSERT INTO shippers VALUES (2, 'TurtleExpress');

INSERT INTO orders VALUES (1001, 1, DATE '2025-09-01', 1);
INSERT INTO orders VALUES (1002, 2, DATE '2025-09-02', 2);
INSERT INTO orders VALUES (1003, 2, DATE '2025-09-05', 1);
INSERT INTO orders VALUES (1004, 3, DATE '2025-09-07', NULL);  -- 미배송/미배정
INSERT INTO orders VALUES (1005, 5, DATE '2025-09-10', 1);

INSERT INTO order_items VALUES (1001, 101, 1,  800);
INSERT INTO order_items VALUES (1001, 104, 2,   20);
INSERT INTO order_items VALUES (1002, 103, 1,  300);
INSERT INTO order_items VALUES (1003, 101, 1,  800);
INSERT INTO order_items VALUES (1003, 105, 3,   15);
INSERT INTO order_items VALUES (1004, 102, 1, 1500);
INSERT INTO order_items VALUES (1005, 105, 2,   15);

INSERT INTO price_grade VALUES ('A',   0,   49.99);
INSERT INTO price_grade VALUES ('B',  50,  499.99);
INSERT INTO price_grade VALUES ('C', 500,  999.99);
INSERT INTO price_grade VALUES ('D', 1000, 9999.99);

COMMIT;
