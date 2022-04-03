--1045
SELECT
    customer_id
FROM
    Customer
GROUP BY
    customer_id
HAVING
    COUNT(DISTINCT product_key) = (
        SELECT
            COUNT(DISTINCT product_key)
        FROM
            Product
    );

--1050
SELECT
    actor_id,
    director_id
FROM
    ActorDirector
GROUP BY
    actor_id,
    director_id
HAVING
    COUNT(actor_id) >= 3;

--1068
SELECT
    product_name,
    year,
    price
FROM
    Sales s
    JOIN Product p ON s.product_id = p.product_id;

--1069
SELECT
    product_id,
    SUM(quantity) total_quantity
FROM
    Sales s
GROUP BY
    product_id;

--1070
SELECT
    product_id,
    year first_year,
    quantity,
    price
FROM
    Sales
WHERE
    (product_id, year) IN (
        SELECT
            product_id,
            MIN(year)
        FROM
            Sales
        GROUP BY
            product_id
    );

--1075
SELECT
    DISTINCT project_id,
    ROUND(
        AVG(e.experience_years) OVER (PARTITION BY project_id),
        2
    ) average_years
FROM
    Project p
    JOIN Employee e ON p.employee_id = e.employee_id;

--1076
SELECT
    project_id
FROM
    Project
GROUP BY
    project_id
HAVING
    COUNT(*) >= ALL (
        SELECT
            COUNT(*)
        FROM
            Project
        GROUP BY
            project_id
    );

SELECT
    project_id
FROM
    (
        SELECT
            project_id,
            RANK() OVER (
                ORDER BY
                    COUNT(employee_id) DESC
            ) AS ranking
        FROM
            project
        GROUP BY
            project_id
    ) a
WHERE
    a.ranking = 1;

--1077
SELECT
    p.project_id,
    p.employee_id
FROM
    Project p
    JOIN Employee e ON p.employee_id = e.employee_id
WHERE
    (p.project_id, e.experience_years) IN (
        SELECT
            p.project_id,
            MAX(experience_years)
        FROM
            Project p
            JOIN Employee e ON p.employee_id = e.employee_id
        GROUP BY
            p.project_id
    );

SELECT
    project_id,
    employee_id
FROM
    (
        SELECT
            a.project_id,
            a.employee_id,
            DENSE_RANK() OVER (
                PARTITION BY a.project_id
                ORDER BY
                    b.experience_years DESC
            ) ranking
        FROM
            project a
            JOIN employee b ON a.employee_id = b.employee_id
    ) t
WHERE
    t.ranking = 1;

--1082
SELECT
    seller_id
FROM
    (
        SELECT
            seller_id,
            DENSE_RANK() OVER (
                ORDER BY
                    SUM(price) DESC
            ) rk
        FROM
            Sales
        GROUP BY
            seller_id
    ) t
WHERE
    t.rk = 1;

--1083
SELECT
    DISTINCT buyer_id
FROM
    Sales s
    JOIN Product p ON s.product_id = p.product_id
WHERE
    buyer_id NOT IN (
        SELECT
            buyer_id
        FROM
            Sales s
            JOIN Product p ON s.product_id = p.product_id
        WHERE
            p.product_name = 'iPhone'
    )
    AND p.product_name = 'S8';

--1084
SELECT
    DISTINCT p.product_id,
    product_name
FROM
    Product p
    LEFT JOIN Sales s ON s.product_id = p.product_id
WHERE
    p.product_id NOT IN (
        SELECT
            DISTINCT product_id
        FROM
            Sales
        WHERE
            sale_date < '2019-01-01'
            OR sale_date > '2019-03-31'
        GROUP BY
            product_id
    );

--1097 先选出player_id对应的install_date然后再join一次
SELECT
    a1.install_dt,
    COUNT(*) installs,
    ROUND(COUNT(a2.event_date) / COUNT(*), 2) Day1_retention
FROM
    (
        SELECT
            player_id,
            MIN(event_date) install_dt
        FROM
            Activity
        GROUP BY
            player_id
    ) a1
    LEFT JOIN Activity a2 ON a1.player_id = a2.player_id
    AND a2.event_date = DATE(a1.install_dt + 1)
GROUP BY
    a1.install_dt;

--1098
SELECT
    book_id,
    name
FROM
    Books
WHERE
    DATEDIFF('2019-06-23', available_from) >= 30
    AND book_id NOT IN (
        SELECT
            book_id
        FROM
            orders o
        WHERE
            dispatch_date >= '2018-06-23'
        GROUP BY
            book_id
        HAVING
            IFNULL(SUM(quantity), 0) >= 10
    );

