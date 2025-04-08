SELECT 
    d.DEPT_ID,
    d.DEPT_NAME_EN,
    ROUND(AVG(e.SAL),0) AS AVG_SAL
FROM
    HR_DEPARTMENT d INNER JOIN HR_EMPLOYEES e
    ON d.DEPT_ID = e.DEPT_ID
GROUP BY 
    e.DEPT_ID
ORDER BY
    AVG_SAL DESC;