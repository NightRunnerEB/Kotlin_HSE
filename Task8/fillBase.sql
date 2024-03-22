insert into artist (artistid, "name")
values (1, 'Цой'),
       (2, 'ATL'),
       (3, 'Скриптонит'),
       (4, 'The Queen'),
       (5, 'DVRST'),
       (6, 'Macan');

insert into genre(genreid, "name")
values (1, 'Pop'),
       (2, 'Techno'),
       (3, 'Rock'),
       (4, 'Phonk');

insert into mediatype (mediatypeid, "name")
values (1, 'Live'),
       (2, 'Offline');

insert into album (albumid, title, artistid)
values (1, 'Кино', 1),
       (2, 'Лимб', 2),
       (3, 'Цепи', 3),
       (4, 'Bohemian Rhapsody', 4),
       (5, 'Rays of serenity', 5),
       (6, 'Кино', 6);

insert into track (trackid, name, albumid, mediatypeid, genreid)
values (1, 'Кино', 1, 2,1),
       (2, 'Лимб', 2,2,2),
       (3, 'Цепи', 3,2,2),
       (4, 'Bohemian Rhapsody', 4, 2, 4),
       (5, 'Rays of serenity', 5,2,4),
       (6, 'Кино', 6, 2, 3);

insert into playlist (playlistid, name)
values (1, 'Phonk for gym'),
       (2, 'Liked'),
       (3, 'Private playlist');

insert into playlisttrack (playlistid, trackid)
values (1, 4),
       (1, 5),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 6);
