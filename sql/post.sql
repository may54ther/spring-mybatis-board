CREATE TABLE post (
    id         INT AUTO_INCREMENT COMMENT 'PK, 고유번호' PRIMARY KEY,
    writer     VARCHAR(20)                            NOT NULL COMMENT '작성자 이름',
    title      VARCHAR(100)                           NOT NULL COMMENT '게시글 제목',
    content    BLOB                                   NOT NULL COMMENT '게시글 내용',
    views      INT        DEFAULT 0                   NOT NULL COMMENT '조회수',
    ref_id     INT                                    NOT NULL COMMENT '참조 게시글 ID, 기본값은 현재 게시글 ID',
    parent_id  INT        DEFAULT 0                   NULL COMMENT '상위 게시글 ID',
    step       INT        DEFAULT 0                   NOT NULL COMMENT '게시글 순서',
    level      INT        DEFAULT 0                   NULL COMMENT '게시글 깊이',
    created_at DATETIME   DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '등록일',
    use_flag   VARCHAR(1) DEFAULT 'T'                 NOT NULL COMMENT '사용여부(사용-T, 삭제-F)',
    CONSTRAINT use_flag CHECK (`use_flag` IN ('T', 'F'))
);

CREATE INDEX post_id_idx ON post (id);

INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (130, '작성자', '제목130', 0xEB82B4EC9AA9, 1, 130, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (129, '작성자', '제목129', 0xEB82B4EC9AA9, 0, 129, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, parent_id, step, level, created_at, use_flag)
VALUES (131, '작성자', '[답글] 128-1', 0xEB82B4EC9AA9, 0, 128, 128, 1, 1, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, parent_id, step, level, created_at, use_flag)
VALUES (134, '작성자', '[답글] 128-2', 0xEB82B4EC9AA9, 1, 128, 128, 2, 1, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, parent_id, step, level, created_at, use_flag)
VALUES (132, '작성자', '[답글] 128-131-1', 0xEB82B4EC9AA9, 7, 128, 131, 3, 2, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, parent_id, step, level, created_at, use_flag)
VALUES (138, '작성자', '[답글] 128-133-2', 0xEB82B4EC9AA9, 7, 128, 131, 4, 2, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, parent_id, step, level, created_at, use_flag)
VALUES (139, '작성자', '[답글] 128-133-3', 0xEB82B4EC9AA9, 0, 128, 131, 5, 2, '2022-08-26 21:49:35.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, parent_id, step, level, created_at, use_flag)
VALUES (133, '작성자', '[답글] 128-3', 0xEB82B4EC9AA9, 0, 128, 128, 6, 1, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, parent_id, step, level, created_at, use_flag)
VALUES (135, '작성자', '[답글] 128-133-1', 0xEB82B4EC9AA9, 0, 128, 133, 7, 2, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, parent_id, step, level, created_at, use_flag)
VALUES (137, '작성자', '[답글] 128-133-2', 0xEB82B4EC9AA9, 0, 128, 133, 8, 2, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, parent_id, step, level, created_at, use_flag)
VALUES (136, '작성자', '[답글] 128-4', 0xEB82B4EC9AA9, 0, 128, 128, 9, 1, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (128, '작성자', '제목128', 0xEB82B4EC9AA9, 0, 128, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (127, '작성자', '제목127', 0xEB82B4EC9AA9, 0, 127, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (126, '작성자', '제목126', 0xEB82B4EC9AA9, 0, 126, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (125, '작성자', '제목125', 0xEB82B4EC9AA9, 0, 125, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (124, '작성자', '제목124', 0xEB82B4EC9AA9, 0, 124, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (123, '작성자', '제목123', 0xEB82B4EC9AA9, 0, 123, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (122, '작성자', '제목122', 0xEB82B4EC9AA9, 0, 122, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (121, '작성자', '제목121', 0xEB82B4EC9AA9, 0, 121, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (120, '작성자', '제목120', 0xEB82B4EC9AA9, 0, 120, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (119, '작성자', '제목119', 0xEB82B4EC9AA9, 0, 119, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (118, '작성자', '제목118', 0xEB82B4EC9AA9, 0, 118, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (117, '작성자', '제목117', 0xEB82B4EC9AA9, 0, 117, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (116, '작성자', '제목116', 0xEB82B4EC9AA9, 0, 116, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (115, '작성자', '제목115', 0xEB82B4EC9AA9, 0, 115, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (114, '작성자', '제목114', 0xEB82B4EC9AA9, 0, 114, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (113, '작성자', '제목113', 0xEB82B4EC9AA9, 0, 113, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (112, '작성자', '제목112', 0xEB82B4EC9AA9, 0, 112, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (111, '작성자', '제목111', 0xEB82B4EC9AA9, 0, 111, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (110, '작성자', '제목110', 0xEB82B4EC9AA9, 0, 110, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (109, '작성자', '제목109', 0xEB82B4EC9AA9, 0, 109, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (108, '작성자', '제목108', 0xEB82B4EC9AA9, 0, 108, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (107, '작성자', '제목107', 0xEB82B4EC9AA9, 0, 107, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (106, '작성자', '제목106', 0xEB82B4EC9AA9, 0, 106, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (105, '작성자', '제목105', 0xEB82B4EC9AA9, 0, 105, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (104, '작성자', '제목104', 0xEB82B4EC9AA9, 0, 104, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (103, '작성자', '제목103', 0xEB82B4EC9AA9, 0, 103, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (102, '작성자', '제목102', 0xEB82B4EC9AA9, 0, 102, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (101, '작성자', '제목101', 0xEB82B4EC9AA9, 0, 101, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (100, '작성자', '제목100', 0xEB82B4EC9AA9, 0, 100, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (99, '작성자', '제목99', 0xEB82B4EC9AA9, 0, 99, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (98, '작성자', '제목98', 0xEB82B4EC9AA9, 0, 98, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (97, '작성자', '제목97', 0xEB82B4EC9AA9, 0, 97, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (96, '작성자', '제목96', 0xEB82B4EC9AA9, 0, 96, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (95, '작성자', '제목95', 0xEB82B4EC9AA9, 0, 95, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (94, '작성자', '제목94', 0xEB82B4EC9AA9, 0, 94, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (93, '작성자', '제목93', 0xEB82B4EC9AA9, 0, 93, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (92, '작성자', '제목92', 0xEB82B4EC9AA9, 0, 92, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (91, '작성자', '제목91', 0xEB82B4EC9AA9, 0, 91, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (90, '작성자', '제목90', 0xEB82B4EC9AA9, 0, 90, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (89, '작성자', '제목89', 0xEB82B4EC9AA9, 0, 89, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (88, '작성자', '제목88', 0xEB82B4EC9AA9, 0, 88, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (87, '작성자', '제목87', 0xEB82B4EC9AA9, 0, 87, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (86, '작성자', '제목86', 0xEB82B4EC9AA9, 0, 86, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (85, '작성자', '제목85', 0xEB82B4EC9AA9, 0, 85, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (84, '작성자', '제목84', 0xEB82B4EC9AA9, 0, 84, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (83, '작성자', '제목83', 0xEB82B4EC9AA9, 0, 83, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (82, '작성자', '제목82', 0xEB82B4EC9AA9, 0, 82, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (81, '작성자', '제목81', 0xEB82B4EC9AA9, 0, 81, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (80, '작성자', '제목80', 0xEB82B4EC9AA9, 0, 80, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (79, '작성자', '제목79', 0xEB82B4EC9AA9, 0, 79, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (78, '작성자', '제목78', 0xEB82B4EC9AA9, 0, 78, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (77, '작성자', '제목77', 0xEB82B4EC9AA9, 0, 77, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (76, '작성자', '제목76', 0xEB82B4EC9AA9, 0, 76, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (75, '작성자', '제목75', 0xEB82B4EC9AA9, 0, 75, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (74, '작성자', '제목74', 0xEB82B4EC9AA9, 0, 74, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (73, '작성자', '제목73', 0xEB82B4EC9AA9, 0, 73, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (72, '작성자', '제목72', 0xEB82B4EC9AA9, 0, 72, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (71, '작성자', '제목71', 0xEB82B4EC9AA9, 0, 71, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (70, '작성자', '제목70', 0xEB82B4EC9AA9, 0, 70, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (69, '작성자', '제목69', 0xEB82B4EC9AA9, 0, 69, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (68, '작성자', '제목68', 0xEB82B4EC9AA9, 0, 68, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (67, '작성자', '제목67', 0xEB82B4EC9AA9, 0, 67, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (66, '작성자', '제목66', 0xEB82B4EC9AA9, 0, 66, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (65, '작성자', '제목65', 0xEB82B4EC9AA9, 0, 65, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (64, '작성자', '제목64', 0xEB82B4EC9AA9, 0, 64, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (63, '작성자', '제목63', 0xEB82B4EC9AA9, 0, 63, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (62, '작성자', '제목62', 0xEB82B4EC9AA9, 0, 62, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (61, '작성자', '제목61', 0xEB82B4EC9AA9, 0, 61, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (60, '작성자', '제목60', 0xEB82B4EC9AA9, 0, 60, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (59, '작성자', '제목59', 0xEB82B4EC9AA9, 0, 59, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (58, '작성자', '제목58', 0xEB82B4EC9AA9, 0, 58, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (57, '작성자', '제목57', 0xEB82B4EC9AA9, 0, 57, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (56, '작성자', '제목56', 0xEB82B4EC9AA9, 0, 56, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (55, '작성자', '제목55', 0xEB82B4EC9AA9, 0, 55, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (54, '작성자', '제목54', 0xEB82B4EC9AA9, 0, 54, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (53, '작성자', '제목53', 0xEB82B4EC9AA9, 0, 53, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (52, '작성자', '제목52', 0xEB82B4EC9AA9, 0, 52, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (51, '작성자', '제목51', 0xEB82B4EC9AA9, 0, 51, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (50, '작성자', '제목50', 0xEB82B4EC9AA9, 0, 50, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (49, '작성자', '제목49', 0xEB82B4EC9AA9, 0, 49, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (48, '작성자', '제목48', 0xEB82B4EC9AA9, 0, 48, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (47, '작성자', '제목47', 0xEB82B4EC9AA9, 0, 47, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (46, '작성자', '제목46', 0xEB82B4EC9AA9, 0, 46, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (45, '작성자', '제목45', 0xEB82B4EC9AA9, 0, 45, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (44, '작성자', '제목44', 0xEB82B4EC9AA9, 0, 44, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (43, '작성자', '제목43', 0xEB82B4EC9AA9, 0, 43, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (42, '작성자', '제목42', 0xEB82B4EC9AA9, 0, 42, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (41, '작성자', '제목41', 0xEB82B4EC9AA9, 0, 41, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (40, '작성자', '제목40', 0xEB82B4EC9AA9, 0, 40, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (39, '작성자', '제목39', 0xEB82B4EC9AA9, 0, 39, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (38, '작성자', '제목38', 0xEB82B4EC9AA9, 0, 38, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (37, '작성자', '제목37', 0xEB82B4EC9AA9, 0, 37, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (36, '작성자', '제목36', 0xEB82B4EC9AA9, 0, 36, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (35, '작성자', '제목35', 0xEB82B4EC9AA9, 0, 35, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (34, '작성자', '제목34', 0xEB82B4EC9AA9, 0, 34, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (33, '작성자', '제목33', 0xEB82B4EC9AA9, 0, 33, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (32, '작성자', '제목32', 0xEB82B4EC9AA9, 0, 32, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (31, '작성자', '제목31', 0xEB82B4EC9AA9, 0, 31, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (30, '작성자', '제목30', 0xEB82B4EC9AA9, 0, 30, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (29, '작성자', '제목29', 0xEB82B4EC9AA9, 0, 29, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (28, '작성자', '제목28', 0xEB82B4EC9AA9, 0, 28, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (27, '작성자', '제목27', 0xEB82B4EC9AA9, 0, 27, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (26, '작성자', '제목26', 0xEB82B4EC9AA9, 0, 26, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (25, '작성자', '제목25', 0xEB82B4EC9AA9, 0, 25, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (24, '작성자', '제목24', 0xEB82B4EC9AA9, 0, 24, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (23, '작성자', '제목23', 0xEB82B4EC9AA9, 0, 23, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (22, '작성자', '제목22', 0xEB82B4EC9AA9, 0, 22, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (21, '작성자', '제목21', 0xEB82B4EC9AA9, 0, 21, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (20, '작성자', '제목20', 0xEB82B4EC9AA9, 0, 20, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (19, '작성자', '제목19', 0xEB82B4EC9AA9, 0, 19, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (18, '작성자', '제목18', 0xEB82B4EC9AA9, 0, 18, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (17, '작성자', '제목17', 0xEB82B4EC9AA9, 0, 17, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (16, '작성자', '제목16', 0xEB82B4EC9AA9, 0, 16, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (15, '작성자', '제목15', 0xEB82B4EC9AA9, 0, 15, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (14, '작성자', '제목14', 0xEB82B4EC9AA9, 0, 14, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (13, '작성자', '제목13', 0xEB82B4EC9AA9, 0, 13, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (12, '작성자', '제목12', 0xEB82B4EC9AA9, 0, 12, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (11, '작성자', '제목11', 0xEB82B4EC9AA9, 0, 11, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (10, '작성자', '제목10', 0xEB82B4EC9AA9, 0, 10, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (9, '작성자', '제목9', 0xEB82B4EC9AA9, 0, 9, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (8, '작성자', '제목8', 0xEB82B4EC9AA9, 0, 8, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (7, '작성자', '제목7', 0xEB82B4EC9AA9, 0, 7, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (6, '작성자', '제목6', 0xEB82B4EC9AA9, 0, 6, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (5, '작성자', '제목5', 0xEB82B4EC9AA9, 0, 5, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (4, '작성자', '제목4', 0xEB82B4EC9AA9, 0, 4, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (3, '작성자', '제목3', 0xEB82B4EC9AA9, 0, 3, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (2, '작성자', '제목2', 0xEB82B4EC9AA9, 0, 2, 0, 0, '2022-08-25 23:51:00.0', 'T');
INSERT INTO web.post (id, writer, title, content, views, ref_id, step, level, created_at, use_flag)
VALUES (1, '작성자', '제목1', 0xEB82B4EC9AA9, 0, 1, 0, 0, '2022-08-25 23:51:00.0', 'T');
