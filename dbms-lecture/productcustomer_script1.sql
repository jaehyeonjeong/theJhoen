SELECT * FROM customers;
SELECT * FROM suppliers;
SELECT * FROM categories;
SELECT * FROM products;
SELECT * FROM shippers;
SELECT * FROM orders;
SELECT * FROM order_items;
SELECT * FROM price_grade;

--## 문제 5) 고객(customers)의 마지막 주문일(orders: order_date) (주문 없는 고객도 표시, outer)
--
--**요구:** 고객명과 마지막 주문일(없으면 NULL)
SELECT c.name, o.ORDER_DATE 
FROM CUSTOMERS c 
JOIN ORDERS o ON c.CUST_ID = o.CUST_ID
WHERE o.ORDER_DATE = (SELECT max(o.order_date) FROM o);


--## 문제 4) 주문 상세 합계 (주문별 품목 수, 금액 합계)
--
--**요구:** 주문별로 아이템 개수와 총 금액(= sum(quantity*unit_price))
SELECT product_id, sum(quantity) AS itemcount, unit_price, sum(quantity*unit_price) AS totalprice
FROM order_items
GROUP BY product_id, unit_price;


--## 문제 3) 상품의(products) 카테고리(categories)와 공급사(suppliers)
--category_id
--**요구:** 각 상품명, 카테고리명, 공급사명을 출력
SELECT p.name, c.name, s.name
FROM products p 
JOIN categories c ON (p.CATEGORY_ID  = c.category_id)
JOIN suppliers s ON (p.SUPPLIER_ID   = s.SUPPLIER_ID);


--## 문제 2) 주문 + 배송사 (미배정 주문도 포함 -> outer), orders, shippers
--
--**요구:** 모든 주문을 기준으로 배송사명을 함께 표시(없으면 NULL)
SELECT *
FROM orders o
LEFT OUTER JOIN shippers s ON o.SHIPPER_ID = s.SHIPPER_ID;


--## 문제 1) 고객별 주문 목록 (고객명, 주문ID, 주문일)
--
--**요구:** 고객과 주문을 조인하여 고객명/주문ID/주문일을 오름차순으로 출력
SELECT c.name, o.order_id, o.order_date
FROM customers c
JOIN orders o ON c.cust_id = o.cust_id
ORDER BY c.name ASC, o.order_id ASC, o.ORDER_DATE ASC;