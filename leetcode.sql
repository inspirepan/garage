-- 180 连续3个1
select
    distinct num as consecutivenums
from
    logs
where
    (id + 1, num) in (
        select
            *
        from
            logs
    )
    and (id + 2, num) in (
        select
            *
        from
            logs
    );

-- 181 比经理工资高的员工
select
    a.name employee
from
    employee a
    join employee b on a.managerid = b.id
where
    a.salary > b.salary;

--182 数量大于2的email
select
    email
from
    person
group by
    email
having
    count(email) >= 2;

--183
select
    customers.name as customers
from
    customers
    left join orders on customers.id = orders.customerid
where
    orders.customerid is null;

--184
select
    d.name as department,
    e.name as employee,
    e.salary
from
    department d
    left join employee e on d.id = e.departmentid
where
    (e.salary, e.departmentid) in (
        select
            max(salary),
            departmentid
        from
            employee
        group by
            departmentid
    );

--185
select
    d.name as department,
    e.name as employee,
    e.salary as salary
from
    department d
    left join employee e on d.id = e.departmentid
where
    e.id in (
        select
            e1.id
        from
            employee e1
            left join employee e2 on e1.departmentid = e2.departmentid
            and e1.salary < e2.salary
        group by
            e1.id
        having
            count(distinct e2.salary) <= 2
    )
    and e.departmentid in (
        select
            id
        from
            department
    )
order by
    d.id asc,
    e.salary desc;

--185 用函数
select
    department,
    employee,
    salary
from
    (
        select
            d.name as department,
            e.name as employee,
            e.salary as salary,
            dense_rank() over (
                partition by departmentid
                order by
                    salary desc
            ) as rk
        from
            employee e
            left join department d on e.departmentid = d.id
    ) m
where
    rk <= 3;

--196 注意删除的时候不能根据这个表select出来的记录删除，必须要嵌套一层select才能删除
delete from
    person
where
    id not in (
        select
            *
        from
            (
                select
                    min(id)
                from
                    person
                group by
                    email
            ) t
    );

--197
select
    w1.id
from
    weather w1
    join weather w2 on w1.recorddate = adddate(w2.recorddate, 1)
where
    w1.temperature > w2.temperature;

--511
select
    player_id,
    min(event_date) first_login
from
    activity
group by
    player_id;

--512
select
    player_id,
    device_id
from
    activity
where
    (player_id, event_date) in (
        select
            player_id,
            min(event_date)
        from
            activity
        group by
            player_id
    );

--534 通过连引一个表条件是日期比当前日期小的全部项
select
    a1.player_id,
    a1.event_date,
    sum(a2.games_played) games_played_so_far
from
    activity a1
    left join activity a2 on a1.player_id = a2.player_id
    and a1.event_date >= a2.event_date
group by
    a1.player_id,
    a1.event_date
order by
    a1.player_id,
    a1.event_date;

--550
select
    round(
        count(distinct player_id) / (
            select
                count(distinct player_id)
            from
                activity a2
        ),
        2
    ) fraction
from
    activity
where
    (player_id, event_date) in(
        select
            player_id,
            adddate(min(event_date), 1)
        from
            activity
        group by
            partition
    );

--570
select
    m.name
from
    employee m
    left join employee e on e.managerid = m.id
group by
    m.id
having
    count(e.id) >= 5;

--571 先把每一个数的asc_amount，desc_amount，total_num算出来
select
    avg(num) as median
from
    (
        select
            num,
            sum(frequency) over(
                order by
                    num asc
            ) asc_amount,
            sum(frequency) over(
                order by
                    num desc
            ) desc_amount,
            sum(frequency) over() total_num
        from
            numbers
    ) a
where
    asc_amount >= total_num / 2
    and desc_amount >= total_num / 2;

--574
select
    c.name
from
    candidate c
    join vote v on v.candidateid = c.id
group by
    c.id
