-- view pagination
begin;
declare cur cursor for select * from new_view nv;
fetch 3 from cur;
commit;
