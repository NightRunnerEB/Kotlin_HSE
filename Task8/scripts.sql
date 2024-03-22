-- select playlists where Rap and Rock tracks > 2
select p."name" as playlistName
from playlist p
         join playlisttrack p2 on p.playlistid = p2.trackid
         join track t on p2.trackid  = t.trackid
         join genre g on g.genreid  = t.trackid
where g."name" in ('Rap', 'Rock')
group by p."name"
having count(t.trackid) > 2;

-- find top-3 artist by count of tracks
select a."name" as Artist, count(t.trackid) as Tracks
from artist a
         join album a2 on a.artistid = a2.artistid
         join track t on t.albumid = a2.albumid
group by a.artistid
order by count(t.trackid) desc
limit 3;
