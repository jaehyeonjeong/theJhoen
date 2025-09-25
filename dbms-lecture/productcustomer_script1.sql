SELECT * FROM customers;
SELECT * FROM suppliers;
SELECT * FROM categories;
SELECT * FROM products;
SELECT * FROM shippers;
SELECT * FROM orders;
SELECT * FROM order_items;
SELECT * FROM price_grade;

--## 문제 10) 배송사별 발송 주문 수
--
--**요구:** 배송사(supplier) 기준으로 조인하여 발송된(배송사 지정된) 주문 수 집계
-- supplier-product-order_items
SELECT s.name, count(s.SHIPPER_ID) AS SHIPPED_ORDERS
FROM shippers s 
JOIN orders o ON (s.SHIPPER_ID = o.SHIPPER_ID)
GROUP BY s.name;

SELECT * FROM orders;
SELECT * FROM shippers;


--## 문제 9) 단가 등급 매칭 (NON-EQUI JOIN)
--
--**요구:** 주문아이템의 **단가(unit_price)** 를 가격대 테이블과 **범위 조인**하여 등급 표시
SELECT o.ORDER_ID, o.product_id, o.UNIT_PRICE, p.grade
FROM order_items o
JOIN price_grade p ON (o.unit_price BETWEEN p.lo AND p.hi)
ORDER BY o.ORDER_ID, o.PRODUCT_ID;


--## 문제 8) 공급사 기준 상품 수 (상품 없는 공급사도 포함 가정)
--
--**요구:** 공급사별 보유 상품 개수 (LEFT OUTER JOIN + GROUP BY)
--
--> 현재 샘플 데이터는 모든 공급사가 상품을 보유하지만, 없을 수도 있다는 가정에서 LEFT JOIN 패턴 연습용입니다.
SELECT s.name, count(p.PRODUCT_ID) AS PRODUCT_COUNT
FROM SUPPLIERS s
LEFT OUTER JOIN PRODUCTS p ON (s.SUPPLIER_ID = p.supplier_id)
GROUP BY s.name;


--## 문제 7) 추천인(Referrer)과 피추천인
--
--**요구:** 고객과 추천인(자기참조 : self-join)을 조인하여 “고객명–추천인명” 형태로 표시(추천인 없으면 NULL)
SELECT c1.name AS "고객명", c2.name AS "REFERRER"
FROM customers c1
LEFT OUTER JOIN customers c2 ON (c2.cust_id = c1.referrer_id)
ORDER BY c1.name;

SELECT * FROM customers;


--## 문제 6) 카테고리별 매출 합계
--
--**요구:** 주문아이템(order_items)→상품(products)→카테고리(categories)로 조인하여 카테고리별 매출
--(금액 합계 : = sum(quantity*unit_price) )
SELECT c.name, sum(o.quantity*o.unit_price) AS REVENUE
FROM order_items o
JOIN products p ON (o.product_id = p.product_id)
JOIN categories c ON (p.category_id = c.category_id)
GROUP BY c.name;


--## 문제 5) 고객(customers)의 마지막 주문일(orders: order_date) (주문 없는 고객도 표시, outer)
--
--**요구:** 고객명과 마지막 주문일(없으면 NULL)
SELECT c.name, to_char(to_date(max(o.ORDER_DATE)), 'yyyy-mm-dd') AS last_order
FROM CUSTOMERS c 
LEFT OUTER JOIN ORDERS o ON c.CUST_ID = o.CUST_ID
GROUP BY c.name
ORDER BY c.name;
--WHERE o.ORDER_DATE = (SELECT max(order_date) FROM orders WHERE order_date = o.ORDER_DATE);

SELECT max(order_date) FROM orders;


--## 문제 4) 주문 상세 합계 (주문별 품목 수, 금액 합계)
--
--**요구:** 주문별로 아이템 개수와 총 금액(= sum(quantity*unit_price))
SELECT order_id, sum(quantity) AS itemcount, sum(quantity*unit_price) AS totalprice
FROM order_items
GROUP BY order_id;

SELECT * FROM order_items;


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
SELECT o.order_id, o.ORDER_DATE, s.name
FROM orders o
LEFT OUTER JOIN shippers s ON o.SHIPPER_ID = s.SHIPPER_ID
ORDER BY o.order_id;


--## 문제 1) 고객별 주문 목록 (고객명, 주문ID, 주문일)
--
--**요구:** 고객과 주문을 조인하여 고객명/주문ID/주문일을 오름차순으로 출력
SELECT c.name, o.order_id, o.order_date
FROM customers c
JOIN orders o ON c.cust_id = o.cust_id
ORDER BY c.name, o.ORDER_DATE ASC; -- 정렬의 기본은 asc