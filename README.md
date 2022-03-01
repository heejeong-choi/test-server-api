# MUST OUTDOOR - Server API

### 개발 환경
- Window 10
- Intellij
- Java 11
- Spring boot 2.6.3 
- Maven
- Mybatis
- MySQL

### DB 설계(ERD)
![image](https://user-images.githubusercontent.com/80879782/155894084-bf8b1e5b-2688-4f16-bd84-bc4d334cab93.png)


### Use cases
- A host can only have one private ground at the page
- Host can register their private ground
- Host should pick more than 3 types of location themes

### 핵심 기능
- private ground 등록하기
- private ground 단건조회 / 여러건 조회
- private ground 삭제 또는 숨기기
- private ground 수정하기

### 어려웠던 부분
- No enum constant 에러 핸들링

### 참고문헌
- [Mybatis Mapper 설정](https://mybatis.org/mybatis-3/ko/configuration.html#typeHandlers)
- 