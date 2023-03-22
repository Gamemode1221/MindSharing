drop table users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,                          -- 일련번호 (자동 증가)
    name VARCHAR(255) NOT NULL,                     -- 이름
    email VARCHAR(255) NOT NULL UNIQUE,             -- 이메일 (중복 불가)
    password VARCHAR(255) NOT NULL,                 -- 비밀번호
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),    -- 생성일자
    updated_at TIMESTAMP                            -- 업데이트 일자 (NULL 가능)
);

-- 새로운 사용자 추가
INSERT INTO users (name, email, password) VALUES ('John Doe', 'johndoe@example.com', 'password123');

-- 사용자 정보 업데이트
UPDATE users SET name = 'Jane Doe', updated_at = NOW() WHERE id = 1;

-- 사용자 정보 삭제
DELETE FROM users WHERE id = 1;

-- 모든 사용자 정보 조회
SELECT * FROM users;
