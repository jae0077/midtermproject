
## 1. ํ ๊ตฌ์ฑ์๐ช

[๊ณฝํ๋ฆผ](https://github.com/gudfla1815) ๐ท, [์ ์งํ](https://github.com/jhshin29) ๐คช, [์์ฐ์ก](https://github.com/kingdomunder) ๐ง, [์ฐจ์ฌํ](https://github.com/jae0077) ๐คฆโโ๏ธ, [์ตํด๋ฆผ](https://github.com/choihaerim) ๐

[Our friend Github](https://github.com/jae0077/midtermproject)

## 2. Structureโ

-   Language : Java, JavaScript,
    
-   Freamwork : Spring Boot, Vue
    
-   DataBase : Oracle
    
-   Server : tomcat
    
-   **์ฌ์ฉ ๊ธฐ์ **
    
    `Maven` / `JPA` / `LOMBOK` / `JWT` / `w3.css` / `axios`

## 3. DB ๋ชจ๋ธ๋ง ๐ก

![DB๋ชจ๋ธ๋ง](https://user-images.githubusercontent.com/44844956/137851990-9127e20d-05dc-4434-9752-a583a33525d2.png)

## 4. API ๋ฌธ์ ๐

-   [ํฌ์คํธ๋งจ API](https://documenter.getpostman.com/view/9871305/UV5Ukef1)

## 5. Trouble Shooting ๐คฆ๐ป

-   Dateํ์์ return ํ ๋ ์คํ๋ง์ timezone์ด UTC๋ก ์ค์ ๋์ด ์์ด UTC ์๊ฐ์ผ๋ก ์ถ๋ ฅ๋๋ ํ์์ด ์์ด ์๋์ ์ฝ๋๋ก ํด๊ฒฐ
    -   @JsonFormat(pattern = "yyyy-MM-dd HH:MM", timezone = "Asia/Seoul")
    -   ์์ ์ฝ๋๋ก ํด๊ฒฐ๋์ค ์์์ผ๋ ์๊ฐ์ค ๋ถ์ด ๋์ผํ๊ฒ ๋์ค๋ ํ์์ด ๋ฐ์ํ์ฌ pattern์ค MM์ mm์ผ๋ก ๋ณ๊ฒฝํ๋ ํด๊ฒฐ๋์์
        -   @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
-   ์ํฐํค ์ค๋ฐ๊ฟ
    -   ์๋ฌ
        -   <textarea>ํ๊ทธ ์์์ ํ์คํธ๋ฅผ ์์ฑํ๊ณ  ์ถ๋ ฅํ  ๋, ์ค๋ฐ๊ฟ(\n)์ด ์ ๋๋ก ์ ์ฉ๋์ง ์๊ณ , ๋จ์ ๊ณต๋ฐฑ(space)์ผ๋ก ์ถ๋ ฅ๋จ
    -   ํด๊ฒฐ๋ฐฉ๋ฒ
        -   ์๋ ฅ๋ ๋ฐ์ดํฐ๋ฅผ <p>ํ๊ทธ์์ ์ถ๋ ฅํ  ๋, style์ space: pre line ์์ฑ์ ๋ถ์ฌํ๊ณ  ํด๊ฒฐ

## 6. ์์ฌ์ด ์  ๐ฅ

-   JWT์ ์ ํจ๊ธฐ๊ฐ์ด ๋ง๋ฃ๋์์ ๊ฒฝ์ฐ ํด๋น ๋ด์ฉ์ ํ๋ก ํธ์ ๋ฆฌํดํด์ฃผ๊ณ  ํ๋ก ํธ์์ ํ ํฐ์ refreshํ๋ api์ ์์ฒญํด ์๋ก์ด ํ ํฐ์ ๋ฐ๊ธ ๋ฐ์ ์ฌ์ฉํ์ด์ผ ํ๋๋ฐ ๊ธฐ๋ฅ์ด ๊ฑฐ์ ์์ฑ๋์์๋ ๋ฐ๊ฒฌํ์ฌ ์์ ์ฌํญ์ด ๋๋ฌด ๋ง์์ ธ ํด๊ฒฐํ์ง ๋ชปํ์ 
-   ์๊ฐ์ด ๋ถ์กฑํด ๊ด๋ฆฌ์ ํ์ด์ง๋ฅผ ๋ง๋ค์ง ๋ชปํ์ฌ ๊ฒ์๊ธ์ด๋ ํ์ ๋ฑ์ ํ๋ฒ์ ๊ด๋ฆฌํ์ง ๋ชปํจ

## 7. ์ฐธ๊ณ ์ฌํญ
- ํ๋ฉด์ค๊ณ์, ๊ธฐ๋ฅ๋ช์ธ์๋ [๋งํฌ](https://profuse-innocent-36b.notion.site/1883036a9f654ba0bf42f38f1871734b)์์ ํ์ธ ๊ฐ๋ฅํฉ๋๋ค.
