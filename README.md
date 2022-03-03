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

### 핵심 기능
- private ground 등록하기
- private ground 단건조회 / 여러건 조회
- private ground 삭제 또는 숨기기
- private ground 수정하기

### 어려웠던 부분
- No enum constant 에러 핸들링
- Location theme 컬럼 셋팅 (한 컬럼에 3가지를 다 넣을것인지, theme1~3으로 정할것인지?)

### 참고문헌
- [Mybatis Mapper 설정](https://mybatis.org/mybatis-3/ko/configuration.html#typeHandlers)
