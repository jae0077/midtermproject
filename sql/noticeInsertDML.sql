-- 회원
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'sjh', '01011112222', 'sjh', 'sjh', null);
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'lws', '01011112222', 'lws', 'lws', null);
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'khl', '01011112222', 'khl', 'khr', null);
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'chr', '01011112222', 'chr', 'chr', null);
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'cjh', '01011112222', 'cjh', 'cjh', null);

-- 공지사항
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '오픈기념으로 무료 1일권 사용 가능', '2021-09-16', '[이벤트] 오픈기념 무료');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'홈페이지 로그인 -> 좌석 선택'||CHR(10)||'[마이페이지]에서 좌석 변경 또한 가능합니다.'||CHR(10)||'감사합니다.', '2021-09-17', '[공지] 좌석 사용 방법 공지입니다.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'무료 이벤트는 언제나 관리자의 맘입니다.'||CHR(10)||'놓치지 마시고 신청하세요.'||CHR(10)||'감사합니다.', '2021-09-25', '[이벤트] 7일권 무료 이벤트.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'요사이 휴게실 및 자리들이 너무 더럽습니다.'||CHR(10)||'반드시 본인 자리는 본인이 치워주시고 규칙이 자주 위반된다면 CCTV로 확인하여 범인을 잡겠습니다.'||CHR(10)||'감사합니다.', '2021-09-26', '[공지] 좌석 청결을 유지해주세요.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '사실 그런 건 없습니다', '2021-09-27', '[FAQ] 자주 묻는 질문에 대한 답변입니다.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'오늘 하루 무료 오픈합니다.'||CHR(10)||'왜냐면 그건 관리자 맘입니다. 그렇게 아세요.'||CHR(10)||'감사합니다.', '2021-10-01', '[이벤트] 오늘 하루 무료 개방.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'그동안 좌석이 너무 붙어 있어서 불편하셨죠? 드디어 분리했습니다.'||CHR(10)||'써보시고 불편하시면 또 말씀해주세요!'||CHR(10)||'감사합니다.', '2021-10-02', '[공지] 좌석 분리 공지.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'여러분의 편의를 위해 내부에 자판기를 설치했습니다.'||CHR(10)||'드시고 싶은 음료가 있다면 말씀해주시고, 자판기를 발로 차는 등의 행위는 삼가주세요!'||CHR(10)||'감사합니다.', '2021-10-05', '[공지] 자판기 사용 안내 드립니다.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'프린터는 카드 충전 후 사용 가능합니다.'||CHR(10)||'카드 구입 및 자세한 문의는 카운터로 오셔서 해주세요.'||CHR(10)||'감사합니다.', '2021-10-07', '[공지] 프린터기 사용 안내 드립니다.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'최근 내부 의자들이 자꾸 한 군데로 몰려 있는 상황이 발견 되었습니다.'||CHR(10)||'모두의 편의를 위해 의자는 반드시 있던 자리에 되돌려 놓아 주시길 부탁드립니다.'||CHR(10)||'감사합니다.', '2021-10-10', '[공지] 의자 원래 자리에서 옮기지 말아주세요.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'사락사락 오픈 1달을 맞아 현재 이용권 구매자 모두에게 스타벅스 기프티콘을 증정합니다.'||CHR(10)||'카운터에 오셔서 받아가세요!'||CHR(10)||'감사합니다.', '2021-10-16', '[이벤트] 오픈 1개월 이벤트');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '안녕하세요 관리자입니다.'||CHR(10)||CHR(10)||'난방 사용이 오늘부터 가능합니다.'||CHR(10)||'단, 임의대로 만지시는 것은 안되고 관리자에게 문의주시면 적절하게 조정해드리겠습니다!'||CHR(10)||'감사합니다.', '2021-10-18', '[공지] 난방기 사용 안내');

