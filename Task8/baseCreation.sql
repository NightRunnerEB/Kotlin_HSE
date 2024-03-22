create table artist(artisId serial primary key, name text);

create table album(albumId serial primary key, title text, artistId serial, foreign key(artistId) references artist(artistId));

create table genre(genreId serial primary key, name text);

create table mediaType(mediaTypeId serial primary key, name text);

create table track(trackId serial primary key,
                   name text,
                   albumId serial references album(albumId),
                   mediaTypeid serial references mediaType(mediatypeid),
                   genreId serial references genre(genreId));

create table playlist(playlistid serial primary key, name text);

create table playlisttrack(playlistId serial references playlist(playlistid),
                           trackId serial references track(trackId));


create table invoiceline(invoicelineid serial primary key,
                         invoiceid serial references  invoice(invoiceid),
                         trackid serial references track(trackId));
