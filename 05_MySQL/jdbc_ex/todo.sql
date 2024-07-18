use jdbc_ex;

CREATE TABLE todo_user
(
    user_id    VARCHAR(50) PRIMARY KEY,
    name       VARCHAR(50)  NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM todo_user;

INSERT INTO todo_user (user_id, name, password)
VALUES ('tetz', '이효석', '1234'),
       ('siwan', '김시완', '1234'),
       ('na', '나건우', '1234');


CREATE TABLE todo2
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    user_id      VARCHAR(50)  NOT NULL,
    todo         VARCHAR(255) NOT NULL,
    is_completed BOOLEAN   DEFAULT FALSE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES todo_user (user_id) ON DELETE CASCADE
);

INSERT INTO todo2 (user_id, todo)
VALUES ('tetz', 'PPT 찍기'),
       ('tetz', '금요일에 쉬기 :)'),
       ('siwan', '다트 패자 부활전 우승 하기'),
       ('siwan', '강사님~'),
       ('na', '다트 우승하기'),
       ('na', 'RM 활동하기');

SELECT * FROM todo2;