-- 자유게시판
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '아싸 1빠', TO_DATE('2021-09-20 20:34:11', 'YYYY-MM-DD HH24:MI:SS'), '첫글이다', TO_DATE('2021-09-20 20:34:11', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '더워요 ㅜㅜㅜ', TO_DATE('2021-09-20 21:33:11', 'YYYY-MM-DD HH24:MI:SS'), '에어컨 틀어주세요', TO_DATE('2021-09-20 21:33:11', 'YYYY-MM-DD HH24:MI:SS'), 3);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '커피.... 떨어진지 이틀째...', TO_DATE('2021-09-25 08:18:11', 'YYYY-MM-DD HH24:MI:SS'), '커피가 없어요', TO_DATE('2021-09-25 08:18:11', 'YYYY-MM-DD HH24:MI:SS'), 4);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '커피가 없으면 공부를 할 수가 없어요', TO_DATE('2021-09-26 13:03:11', 'YYYY-MM-DD HH24:MI:SS'), '커피 채워주세요 ㅜㅜ', TO_DATE('2021-09-26 13:03:11', 'YYYY-MM-DD HH24:MI:SS'), 3);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '프린터 용지가 없어요!!!!! 관리자님!!!!', TO_DATE('2021-09-27 14:23:11', 'YYYY-MM-DD HH24:MI:SS'), '복사용지는 어디에다 문의해야하나요?', TO_DATE('2021-09-27 14:23:11', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '자리에서 속닥거리지 말아주세요... 진짜 거슬려요', TO_DATE('2021-09-28 17:01:11', 'YYYY-MM-DD HH24:MI:SS'), '조용히 좀 씁시다', TO_DATE('2021-09-28 17:01:11', 'YYYY-MM-DD HH24:MI:SS'), 3);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '어제까지만 해도 분명히 있었는데...?', TO_DATE('2021-09-29 21:00:11', 'YYYY-MM-DD HH24:MI:SS'), '컴퓨터 모니터 없어진거 맞나요?', TO_DATE('2021-09-29 21:00:11', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '그거 진짜 중요한 건데 ㅜㅜㅜ 혹시 보신 분 9번 자리로 알려주세요 ㅜㅜ', TO_DATE('2021-10-01 13:39:11', 'YYYY-MM-DD HH24:MI:SS'), '휴게실에서 노란색 공책 보신분', TO_DATE('2021-10-01 13:39:11', 'YYYY-MM-DD HH24:MI:SS'), 4);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '수능특강 알려주실 같은 고3분 구합니다', TO_DATE('2021-10-03 16:55:11', 'YYYY-MM-DD HH24:MI:SS'), '혹시 고3 있나요?', TO_DATE('2021-10-03 16:55:11', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '열심히 공부합시다들', TO_DATE('2021-10-05 02:34:11', 'YYYY-MM-DD HH24:MI:SS'), '수능까지 얼마 안남았습니다', TO_DATE('2021-10-05 02:34:11', 'YYYY-MM-DD HH24:MI:SS'), 5);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '같이 공부합시다!!!! 댓글 달아주세요', TO_DATE('2021-10-05 05:49:11', 'YYYY-MM-DD HH24:MI:SS'), '공무원 준비하는 분 있나요', TO_DATE('2021-10-05 05:49:11', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '누우가 이렇게 조용한데서 기계식 키보드를 치나?', TO_DATE('2021-10-06 00:23:11', 'YYYY-MM-DD HH24:MI:SS'), '키보드 소리 줄여주세요', TO_DATE('2021-10-06 00:23:11', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '저는 6번 자리에 앉아있습니다 말 걸어 주세요', TO_DATE('2021-10-11 19:56:11', 'YYYY-MM-DD HH24:MI:SS'), '점심 같이 드실 분?', TO_DATE('2021-10-11 19:56:11', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '오늘 25도에요'||CHR(10)||'공부하다 죽어요', TO_DATE('2021-10-13 23:12:11', 'YYYY-MM-DD HH24:MI:SS'), '에어컨 좀 켜주세요', TO_DATE('2021-10-13 23:12:11', 'YYYY-MM-DD HH24:MI:SS'), 4);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '아직 날이 더워요 ㅜㅜㅜㅜ'||CHR(10)||'제발 에어컨 좀 틀어주세요', TO_DATE('2021-10-15 22:11:11', 'YYYY-MM-DD HH24:MI:SS'), '너무 더워요 에어컨 좀 틀어주세요', TO_DATE('2021-10-15 22:11:11', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '휴게실에서 누가 그렇게 시끄럽게 떠드는지 시끄러워서 살 수가 없어요', TO_DATE('2021-10-15 23:38:11', 'YYYY-MM-DD HH24:MI:SS'), '휴게실에서 시끄럽게 떠들지 맙시다', TO_DATE('2021-10-15 23:38:11', 'YYYY-MM-DD HH24:MI:SS'), 3);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '가을이어서 공부하기 너무 싫어요'||CHR(10)||'어디 놀러라도 가고 싶은 날이네요', TO_DATE('2021-10-16 15:27:11', 'YYYY-MM-DD HH24:MI:SS'), '공부하기 싫네요', TO_DATE('2021-10-16 15:27:11', 'YYYY-MM-DD HH24:MI:SS'), 5);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '날씨가 10도 아래로 내려갔는데 아직도 에어컨이라뇨?', TO_DATE('2021-10-17 13:30:11', 'YYYY-MM-DD HH24:MI:SS'), '에어컨 좀 줄여주세요', TO_DATE('2021-10-17 13:30:11', 'YYYY-MM-DD HH24:MI:SS'), 2);

