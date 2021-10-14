DECLARE
	TYPE tbl_ins IS TABLE OF SEAT%ROWTYPE INDEX BY binary_integer;
	seat_ins tbl_ins;

BEGIN
	FOR i IN 1 .. 20 LOOP
		seat_ins(i).seat_idx := seat_idx_seq.NEXTVAL;
		seat_ins(i).is_used := '0';
	END LOOP;

	forall i IN 1 .. 20 INSERT INTO SEAT VALUES seat_ins(i);
	
END;