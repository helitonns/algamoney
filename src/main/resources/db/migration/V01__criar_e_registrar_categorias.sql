CREATE TABLE categoria(
	codigo  serial not null,
	nome VARCHAR(50) NOT NULL,
	CONSTRAINT pk_categoria PRIMARY KEY (codigo)
) TABLESPACE pg_default;


INSERT INTO categoria (nome) VALUES ('Lazer');
INSERT INTO categoria (nome) VALUES ('Alimentação');
INSERT INTO categoria (nome) VALUES ('Supermercado');
INSERT INTO categoria (nome) VALUES ('Farmárcia');
INSERT INTO categoria (nome) VALUES ('Outros');