--1107
SELECT
    login_date,
    COUNT(*) user_count
FROM
    (
        SELECT
            MIN(activity_date) login_date
        FROM
            Traffic
        WHERE
            activity = 'login'
        GROUP BY
            user_id
    ) t
WHERE
    login_date < '2019-06-30'
    AND DATEDIFF('2019-06-30', login_date) <= 90
GROUP BY
    login_date
ORDER BY
    login_date;

--1112
SELECT
    student_id,
    course_id,
    grade
FROM
    (
        SELECT
            student_id,
            course_id,
            grade,
            RANK() OVER (
                PARTITION BY student_id
                ORDER BY
                    grade DESC,
                    course_id ASC
            ) rk
        FROM
            Enrollments
    ) t
WHERE
    rk = 1;

--1113
SELECT
    extra report_reason,
    COUNT(DISTINCT post_id) report_count
FROM
    Actions
WHERE
    action_date = '2019-07-04'
    AND ACTION = 'report'
GROUP BY
    report_reason
ORDER BY
    extra;

--1126 把每个type的平均数全部先算出来，作为一个temp表的结果，不要每一项再重新取avg
SELECT
    business_id
FROM
    EVENTS
    JOIN(
        SELECT
            event_type,
            AVG(occurences) avg_occ
        FROM
            EVENTS
        GROUP BY
            event_type
    ) AS temp ON EVENTS.event_type = temp.event_type
WHERE
    EVENTS.occurences > temp.avg_occ
GROUP BY
    business_id
HAVING
    COUNT(*) > 1;

--1127
-- mine
SELECT
    spend_date,
    CASE
        platform_number
        WHEN 1 THEN 'mobile'
        WHEN 2 THEN 'desktop'
        WHEN 3 THEN 'both'
        ELSE 'none'
    END AS platform,
    total_amount,
    IFNULL(COUNT(DISTINCT user_id), 0) AS total_users
FROM
    (
        SELECT
            user_id,
            spend_date,
            SUM(
                CASE
                    WHEN platform = 'mobile' THEN 1
                    ELSE 2
                END
            ) AS platform_number,
            IFNULL(SUM(amount), 0) total_amount
        FROM
            Spending
        GROUP BY
            user_id,
            spend_date
    ) a
GROUP BY
    spend_date,
    platform_number
ORDER BY
    spend_date;

-- copy from comments
WITH tmp AS (
    -- 使用一个临时表，临时表包含全部的日期和platform的三种选项，这样left join的时候必然会有三个选项，没有的null用ifnull判断一下就可以了
    SELECT
        DISTINCT spend_date,
        'desktop' AS `platform`
    FROM
        Spending
    UNION
    SELECT
        DISTINCT spend_date,
        'mobile' AS `platform`
    FROM
        Spending
    UNION
    SELECT
        DISTINCT spend_date,
        'both' AS `platform`
    FROM
        Spending
),
b AS (
    -- 日期、平台、用户总数和金额
    SELECT
        a.spend_date,
        a.platform,
        SUM(a.amount) AS `total_amount`,
        COUNT(a.user_id) AS `total_users`
    FROM
        (
            -- 每个用户每一天的总和，以及平台
            SELECT
                s.spend_date,
                s.user_id,
                IF(
                    COUNT(DISTINCT s.platform) = 1,
                    s.platform,
                    'both'
                ) AS `platform`,
                SUM(s.amount) AS `amount`
            FROM
                Spending s
            GROUP BY
                s.spend_date,
                s.user_id
        ) a
    GROUP BY
        a.spend_date,
        a.platform
)
SELECT
    -- 为了插入0数据，构建一个tmp临时表，这个表里面必然有platform的三个选项
    tmp.spend_date,
    tmp.platform,
    IFNULL(b.total_amount, 0) AS `total_amount`,
    IFNULL(b.total_users, 0) AS `total_users`
FROM
    tmp
    LEFT JOIN b ON tmp.spend_date = b.spend_date
    AND tmp.platform = b.platform;

--1132
SELECT
    ROUND(AVG(percent), 2) average_daily_percent
FROM
    (
        SELECT
            action_date,
            COUNT(DISTINCT r.post_id) / COUNT(DISTINCT a.post_id) * 100 percent
        FROM
            Actions a
            LEFT JOIN Removals r ON a.post_id = r.post_id
        WHERE
            extra = 'spam'
        GROUP BY
            action_date
    ) T;