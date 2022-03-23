--1045
SELECT
    customer_id
FROM
    Customer
GROUP BY
    customer_id
HAVING
    count(DISTINCT product_key) = (
        SELECT
            count(DISTINCT product_key)
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
    count(actor_id) >= 3;

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
    sum(quantity) total_quantity
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
    (product_id, year) IN(
        SELECT
            product_id,
            min(year)
        FROM
            Sales
        GROUP BY
            product_id
    );

--1075
SELECT
    DISTINCT project_id,
    round(
        avg(e.experience_years) over(PARTITION by project_id),
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
    count(*) >= ALL (
        SELECT
            count(*)
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
            rank() over(
                ORDER BY
                    count(employee_id) DESC
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
    (p.project_id, e.experience_years) IN(
        SELECT
            p.project_id,
            max(experience_years)
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
            dense_rank() over(
                PARTITION by a.project_id
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
            dense_rank() over(
                ORDER BY
                    sum(price) DESC
            ) rk
        FROM
            Sales
        GROUP BY
            seller_id
    ) t
WHERE
    t.rk = 1;