-- 180 连续3个1
SELECT
    DISTINCT num AS consecutivenums
FROM
    LOGS
WHERE
    (id + 1, num) IN (
        SELECT
            *
        FROM
            LOGS
    )
    AND (id + 2, num) IN (
        SELECT
            *
        FROM
            LOGS
    );

-- 181 比经理工资高的员工
SELECT
    a.name employee
FROM
    employee a
    JOIN employee b ON a.managerid = b.id
WHERE
    a.salary > b.salary;

--182 数量大于2的email
SELECT
    email
FROM
    person
GROUP BY
    email
HAVING
    count(email) >= 2;

--183
SELECT
    customers.name AS customers
FROM
    customers
    LEFT JOIN orders ON customers.id = orders.customerid
WHERE
    orders.customerid IS NULL;

--184
SELECT
    d.name AS department,
    e.name AS employee,
    e.salary
FROM
    department d
    LEFT JOIN employee e ON d.id = e.departmentid
WHERE
    (e.salary, e.departmentid) IN (
        SELECT
            max(salary),
            departmentid
        FROM
            employee
        GROUP BY
            departmentid
    );

--185
SELECT
    d.name AS department,
    e.name AS employee,
    e.salary AS salary
FROM
    department d
    LEFT JOIN employee e ON d.id = e.departmentid
WHERE
    e.id IN (
        SELECT
            e1.id
        FROM
            employee e1
            LEFT JOIN employee e2 ON e1.departmentid = e2.departmentid
            AND e1.salary < e2.salary
        GROUP BY
            e1.id
        HAVING
            count(DISTINCT e2.salary) <= 2
    )
    AND e.departmentid IN (
        SELECT
            id
        FROM
            department
    )
ORDER BY
    d.id ASC,
    e.salary DESC;

--185 用函数
SELECT
    department,
    employee,
    salary
FROM
    (
        SELECT
            d.name AS department,
            e.name AS employee,
            e.salary AS salary,
            dense_rank() over (
                PARTITION by departmentid
                ORDER BY
                    salary DESC
            ) AS rk
        FROM
            employee e
            LEFT JOIN department d ON e.departmentid = d.id
    ) m
WHERE
    rk <= 3;

--196 注意删除的时候不能根据这个表select出来的记录删除，必须要嵌套一层select才能删除
DELETE FROM
    person
WHERE
    id NOT IN (
        SELECT
            *
        FROM
            (
                SELECT
                    min(id)
                FROM
                    person
                GROUP BY
                    email
            ) t
    );

--197
SELECT
    w1.id
FROM
    weather w1
    JOIN weather w2 ON w1.recorddate = adddate(w2.recorddate, 1)
WHERE
    w1.temperature > w2.temperature;

--511
SELECT
    player_id,
    min(event_date) first_login
FROM
    activity
GROUP BY
    player_id;

--512
SELECT
    player_id,
    device_id
FROM
    activity
WHERE
    (player_id, event_date) IN (
        SELECT
            player_id,
            min(event_date)
        FROM
            activity
        GROUP BY
            player_id
    );

--534 通过连引一个表条件是日期比当前日期小的全部项
SELECT
    a1.player_id,
    a1.event_date,
    sum(a2.games_played) games_played_so_far
FROM
    activity a1
    LEFT JOIN activity a2 ON a1.player_id = a2.player_id
    AND a1.event_date >= a2.event_date
GROUP BY
    a1.player_id,
    a1.event_date
ORDER BY
    a1.player_id,
    a1.event_date;

--550
SELECT
    round(
        count(DISTINCT player_id) / (
            SELECT
                count(DISTINCT player_id)
            FROM
                activity a2
        ),
        2
    ) fraction
FROM
    activity
WHERE
    (player_id, event_date) IN (
        SELECT
            player_id,
            adddate(min(event_date), 1)
        FROM
            activity
        GROUP BY
            PARTITION
    );

--570
SELECT
    m.name
FROM
    employee m
    LEFT JOIN employee e ON e.managerid = m.id
GROUP BY
    m.id
HAVING
    count(e.id) >= 5;

--571 先把每一个数的asc_amount，desc_amount，total_num算出来
SELECT
    avg(num) AS median
FROM
    (
        SELECT
            num,
            sum(frequency) over (
                ORDER BY
                    num ASC
            ) asc_amount,
            sum(frequency) over (
                ORDER BY
                    num DESC
            ) desc_amount,
            sum(frequency) over () total_num
        FROM
            numbers
    ) a
WHERE
    asc_amount >= total_num / 2
    AND desc_amount >= total_num / 2;

--574
SELECT
    c.name
FROM
    candidate c
    JOIN vote v ON v.candidateid = c.id
GROUP BY
    c.id
HAVING
    count(*) >= ALL (
        SELECT
            count(*)
        FROM
            vote
        GROUP BY
            candidateid
    );

--577
SELECT
    e.name,
    b.bonus
FROM
    employee e
    LEFT JOIN bonus b ON e.empid = b.empid
WHERE
    coalesce(b.bonus, 0) < 1000;

--578
SELECT
    question_id survey_log
FROM
    (
        SELECT
            a.question_id,
            (
                count(a.question_id) / (
                    SELECT
                        count(*)
                    FROM
                        surveylog b
                    WHERE
                        b.action = 'show'
                        AND b.question_id = a.question_id
                )
            ) rate
        FROM
            surveylog a
        WHERE
            a.action = 'answer'
        GROUP BY
            a.question_id
        ORDER BY
            rate DESC,
            a.question_id ASC
        LIMIT
            1 OFFSET 0
    ) result;

--579 窗口函数不太会用
SELECT
    id,
    MONTH,
    salary
