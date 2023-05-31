create database if not exists DepthOfDespair;

use DepthOfDespair;

create table usuario(
	nombreDeUsuario varchar(25) primary key,
    contraseña varchar(50)
);

create table partidaGuardada(
	id int auto_increment primary key,
    partida LONGTEXT
);

create table usuario_partidaGuardada(
	id_usuario varchar(25),
    id_partidaGuardada int,
    primary key(id_usuario, id_partidaGuardada),
    foreign key(id_usuario) references usuario(nombreDeUsuario),
    foreign key(id_partidaGuardada) references partidaGuardada(id)
);