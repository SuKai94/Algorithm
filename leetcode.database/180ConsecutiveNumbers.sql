SELECT 
	DISTINCT l1.Num 
FROM 
	Logs l1, Logs l2, Logs l3 
WHERE 
	(l1.Id=l2.Id+1 AND l1.Num=l2.Num) 
AND 
	(l1.Id=l3.Id+2 AND l1.Num=l3.Num);

SELECT 
	DISTINCT l1.Num 
FROM 
	Logs l1 
JOIN 
	Logs l2 
ON 
	l1.Id=l2.Id+1 
JOIN 
	Logs l3 
ON 
	l1.Id=l3.Id+2 
WHERE 
	l1.Num=l2.Num 
AND 
	l1.Num=l3.Num;

SELECT 
	DISTINCT(Num)
FROM
	(
	SELECT 
		Id, 
		Num, 
		@count:=if(@prev=Num, @count+1, 1)  as count,
		@prev:=Num
	FROM
		test.Logs, 
		(SELECT @count:=0, @prev:=0) init
	) results
WHERE results.count>=3;