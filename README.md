# spring-mybatis-board

> Spring Boot, MyBatis, Thymeleaf를 이용한 게시판 만들기 프로젝트

## 사용기술

` frontend`

- [Semantic UI](https://semantic-ui.com/)
- [Toast UI Edittor](https://ui.toast.com/tui-editor)
- [toastr](https://github.com/CodeSeven/toastr)

`backend`

- Spring Boot
- Thymeleaf
- Mybatis
- MariaDB

`log`

- Logback
- Lombok

---

## 구현 내용

### 게시판

> - 목록 (`/posts`)
> - 조회 (`/posts/{id}`)
> - 등록 (`/posts/add`)
> - 답글 (`/posts/{parentId}/reply`)
> - 수정 (`/posts/{id}/edit`)
> - 삭제 (`/posts/{id}/remove`)

1. 목록
    ```
   | No | 제목
   |----|----------------------
   | 9  | ᄂ게시글8의 답글 입니다.
   | 3  | 게시글3 입니다.
   | 2  | 게시글2 입니다.
   | 1  | 게시글1 입니다.
   | 4  |  ᄂ 게시글1의 답글 입니다.
   | 6  |   ᄂ 게시글4의 답글 입니다.
   | 5  |  ᄂ 게시글1의 답글 입니다.
   |----|----------------------
   ```
    - 페이지를 탐색할 수 있는 `페이지네이션`을 포함
        - 처음, 이전, N ~ (N+5), 다음, 마지막
        - 현재 페이지의 범위는 `1`이상, `전체 페이지`미만
        - 만약, 범위 내의 값이 넘어오는 경우 첫 페이지로 리다이렉트

2. 조회
    - URL을 조작해 삭제된 게시글을 조작하려고 할 때, `alert`로 안내
    - 게시글을 조회할 때 조회수 증가
3. 등록
    - 닉네임(20자), 제목(100자), 내용
    - 모든 내용은 필수 값이며, 검증 후 `toastr`으로 오류 메시지를 띄움
    - 내용은 `Toast UI Editor`을 연동해 `markdown`형태로 작성 가능

4. 수정
    - 게시글 수정 시에는 닉네임 수정 불가
5. 답글
    - 게시글 등록과 동일한 구조 (단, 상위게시글의 아이디 값을 넘겨받음)
6. 삭제
    - 게시글 삭제 유무를 `confirm`으로 확인
    - 실제 데이터를 삭제하지 않고 `use_flag`의 갱신을 통해 삭제 처리

### 로그

- `logback` 을 사용하여 일 단위로 로그를 파일로 저장
- `RequestLoggingAspect`, ⁠`ServiceLoggingAspect`은 컨트롤러의 요청, 서비스 단의 처리내용을 로그로 남김

---
