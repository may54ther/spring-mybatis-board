###############################################
# TAG: 게시글
###############################################
CREATE TABLE post (
    id          INT          NOT NULL COMMENT 'PK, 고유번호' AUTO_INCREMENT,
    writer      VARCHAR(20)  NOT NULL COMMENT '작성자 이름',
    title       VARCHAR(100) NOT NULL COMMENT '게시글 제목',
    content     BLOB         NOT NULL COMMENT '게시글 내용',
    views       INT          NOT NULL COMMENT '조회수'              DEFAULT 0,
    ref_id      INT          NOT NULL COMMENT '참조 게시글 ID, 기본값은 현재 게시글 ID',
    `order`     INT          NOT NULL COMMENT '게시글 순서'           DEFAULT 0,
    indent      INT          NOT NULL COMMENT '게시글 깊이'           DEFAULT 0,
    create_date DATETIME     NOT NULL COMMENT '등록일'              DEFAULT CURRENT_TIMESTAMP,
    use_flag    VARCHAR(1)   NOT NULL COMMENT '사용여부(사용-T, 삭제-F)' DEFAULT 'T' CHECK (use_flag IN ('T', 'F')),
    PRIMARY KEY (id)
);

###############################################
# TAG: 댓글
###############################################
CREATE TABLE comment (
    id          INT           NOT NULL COMMENT 'PK, 고유번호' AUTO_INCREMENT,
    post_id     INT           NOT NULL COMMENT 'FK, 게시글 ID',
    writer      VARCHAR(20)   NOT NULL COMMENT '작성자 이름',
    content     VARCHAR(3000) NOT NULL COMMENT '댓글 내용',
    #     ref_id      INT           NOT NULL COMMENT '참조 댓글 ID, 기본값은 현재 댓글 ID',
    #     `order`     INT           NOT NULL COMMENT '댓글 순서'            DEFAULT 0,
    create_date DATETIME      NOT NULL COMMENT '등록일'              DEFAULT CURRENT_TIMESTAMP,
    use_flag    VARCHAR(1)    NOT NULL COMMENT '사용여부(사용-T, 삭제-F)' DEFAULT 'T' CHECK (use_flag IN ('T', 'F')),
    PRIMARY KEY (id),
    FOREIGN KEY (post_id)
        REFERENCES post (id) ON DELETE NO ACTION
);

CREATE INDEX post_id_idx ON post (id);
CREATE INDEX comment_id_idx ON comment (id);