CREATE TABLE users (
    id         INT AUTO_INCREMENT  NOT NULL COMMENT 'PK, 고유번호',
    user_id    VARCHAR(100) UNIQUE NOT NULL COMMENT '아이디',
    password   VARCHAR(100)        NOT NULL COMMENT '비밀번호',
    email      VARCHAR(100) UNIQUE NULL COMMENT '이메일',
    name       VARCHAR(100) UNIQUE NULL COMMENT '이름 (별명)',
    thumbnail  VARCHAR(100)        NULL COMMENT '이미지',
    status     VARCHAR(10)         NOT NULL COMMENT '상태' CHECK (status IN ('DEFAULT', 'DELETED')),
    created_at DATETIME            NOT NULL COMMENT '회원 가입일' DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME            NULL COMMENT '최종 수정일',

    PRIMARY KEY (id)
);
CREATE INDEX user_id_idx ON users (id);

CREATE TABLE posts (
    id         INT AUTO_INCREMENT COMMENT 'PK, 고유번호',
    user_id    VARCHAR(100) UNIQUE                    NULL COMMENT '작성자 ID',
    writer     VARCHAR(100)                           NOT NULL COMMENT '작성자명',
    title      VARCHAR(100)                           NOT NULL COMMENT '제목',
    content    BLOB                                   NOT NULL COMMENT '내용',
    views      INT        DEFAULT 0                   NOT NULL COMMENT '조회수',
    ref_id     INT                                    NOT NULL COMMENT '참조 게시글 ID, 기본값은 현재 게시글 ID',
    parent_id  INT        DEFAULT 0                   NULL COMMENT '부모 게시글 ID',
    step       INT        DEFAULT 0                   NOT NULL COMMENT '게시글 순서',
    level      INT        DEFAULT 0                   NULL COMMENT '게시글 깊이',
    status     VARCHAR(1) DEFAULT 'T'                 NOT NULL COMMENT '사용 여부 (사용-T, 삭제-F)' CHECK (status IN ('T', 'F')),
    created_at DATETIME   DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '등록일',

    PRIMARY KEY (id)
);
CREATE INDEX post_id_idx ON posts (id);

CREATE TABLE comments (
    id         INT AUTO_INCREMENT COMMENT 'PK, 고유번호',
    post_id    INT                                    NOT NULL COMMENT 'FK, 게시글 ID',
    user_id    VARCHAR(100) UNIQUE                    NULL COMMENT '작성자 ID',
    writer     VARCHAR(100)                           NOT NULL COMMENT '작성자명',
    content    VARCHAR(3000)                          NOT NULL COMMENT '내용',
    ref_id     INT                                    NOT NULL COMMENT '참조 댓글 ID, 기본값은 현재 댓글 ID',
    step       INT        DEFAULT 0                   NOT NULL COMMENT '댓글 순서',
    status     VARCHAR(1) DEFAULT 'T'                 NOT NULL COMMENT '사용 여부 (사용-T, 삭제-F)' CHECK (status IN ('T', 'F')),
    created_at DATETIME   DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '등록일',

    PRIMARY KEY (id),
    CONSTRAINT comment_ib_fk_1 FOREIGN KEY (post_id) REFERENCES posts (id)
);
CREATE INDEX comment_id_idx ON comments (id);
