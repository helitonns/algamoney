CREATE TABLE pessoa(
	codigo  serial not null,
	nome VARCHAR(50) NOT NULL,
        ativo boolean NOT NULL, 
        logradouro VARCHAR(100),
	numero VARCHAR(10),
        complemento VARCHAR(100),
        bairro VARCHAR(100),
        cep VARCHAR(20),
        cidade VARCHAR(100),
        estado VARCHAR(30),

        CONSTRAINT pk_pessoa PRIMARY KEY (codigo)
) TABLESPACE pg_default;


INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('ABRAÃO DA SILVA',TRUE,'RUA 01', '0001','COMPLEMENTO 01','BAIRRO 01', '69.000.000', 'CIDADE 01', 'ESTADO 01');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('BETINA NUNES',TRUE,'RUA 02', '0002','COMPLEMENTO 02','BAIRRO 02', '69.000.000', 'CIDADE 02', 'ESTADO 02');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('CAIO ALMEIDA',TRUE,'RUA 03', '0003','COMPLEMENTO 03','BAIRRO 03', '69.000.000', 'CIDADE 03', 'ESTADO 03');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('DANIELA ALENCAR',TRUE,'RUA 04', '0004','COMPLEMENTO 04','BAIRRO 04', '69.000.000', 'CIDADE 04', 'ESTADO 04');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('EDSON GENOR',TRUE,'RUA 07', '0007','COMPLEMENTO 07','BAIRRO 07', '69.000.000', 'CIDADE 071', 'ESTADO 07');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('FÁBIO ASSUNÇÃO',TRUE,'RUA 05', '0005','COMPLEMENTO 05','BAIRRO 05', '69.000.000', 'CIDADE 5', 'ESTADO 05');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('GARDENIA SOARES',TRUE,'RUA 06', '0006','COMPLEMENTO 06','BAIRRO 06', '69.000.000', 'CIDADE 06', 'ESTADO 06');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('HELITON NASCIMENTO',TRUE,'RUA 08', '0008','COMPLEMENTO 08','BAIRRO 08', '69.000.000', 'CIDADE 08', 'ESTADO 08');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('ÍNGRIDE GUIMARÃES',TRUE,'RUA 09', '0009','COMPLEMENTO 09','BAIRRO 09', '69.000.000', 'CIDADE 09', 'ESTADO 09');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('JOAQUIM SANTOS',TRUE,'RUA 10', '0010','COMPLEMENTO 10','BAIRRO 10', '69.000.000', 'CIDADE 10', 'ESTADO 10');