USE jdbc_ex;

CREATE TABLE user_table
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    userid      VARCHAR(50)  NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    age         INT          NOT NULL,
    membership  BOOLEAN      NOT NULL DEFAULT 0,
    signup_date TIMESTAMP             DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO user_table (userid, name, password, age, membership)
VALUES ('jihee', '정지희', '1234', 25, 1);
-- UPDATE user_table SET userid = 'jihee' WHERE name='정지희';

INSERT INTO user_table (userid, name, password, age, membership)
VALUES ('kimsiwan', '김시완', '1234', 30, 1);

INSERT INTO user_table (userid, name, password, age, membership)
VALUES ('imsiwan', '임시완', '1234', 38, 0);

INSERT INTO user_table (userid, name, password, age, membership)
VALUES ('pororo', '뽀로로', '1234', 10, 0);

INSERT INTO user_table (userid, name, password, age, membership)
VALUES ('luppy', '김루피', '1234', 9, 1);

SELECT * FROM user_table;
