DROP TABLE if EXISTS usuario;

DROP TABLE if EXISTS usuario_comodin;

create TABLE usuario(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    puntaje INTEGER
);
create TABLE usuario_comodin(
    id INTEGER,
    nombre TEXT NOT NULL,
    cantidad INTEGER
);
