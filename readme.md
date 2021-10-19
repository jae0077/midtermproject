
## 1. 팀 구성원👪

[곽형림](https://github.com/gudfla1815) 😷, [신지혜](https://github.com/jhshin29) 🤪, [임우송](https://github.com/kingdomunder) 🧐, [차재훈](https://github.com/jae0077) 🤦‍♂️, [최해림](https://github.com/choihaerim) 🐆

[Our friend Github](https://github.com/jae0077/midtermproject)

## 2. Structure⚙

-   Language : Java, JavaScript,
    
-   Freamwork : Spring Boot, Vue
    
-   DataBase : Oracle
    
-   Server : tomcat
    
-   **사용 기술**
    
    `Maven` / `JPA` / `LOMBOK` / `JWT` / `w3.css` / `axios`

## 3. DB 모델링 🏡

![DB모델링](https://user-images.githubusercontent.com/44844956/137851990-9127e20d-05dc-4434-9752-a583a33525d2.png)

## 4. API 문서 📄

-   [포스트맨 API](https://documenter.getpostman.com/view/9871305/UV5Ukef1)

## 5. Trouble Shooting 🤦🏻

-   Date타입을 return 할때 스프링의 timezone이 UTC로 설정되어 있어 UTC 시간으로 출력되는 현상이 있어 아래의 코드로 해결
    -   @JsonFormat(pattern = "yyyy-MM-dd HH:MM", timezone = "Asia/Seoul")
    -   위의 코드로 해결된줄 알았으나 시간중 분이 동일하게 나오는 현상이 발생하여 pattern중 MM을 mm으로 변경하니 해결되었음
        -   @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
-   엔터키 줄바꿈
    -   에러
        -   <textarea>태그 안에서 텍스트를 작성하고 출력할 때, 줄바꿈(\n)이 제대로 적용되지 않고, 단순 공백(space)으로 출력됨
    -   해결방법
        -   입력된 데이터를 <p>태그에서 출력할 때, style에 space: pre line 속성을 부여하고 해결

## 6. 아쉬운 점 😥

-   JWT의 유효기간이 만료되었을 경우 해당 내용을 프론트에 리턴해주고 프론트에서 토큰을 refresh하는 api에 요청해 새로운 토큰을 발급 받아 사용했어야 하는데 기능이 거의 완성되었을때 발견하여 수정사항이 너무 많아져 해결하지 못한점
-   시간이 부족해 관리자 페이지를 만들지 못하여 게시글이나 회원 등을 한번에 관리하지 못함

## 7. 참고사항
- 화면설계서, 기능명세서는 [링크](https://profuse-innocent-36b.notion.site/1883036a9f654ba0bf42f38f1871734b)에서 확인 가능합니다.
