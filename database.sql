
USE mozaik_database

CREATE TABLE users
(
    nama_lengkap      VARCHAR(100) NOT NULL,
    nama_ibu         VARCHAR(100) NOT NULL,
    no_stambuk       VARCHAR(100) NOT NULL,
    password         VARCHAR(100) NOT NULL,
    token            VARCHAR(100),
    kategori_user    VARCHAR(100),
    label            VARCHAR(100),
    PRIMARY KEY (no_stambuk),
    UNIQUE (token),
    FOREIGN KEY fk_user_mahasantri (no_stambuk) REFERENCES mahasantri (no_stambuk)
) ENGINE InnoDB;

 CREATE TABLE mahasantri
(
    no_stambuk   VARCHAR(100) NOT NULL,
    nama_lengkap   VARCHAR(100) NOT NULL,
    nama_ibu VARCHAR(100) NOT NULL,
    bagian      VARCHAR(100) NOT NULL,
    alamat      VARCHAR(100) NOT NULL,
    latitude    VARCHAR(100) NOT NULL,
    longitude   VARCHAR(100) NOT NULL,
    no_wa       VARCHAR(100),
    khidmah     VARCHAR(100),
    status      text,
    quotes      text NOT NULL,
    link_photo varchar(100),
    PRIMARY KEY (no_stambuk)

) ENGINE InnoDB;

CREATE TABLE mustahik
(
    id_mustahik VARCHAR(100) NOT NULL,
    nama_lengkap VARCHAR(100) NOT NULL,
    tanggal_lahir VARCHAR(100) NOT NULL,
    alamat VARCHAR(100) NOT NULL,
    latitude VARCHAR(100),
    longitude VARCHAR(100),
    no_wa VARCHAR(100),
    sosmed VARCHAR(100),
    kesan VARCHAR(100),
    keterangan VARCHAR(20),
    link_photo VARCHAR(100),
    PRIMARY KEY (id_mustahik),
     FOREIGN KEY fk_mustahik_mahasantri (id_mustahik) REFERENCES mahasantri (no_stambuk)
) ENGINE InnoDB;

CREATE TABLE notifikasi
(
id_notifikasi INT NOT NULL AUTO_INCREMENT,
no_stambuk VARCHAR(100) NOT NULL,
nama_lengkap VARCHAR(100) NOT NULL,
label VARCHAR(100) NOT NULL,
isi_notifikasi TEXT NOT NULL,
tanggal VARCHAR(100) NOT NULL,
terbaca VARCHAR(10) NOT NULL,
PRIMARY KEY (id_notifikasi),
FOREIGN KEY fk_user_notifikasi (no_stambuk) REFERENCES users(no_stambuk)

) ENGINE InnoDB;


CREATE TABLE ziaroh
(
    id    INT NOT NULl AUTO_INCREMENT,
    nama_tempat  VARCHAR(100) NOT NULL,
    alamat VARCHAR(100) NOT NULL,
    latitude  VARCHAR(100) NOT NULL,
    longitude VARCHAR(100) NOT NULL,
    deskripsi   text NOT NULL,
    id_video VARCHAR(100),
    photo1 varchar(100),
    photo2 varchar(100),
    photo3 varchar(100),
    photo4 varchar(100),
    photo5 varchar(100),
    PRIMARY KEY (id)
) ENGINE InnoDB;



