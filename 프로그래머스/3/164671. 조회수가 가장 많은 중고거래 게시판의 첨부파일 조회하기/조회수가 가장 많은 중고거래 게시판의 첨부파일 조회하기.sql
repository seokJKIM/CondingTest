SELECT CONCAT('/home/grep/src/',B.BOARD_ID,'/',B.FILE_ID,B.FILE_NAME,B.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD AS A INNER JOIN USED_GOODS_FILE AS B
ON A.BOARD_ID = B.BOARD_ID
WHERE A.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY B.FILE_ID DESC;