having
    count(*) >= all(
        select
            count(*)
        from
            vote
        group by
            candidateid
    );

--577
select
    e.name,
    b.bonus
from
    employee e
    left join bonus b on e.empid = b.empid
where
    coalesce(b.bonus, 0) < 1000;

--578
select
    question_id survey_log
from
    (
        select
            a.question_id,
            (
                count(a.question_id) / (
                    select
                        count(*)
                    from
                        surveylog b
                    where
                        b.action = 'show'
                        and b.question_id = a.question_id
                )
            ) rate
        from
            surveylog a
        where
            a.action = 'answer'
        group by
            a.question_id
        order by
            rate desc,
            a.question_id asc
        limit
            1 offset 0
    ) result;

--579 窗口函数不太会用
select
    id,
    month,
    salary
from
    (
        select
            id,
            month,
            sum(salary) over (
                partition by id
                order by
                    month rows 2 preceding
            ) as salary,
            rank() over (
                partition by id
                order by
                    month desc
            ) as r
        from
            employee
    ) t
where
    r > 1
order by
    id,
    month desc;

--580
select
    dept_name,
    count(s.student_id) student_number
from
    department d
    left join student s on s.dept_id = d.dept_id
group by
    dept_name
order by
    student_nubmer desc,
    dept_name;

--584
select
    name
from
    customer
where
    referee_id is null
    or referee_id <> 2;

--586
select
    distinct customer_number
from
    orders
group by
    customer_number
order by
    count(customer_number) desc
limit
    1;

select
    customer_number
from
    orders
group by
    customer_number
having
    count(order_number) >= all(
        select
            count(order_number)
        from
            orders
        group by
            customer_number
    );

-- 595
select
    name,
    population,
    area
from
    world
where
    population >= 25000000
    or area >= 3000000;

--596
select
    distinct class
from
    courses
group by
    class
having
    count(student) >= 5;

--603
select
    distinct c1.seat_id
from
    cinema c1
    join cinema c2 on c2.seat_id = c1.seat_id + 1
    or c2.seat_id = c1.seat_id -1
where
    c1.free = 1
    and c2.free = 1;

--607
select
    name
from
    salesperson
where
    sales_id not in (
        select
            s.sales_id
        from
            salesperson s
            right join orders o on o.sales_id = s.sales_id
            inner join company c on o.com_id = c.com_id
        where
            c.name = 'RED'
    );

--608
select
    t.id,
    case
        when t.p_id is null then 'Root'
        when t.id in (
            select
                p_id
            from
                tree
        ) then 'Inner'
        else 'Leaf'
    end as type
from
    tree t;

--610
select
    x,
    y,
    z,
    case
        when x + y > z
        and y + z > x
        and x + z > y then 'Yes'
        else 'No'
    end as triangle
from
    triangle;

--612
select
    round(
        min(
            sqrt(power(p1.x - p2.x, 2) + power(p1.y - p2.y, 2))
        ),
        2
    ) shortest
from
    point2d p1
    left join point2d p2 on (p1.x, p1.y) <> (p2.x, p2.y);

--613
select
    min(abs(p1.x - p2.x)) shortest
from
    point p1
    left join point p2 on p1.x <> p2.x;

--614
select
    f1.follower,
    count(distinct f2.follower) num
from
    follow f1
    join follow f2 on f2.followee = f1.follower
group by
    f1.follower
order by
    f1.follower;

--615
select
    distinct date_format(pay_date, '%Y-%m') pay_month,
    department_id,
    case
        when a1 > a2 then 'higher'
        when a1 < a2 then 'lower'
        else 'same'
    end as comparison
from
    (
        select
            e.department_id,
            pay_date,
            avg(amount) over(partition by department_id, pay_date) a1,
            avg(amount) over(partition by pay_date) a2
        from
            salary s
            left join employee e on s.employee_id = e.employee_id
    ) c
order by
    pay_month desc