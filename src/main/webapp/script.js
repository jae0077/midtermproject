function navBar(){
    navBarScript =
    `
    <div style="height:150px">
        <div id="nav" class="w3-bar nav-bar w3-black" style="height:80px;">
            <img src="./img/logo.jpg" style="width:7%">
            <div style="float:right; margin-right:5%"> 
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
        <div style="float:left; margin-left:20%">
            <ul style="text-align: left">
                <li> 상호명: (주)사락사락스터디카페	</li>
                <li> 사업장소재지: 335 효령로 서초1동 서초구 서울특별시 </li>	
                <li> 대표이사: 차재훈</li>
            </ul>
        </div>

        <div style="float:right; margin-right:20%">   
            <ul style="text-align: left">
                <li> 사업자등록정보: 이거 보여줄려고 어그로 끌었다</li>
                <li> 가맹점문의: 재훈님께 문의 ㄱㄱ	</li>
                <li><a href=" https://github.com/jae0077/midtermproject">GIT Hub 바로가기 </a></li>
            </ul>
        </div>
    </div>
    `
}

function logRecord(){
    login = !login;
    logout = !logout;
}
