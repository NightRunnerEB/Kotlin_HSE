create view new_view as
select ar.name as "Artist", al.title as "Album", tr.name as "Track", g.name as "Genre"
from artist ar
         join album al
              on ar.artistId = al.artistId
         join track tr
              on tr.albumId = al.albumid
         join genre g
              on tr.genreId = g.genreid