-- 댓글
INSERT INTO COMMENTS VALUES (comment_idx_seq.nextval, '맞아요 이제 난방 켜주세용', TO_DATE('2021-10-17 13:31:39', 'YYYY-MM-DD HH24:MI:SS'), 18, 1);
INSERT INTO COMMENTS VALUES (comment_idx_seq.nextval, '실내는 아직 좀 더운거 같은데용', TO_DATE('2021-10-17 13:32:18', 'YYYY-MM-DD HH24:MI:SS'), 18, 4);
INSERT INTO COMMENTS VALUES (comment_idx_seq.nextval, '오늘 저 패딩입고 왔습니다만용', TO_DATE('2021-10-17 13:35:11', 'YYYY-MM-DD HH24:MI:SS'), 18, 2);
INSERT INTO COMMENTS VALUES (comment_idx_seq.nextval, '더우신 분이 옷을 좀 벗어용', TO_DATE('2021-10-17 13:31:39', 'YYYY-MM-DD HH24:MI:SS'), 18, 3);
INSERT INTO COMMENTS VALUES (comment_idx_seq.nextval, '싫어용 반팔입었어용 이래라저래라하지 마용', TO_DATE('2021-10-17 13:31:39', 'YYYY-MM-DD HH24:MI:SS'), 18, 4);
INSERT INTO COMMENTS VALUES (comment_idx_seq.nextval, '커피 없으면 공부를 못해요', TO_DATE('2021-09-25 16:23:11', 'YYYY-MM-DD HH24:MI:SS'), 3, 3);
INSERT INTO COMMENTS VALUES (comment_idx_seq.nextval, '어우 시끄러워', TO_DATE('2021-10-17 13:31:39', 'YYYY-MM-DD HH24:MI:SS'), 12, 5);
INSERT INTO COMMENTS VALUES (comment_idx_seq.nextval, '저두요... 피씨방 가실 분', TO_DATE('2021-10-16 15:56:11', 'YYYY-MM-DD HH24:MI:SS'), 17, 2);
INSERT INTO COMMENTS VALUES (comment_idx_seq.nextval, '저요 13번이에요', TO_DATE('2021-10-17 13:31:39', 'YYYY-MM-DD HH24:MI:SS'), 13, 2);

commit;