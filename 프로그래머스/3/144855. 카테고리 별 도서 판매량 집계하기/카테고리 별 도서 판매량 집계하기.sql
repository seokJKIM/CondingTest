SELECT A.CATEGORY, SUM(B.SALES) as TOTAL_SALES
FROM BOOK AS A INNER JOIN BOOK_SALES AS B
ON A.BOOK_ID = B.BOOK_ID
WHERE YEAR(B.SALES_DATE) = 2022 AND MONTH(B.SALES_DATE) = 1
GROUP BY A.CATEGORY
ORDER BY A.CATEGORY;