SELECT COUNT(A.ID) AS FISH_COUNT, MAX(A.LENGTH) AS MAX_LENGTH, A.FISH_TYPE
FROM (SELECT ID, FISH_TYPE, IF(LENGTH IS NULL, 10, LENGTH) AS LENGTH
FROM FISH_INFO) AS A
GROUP BY FISH_TYPE
HAVING AVG(LENGTH) >= 33
ORDER BY FISH_TYPE ASC;

