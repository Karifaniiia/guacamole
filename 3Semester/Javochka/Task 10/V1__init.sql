
WITH student_avg AS (
    -- Подсчёт среднего балла для студентов, сдавших все предметы
    SELECT
        s.id AS student_id,
        s.name AS student_name,
        AVG(p.score) AS avg_mark
    FROM
        students s
            JOIN
        progress p ON s.id = p.idstudent
    WHERE
        p.score > 2
    GROUP BY
        s.id, s.name
    HAVING
        COUNT(p.namesubjects) = (SELECT COUNT(*) FROM subjects) -- Проверка, что студент сдал все предметы
)
SELECT
    student_name,
    avg_mark
FROM
    student_avg
ORDER BY
    avg_mark DESC
LIMIT 3; -- Выбор 3 лучших студентов
