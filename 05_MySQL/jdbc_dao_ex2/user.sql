CREATE
    DATABASE user_ex2;
USE
    user_ex2;

CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    email    VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100)        NOT NULL
);
SELECT *
FROM users;

INSERT INTO users (email, password)
VALUES ('tetz', '1234'),
       ('siwan', '1234'),
       ('na', '1234');

CREATE TABLE user_info
(
    id   INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,

    FOREIGN KEY (id) REFERENCES users (id) ON DELETE CASCADE
);

SELECT * FROM user_info;

INSERT INTO user_info (id, name)
VALUES ('1', '이효석'),
       ('2', '김시완'),
       ('3', '나건우');