FROM
    (
        SELECT
            id,
            MONTH,
            sum(salary) over (
                PARTITION by id
                ORDER BY
                    MONTH ROWS 2 preceding
            ) AS salary,
            rank() over (
                PARTITION by id
                ORDER BY
                    MONTH DESC
            ) AS r
        FROM
            employee
    ) t
WHERE
    r > 1
ORDER BY
    id,
    MONTH DESC;

--580
SELECT
    dept_name,
    count(s.student_id) student_number
FROM
    department d
    LEFT JOIN student s ON s.dept_id = d.dept_id
GROUP BY
    dept_name
ORDER BY
    student_nubmer DESC,
    dept_name;

--584
SELECT
    name
FROM
    customer
WHERE
    referee_id IS NULL
    OR referee_id <> 2;

--586
SELECT
    DISTINCT customer_number
FROM
    orders
GROUP BY
    customer_number
ORDER BY
    count(customer_number) DESC
LIMIT
    1;

SELECT
    customer_number
FROM
    orders
GROUP BY
    customer_number
HAVING
    count(order_number) >= ALL (
        SELECT
            count(order_number)
        FROM
            orders
        GROUP BY
            customer_number
    );

-- 595
SELECT
    name,
    population,
    area
FROM
    world
WHERE
    population >= 25000000
    OR area >= 3000000;

--596
SELECT
    DISTINCT class
FROM
    courses
GROUP BY
    class
HAVING
    count(student) >= 5;

--603
SELECT
    DISTINCT c1.seat_id
FROM
    cinema c1
    JOIN cinema c2 ON c2.seat_id = c1.seat_id + 1
    OR c2.seat_id = c1.seat_id - 1
WHERE
    c1.free = 1
    AND c2.free = 1;

--607
SELECT
    name
FROM
    salesperson
WHERE
    sales_id NOT IN (
        SELECT
            s.sales_id
        FROM
            salesperson s
            RIGHT JOIN orders o ON o.sales_id = s.sales_id
            INNER JOIN company c ON o.com_id = c.com_id
        WHERE
            c.name = 'red'
    );

--608
SELECT
    t.id,
    CASE
        WHEN t.p_id IS NULL THEN 'root'
        WHEN t.id IN (
            SELECT
                p_id
            FROM
                tree
        ) THEN 'inner'
        ELSE 'leaf'
    END AS TYPE
FROM
    tree t;

--610
SELECT
    x,
    y,
    z,
    CASE
        WHEN x + y > z
        AND y + z > x
        AND x + z > y THEN 'yes'
        ELSE 'no'
    END AS triangle
FROM
    triangle;

--612
SELECT
    round(
        min(
            sqrt(power(p1.x - p2.x, 2) + power(p1.y - p2.y, 2))
        ),
        2
    ) shortest
FROM
    point2d p1
    LEFT JOIN point2d p2 ON (p1.x, p1.y) <> (p2.x, p2.y);

--613
SELECT
    min(abs(p1.x - p2.x)) shortest
FROM
    point p1
    LEFT JOIN point p2 ON p1.x <> p2.x;

--614
SELECT
    f1.follower,
    count(DISTINCT f2.follower) num
FROM
    follow f1
    JOIN follow f2 ON f2.followee = f1.follower
GROUP BY
    f1.follower
ORDER BY
    f1.follower;

--615
SELECT
    DISTINCT date_format(pay_date, '%y-%m') pay_month,
    department_id,
    CASE
        WHEN a1 > a2 THEN 'higher'
        WHEN a1 < a2 THEN 'lower'
        ELSE 'same'
    END AS comparison
FROM
    (
        SELECT
            e.department_id,
            pay_date,
            avg(amount) over (PARTITION by department_id, pay_date) a1,
            avg(amount) over (PARTITION by pay_date) a2
        FROM
            salary s
            LEFT JOIN employee e ON s.employee_id = e.employee_id
    ) c
ORDER BY
    pay_month DESC;

--618 透视表 不会做
-- max函数的作用是排除null值，不显示null，其实min也是可以的
SELECT
    max(
        CASE
            WHEN continent = 'America' THEN name
            ELSE NULL
        END
    ) AS America,
    max(
        CASE
            WHEN continent = 'Asia' THEN name
            ELSE NULL
        END
    ) AS Asia,
    max(
        CASE
            WHEN continent = 'Europe' THEN name
            ELSE NULL
        END
    ) AS Europe
FROM
    (
        SELECT
            name,
            continent,
            row_number() over(
                PARTITION by continent
                ORDER BY
                    name
            ) AS 'rk'
        FROM
            student
    ) t1
GROUP BY
    rk;

--619
SELECT
    (
        SELECT
            num
        FROM
            MyNumbers
        GROUP BY
            num
        HAVING
            count(*) = 1
        ORDER BY
            num DESC
        LIMIT
            1
    ) AS num;

--620
SELECT
    id,
    movie,
    description,
    rating
FROM
    cinema
WHERE
    description <> 'boring'
    AND id % 2 = 1
ORDER BY
    rating DESC;

--627
UPDATE
    salary
SET
    sex = IF(sex = 'm', 'f', 'm');

UPDATE
    salary
SET
    sex = CASE
        sex
        WHEN 'f' THEN 'm'
        ELSE 'f'
    END;

--626 
SELECT
    a.id AS id,
    IFNULL(
        IF(mod(a.id, 2) = 0, b.student, c.student),
        a.student
    ) AS student
FROM
    seat a
    LEFT JOIN seat b ON a.id = b.id + 1
    LEFT JOIN seat c ON a.id = c.id - 1
ORDER BY
    a.id