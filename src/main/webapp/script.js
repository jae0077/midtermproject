function navBar(){
    navBarScript =
    `
    <div id="nav" class="w3-bar w3-black nav-bar">
        <img src="./img/logo.jpg" style="width:7%">
        <div style="float:right;"> 
            <a href="00_index.html" class="w3-bar-item w3-button w3-mobile">첫 페이지로</a>
            <a v-if="login" href="01_seat.html" class="nav-display-member w3-bar-item w3-button w3-mobile">좌석선택</a>
            <a v-if="login" href="02_ticket.html" class="nav-display-member w3-bar-item w3-button w3-mobile">이용권구매</a>
            <a class="dropdown w3-bar-item w3-button w3-mobile">커뮤니티
                <i class="fa fa-caret-down"></i>
                <div class="dropdown-content">
                    <a href="03_notice.html">공지사항</a>
                    <a href="03_board.html">자유게시판</a>
                </div>
            </a>
            <a href="04_info.html" class="w3-bar-item w3-button w3-mobile">이용안내</a>
            <a v-if="login" href="05_myPage.html" class="w3-bar-item w3-button w3-mobile">마이페이지</a>
            <a v-if="logout" href="05_signUp.html" class="w3-bar-item w3-button w3-mobile">회원가입</a>

            <a v-if="logout" href="06_logIn.html" class="w3-bar-item w3-button w3-mobile">로그인</a>
            <a v-if="login" @click="ClickLogout" class="w3-bar-item w3-button w3-mobile">로그아웃</a>
        </div>
    </div>
    `
    getSession = sessionStorage.getItem("session");
    getSession = JSON.parse(getSession);
    login = false;
    logout = true;
    if(getSession != null){
        logRecord();
    }
}

function footer(){
    footerScript =
    `
    <div class="w3-container w3-teal footer">
        <h5>Footer</h5>
        <p>Footer information goes here</p>
        <p>Footer information goes here</p>
        <p>Footer information goes here</p>
    </div>
    `
}

function logRecord(){
    login = !login;
    logout = !logout;
}
