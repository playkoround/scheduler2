# scheduler2

### API 작성
게시글

| FUNCTION | METHOD | URL | REQUEST | RESPONSE | STATUS CODE |
| --- | --- | --- | --- | --- | --- |
| 일정 등록 | POST | /schedules | { "title": "", "content": "" } | { "id": 1, 
"title": "", "content": "" } | 201: Created |
| 일정 삭제 | DELETE | /schedules/{id} | params { id : n } | { "message": "삭제 완료” } | 204: no content |
| 일정 수정 | PUT | /schedules/{id} | { "title": "", "content": "" } | { "id": 1, 
"title": "", "content": "" } | 200: 정상수정 |
| 일정 조회 | GET | /schedules/{id} | params { id : n } | { "id": 1, 
"title": "", "content": "" } | 200: 정상조회 |

댓글

| FUNCTION | METHOD | URL | REQUEST | RESPONSE | STATUS CODE |
| --- | --- | --- | --- | --- | --- |
| 댓글 등록 | POST | /schedules/{id}/comments | { "content": "" } | { "id": 1, "content": "" } | 200: 정상등록 |
| 댓글 삭제 | DELETE | /comments/{id} | params { id : n } | { "message": "삭제 완료” } | 200: 정상삭제 |
| 댓글 수정 | PUT | /comments/{id} | { "content": "" } | { "id": 1, "content": "" } | 200: 정상수정 |
| 댓글 조회 | GET | /comments/{id} | params { id : n } | { "id": 1, "content": "" } | 200: 정상조회 |

대댓글

| FUNCTION | METHOD | URL | REQUEST | RESPONSE | STATUS CODE |
| --- | --- | --- | --- | --- | --- |
| 대댓글 등록 | POST | /comments/{id}/replies | { "content": "" } | { "id": 1, "content": "" } | 200: 정상등록 |
| 대댓글 삭제 | DELETE | /replies/{id} | params { id : n } | { "message": "삭제 완료” } | 200: 정상삭제 |
| 대댓글 수정 | PUT | /replies/{id} | { "content": "" } | { "id": 1, "content": "" } | 200: 정상수정 |
| 대댓글 조회 | GET | /replies/{id} | params { id : n } | { "id": 1, "content": "" } | 200: 정상조회 |


