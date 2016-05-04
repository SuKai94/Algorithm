SELECT 
	Score, 
    @rank := @rank + (@prev!=(@prev:=Score)) Rank
FROM 
	test.Scores, 
    (SELECT @rank:=0, @prev:=-1) init 
ORDER BY Score DESC;

SELECT 
	s.Score,
    (SELECT COUNT(DISTINCT(Score)) FROM Scores WHERE Score>=s.Score) Rank
FROM 
	test.Scores s
ORDER BY Score DESC;

SELECT
  Score,
  (SELECT count(*) FROM (SELECT distinct Score s FROM Scores) tmp WHERE s >= Score) Rank
FROM Scores
ORDER BY Score desc;