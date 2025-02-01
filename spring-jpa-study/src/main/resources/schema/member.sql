CREATE TABLE IF NOT EXISTS member
(
    id              SERIAL PRIMARY KEY     comment 'PK',
    user_id         varchar(100)  not null comment 'userId',
    password        varchar(256)  not null comment 'password',
    created_at      DATETIME      not null COMMENT '생성일',
    created_by      VARCHAR(100)  not null COMMENT '생성자'
) comment '회원정보';