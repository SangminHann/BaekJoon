SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, 
PRODUCT_ID, 
USER_ID, 
SALES_AMOUNT 
FROM ONLINE_SALE 
WHERE EXTRACT(MONTH FROM SALES_DATE) = 3 AND EXTRACT(YEAR FROM SALES_DATE) = 2022
UNION ALL 
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, 
PRODUCT_ID, 
NULL AS USER_ID, 
SALES_AMOUNT 
FROM OFFLINE_SALE 
WHERE EXTRACT(MONTH FROM SALES_DATE) = 3 AND EXTRACT(YEAR FROM SALES_DATE) = 2022
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID