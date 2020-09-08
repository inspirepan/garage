--  1
SELECT
    matchid,
    player
FROM
    goal
WHERE
    teamid LIKE 'GER';

-- 2
SELECT
    id,
    stadium,
    team1,
    team2
FROM
    game
WHERE
    id = 1012;

-- 3
SELECT
    player,
    teamid,
    stadium,
    mdate
FROM
    game
    JOIN goal ON (id = matchid)
WHERE
    teamid = 'GER';

--4
SELECT
    team1,
    team2,
    player
FROM
    game
    JOIN goal ON (id = matchid)
WHERE
    player LIKE 'Mario%';

--5
SELECT
    player,
    teamid,
    coach,
    gtime
FROM
    goal
    JOIN eteam ON teamid = id
WHERE
    gtime <= 10;

--6
SELECT
    mdate,
    teamname
FROM
    game
    JOIN eteam ON team1 = eteam.id
WHERE
    coach LIKE 'Fernando Santos';

--7
SELECT
    player
FROM
    goal
    JOIN game ON matchid = id
WHERE
    stadium = 'National Stadium, Warsaw';

--8
SELECT
    DISTINCT player
FROM
    goal
    JOIN game ON matchid = id
WHERE
    (
        team2 = 'GER'
        OR team1 = 'GER'
    )
    AND teamid <> 'GER';

--9
SELECT
    teamname,
    COUNT(teamid)
FROM
    eteam
    JOIN goal ON eteam.id = goal.teamid
GROUP BY
    eteam.teamname;

--10
SELECT
    stadium,
    COUNT(stadium)
FROM
    game
    JOIN goal ON id = matchid
GROUP BY
    stadium;

--11
SELECT
    matchid,
    mdate,
    COUNT(teamid)
FROM
    game
    JOIN goal ON id = matchid
WHERE
    team1 = 'POL'
    OR team2 = 'POL'
GROUP BY
    mactchid,
    mdate;

--12
SELECT
    id,
    mdate,
    COUNT(id)
FROM
    game
    JOIN goal ON id = matchid
WHERE
    teamid = 'GER'
GROUP BY
    id,
    mdate;

--13 没弄懂这个
SELECT
    mdate,
    team1,
    SUM(CASE WHEN teamid = team1 THEN 1 ELSE 0 END) score1,
    team2,
    SUM(CASE WHEN teamid = team2 THEN 1 ELSE 0 END) score2
FROM
    game
    LEFT JOIN goal ON id = matchid
GROUP BY
    mdate,
    team1,
    team2
ORDER BY
    mdate,
    matchid,
    team1,
    team2