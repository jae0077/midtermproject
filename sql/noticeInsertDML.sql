-- 회원
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'sjh', '01011112222', 'sjh', 'sjh', null);
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'lws', '01011112222', 'lws', 'lws', null);
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'khl', '01011112222', 'khl', 'khr', null);
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'chr', '01011112222', 'chr', 'chr', null);
INSERT INTO USERS VALUES (users_idx_seq.nextval, 'cjh', '01011112222', 'cjh', 'cjh', null);

-- 공지사항
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '오픈기념으로 무료 1일권 사용 가능', '2021-09-16', '[이벤트] 오픈기념 무료');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-09-17', '[공지] 좌석 사용 방법 공지입니다.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-09-25', '[이벤트] 7일권 무료 이벤트.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-09-26', '[공지] 좌석 청결을 유지해주세요.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-09-27', '[FAQ] 자주 묻는 질문에 대한 답변입니다.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-10-01', '[이벤트] 오늘 하루 무료 개방.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-10-02', '[공지] 좌석 분리 공지.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-10-05', '[공지] 자판기 사용 안내 드립니다.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-10-07', '[공지] 프린터기 사용 안내 드립니다.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-10-10', '[공지] 의자 원래 자리에서 옮기지 말아주세요.');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-10-16', '[이벤트] 오픈 1개월 이벤트');
INSERT INTO NOTICE VALUES (notice_idx_seq.nextval, '공지사항 내용입니다.', '2021-10-18', '[공지] 난방기 사용 안내');

-- 자유게시판
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-09-20 20:34:11', 'YYYY-MM-DD HH24:MI:SS'), '첫글이다', TO_DATE('2021-09-20 20:34:11', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-09-20 21:33:11', 'YYYY-MM-DD HH24:MI:SS'), '에어컨 틀어주세요', TO_DATE('2021-09-20 21:33:11', 'YYYY-MM-DD HH24:MI:SS'), 3);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-09-25 08:18:11', 'YYYY-MM-DD HH24:MI:SS'), '커피가 없어요', TO_DATE('2021-09-25 08:18:11', 'YYYY-MM-DD HH24:MI:SS'), 4);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-09-26 13:03:11', 'YYYY-MM-DD HH24:MI:SS'), '커피 채워주세요 ㅜㅜ', TO_DATE('2021-09-26 13:03:11', 'YYYY-MM-DD HH24:MI:SS'), 3);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-09-27 14:23:11', 'YYYY-MM-DD HH24:MI:SS'), '복사용지는 어디에다 문의해야하나요?', TO_DATE('2021-09-27 14:23:11', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-09-28 17:01:11', 'YYYY-MM-DD HH24:MI:SS'), '조용히 좀 씁시다', TO_DATE('2021-09-28 17:01:11', 'YYYY-MM-DD HH24:MI:SS'), 3);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-09-29 21:00:11', 'YYYY-MM-DD HH24:MI:SS'), '컴퓨터 모니터 없어진거 맞나요?', TO_DATE('2021-09-29 21:00:11', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-01 13:39:11', 'YYYY-MM-DD HH24:MI:SS'), '휴게실에서 노란색 공책 보신분', TO_DATE('2021-10-01 13:39:11', 'YYYY-MM-DD HH24:MI:SS'), 4);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-03 16:55:11', 'YYYY-MM-DD HH24:MI:SS'), '혹시 고3 있나요?', TO_DATE('2021-10-03 16:55:11', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-05 02:34:11', 'YYYY-MM-DD HH24:MI:SS'), '수능까지 얼마 안남았습니다', TO_DATE('2021-10-05 02:34:11', 'YYYY-MM-DD HH24:MI:SS'), 5);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-05 05:49:11', 'YYYY-MM-DD HH24:MI:SS'), '공무원 준비하는 분 있나요', TO_DATE('2021-10-05 05:49:11', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-06 00:23:11', 'YYYY-MM-DD HH24:MI:SS'), '키보드 소리 줄여주세요', TO_DATE('2021-10-06 00:23:11', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-11 19:56:11', 'YYYY-MM-DD HH24:MI:SS'), '점심 같이 드실 분?', TO_DATE('2021-10-11 19:56:11', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-13 23:12:11', 'YYYY-MM-DD HH24:MI:SS'), '에어컨 좀 켜주세요', TO_DATE('2021-10-13 23:12:11', 'YYYY-MM-DD HH24:MI:SS'), 4);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-15 22:11:11', 'YYYY-MM-DD HH24:MI:SS'), '너무 더워요 에어컨 좀 틀어주세요', TO_DATE('2021-10-15 22:11:11', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-15 23:38:11', 'YYYY-MM-DD HH24:MI:SS'), '휴게실에서 시끄럽게 떠들지 맙시다', TO_DATE('2021-10-15 23:38:11', 'YYYY-MM-DD HH24:MI:SS'), 3);
INSERT INTO BOARD VALUES (board_idx_seq.nextval, '게시글 내용입니다.', TO_DATE('2021-10-16 15:27:11', 'YYYY-MM-DD HH24:MI:SS'), '공부하기 싫네요', TO_DATE('2021-10-16 15:27:11', 'YYYY-MM-DD HH24:MI:SS'), 5);
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