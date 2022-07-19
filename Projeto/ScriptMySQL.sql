CREATE DATABASE IF NOT EXISTS Imobiliária;

USE Imobiliária;

DROP TABLE IF EXISTS Negócio;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Imóvel;
DROP TABLE IF EXISTS Endereço;
DROP TABLE IF EXISTS Comodo;

CREATE TABLE Endereço(
    Cep VARCHAR(10) NOT NULL,
    Rua VARCHAR(80) NOT NULL, 
    Numero INT NOT NULL,
    Complemento VARCHAR(80), 
    Bairro VARCHAR(30) NOT NULL, 
    Cidade VARCHAR(20) NOT NULL, 
    Estado INT NOT NULL,
    
    SequencialEnd INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Comodo(
    Dormitorios VARCHAR(80),
    Ambientes VARCHAR(80),
    Serviços VARCHAR(80),
    Bwc INT,
    
    SequencialCom INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Imóvel(    
    AreaTotal FLOAT,
    Valor FLOAT,
    Segurança BOOLEAN,
    Tipo ENUM ("Casa", "Apartamento"),
    
    SequencialImo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    EndereçoId INT NOT NULL,
    ComodosId INT NOT NULL,
    FOREIGN KEY (EndereçoId) REFERENCES Endereço (SequencialEnd),
    FOREIGN KEY (ComodosId) REFERENCES Comodo(SequencialCom)
);

CREATE TABLE Cliente(
    Nome VARCHAR(80) NOT NULL,
    Cpf VARCHAR(15) NOT NULL PRIMARY KEY,
    RendaBruta FLOAT NOT NULL,
    Telefone VARCHAR(12),
    Profissão VARCHAR(40)
);

CREATE TABLE Negócio(
    Fiador BOOLEAN NOT NULL,
    Tipo ENUM ("Aluguel", "Venda") NOT NULL,
    
    SequencialNeg INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClienteId VARCHAR(15) NOT NULL,
    ImovelId INT NOT NULL,
    FOREIGN KEY (ClienteId) REFERENCES Cliente (Cpf),
    FOREIGN KEY (ImovelId) REFERENCES Imóvel (SequencialImo)
    
);


INSERT INTO Cliente (Nome, Cpf, RendaBruta, Telefone, Profissão) VALUES ("Tyler Durden", "542.655.573-23", 1500.23, "6399756-2034", "Fabricante de Sabão");
INSERT INTO Cliente (Nome, Cpf, RendaBruta, Telefone, Profissão) VALUES ("Tony Montana", "345.173.652-32", 95000.00, "6599345-9823", "Traficante");
INSERT INTO Cliente (Nome, Cpf, RendaBruta, Telefone, Profissão) VALUES ("Hannibal Lecter", "534.593.954-43", 8000.54, "8398464-2104", "Psiquiatra");
INSERT INTO Cliente (Nome, Cpf, RendaBruta, Telefone, Profissão) VALUES ("Mia Wallace", "456.234.764-78", 81001.00, "1198765-2304", "Mafiosa");
INSERT INTO Cliente (Nome, Cpf, RendaBruta, Telefone, Profissão) VALUES ("Norma Bates", "543.978.124-93", 1145.23, "533490-1835", "Gerente de Hotel");
INSERT INTO Cliente (Nome, Cpf, RendaBruta, Telefone, Profissão) VALUES ("Dexter Morgan", "932.054.483-29", 3456.77, "6799801-0857", "Analista Forense" );
INSERT INTO Cliente (Nome, Cpf, RendaBruta, Telefone, Profissão) VALUES ("Walter White", "054.394.611-83", 60458.00, "3394657-3247", "Professor de Quimica");
 
INSERT INTO Comodo (Dormitorios, Ambientes, Serviços, Bwc) VALUES ("1 Suíte Master", "1 Sala de Estar; 1 Sala de Jantar", "1 Cozinha Planejada; 1 Areas de Serviço; 1 Copa; 3 Cozinha compacta", 2);
INSERT INTO Comodo (Dormitorios, Ambientes, Serviços, Bwc) VALUES ("1 Suíte com Hidro; 3 Suites Simples", "1 Sala de Estar; 1 Sala de Jantar; Sala de TV; 1 Escritório", "1 Cozinha Planejada; 2 Areas de Serviço; 1 Cozinha Gourmet", 2);
INSERT INTO Comodo (Dormitorios, Ambientes, Serviços, Bwc) VALUES ("3 Suítes Simples", "1 Sala de Estar; 1 Sala de Jantar; Sala de TV", "2 Cozinha; 2 Areas de Serviço; 1 Copa", 2);
INSERT INTO Comodo (Dormitorios, Ambientes, Serviços, Bwc) VALUES ("1 Suite Master; 2 Suítes Simples", "1 Sala de Estar", "1 Cozinha; 1 Area de Serviço", 4);
INSERT INTO Comodo (Dormitorios, Ambientes, Serviços, Bwc) VALUES ("1 Quartos", "1 Sala de Estar", "1 Cozinha; 1 Area de Serviço", 1);
INSERT INTO Comodo (Dormitorios, Ambientes, Serviços, Bwc) VALUES ("2 Quartos", "1 Sala de Estar", "1 Cozinha", 1);
INSERT INTO Comodo (Dormitorios, Ambientes, Serviços, Bwc) VALUES ("2 Suítes Simples", "1 Sala de Estar", "1 Cozinha", 3);

INSERT INTO Endereço (Cep, Rua, Numero, Complemento, Bairro, Cidade, Estado) VALUES ("79374-624", "Rua França", 125, "Em frente ao Hipermercado Extra", "Jardim Europa", "Cuiabá", 11);
INSERT INTO Endereço (Cep, Rua, Numero, Complemento, Bairro, Cidade, Estado) VALUES ("79374-624", "Delmar de Oliveira", 1919, "", "Vila São Luiz", "Vitória", 7);
INSERT INTO Endereço (Cep, Rua, Numero, Complemento, Bairro, Cidade, Estado) VALUES ("79615-901", "Jacarandá", 85, "", "Ecoville I", "Goiás", 8);
INSERT INTO Endereço (Cep, Rua, Numero, Complemento, Bairro, Cidade, Estado) VALUES ("79848-234", "Eulalia Pires", 2800, "apto 704, bloco A", "Jardim Tropical", "Dourados", 11);
INSERT INTO Endereço (Cep, Rua, Numero, Complemento, Bairro, Cidade, Estado) VALUES ("79589-241", "Ciro Melo", 484, "Kit-01", "Jardim Tropical", "Ilhéus", 5);
INSERT INTO Endereço (Cep, Rua, Numero, Complemento, Bairro, Cidade, Estado) VALUES ("79371-639", "Coronel Noronha", 1065, "Apto B", "Vila Industrial", "Crateús", 6);
INSERT INTO Endereço (Cep, Rua, Numero, Complemento, Bairro, Cidade, Estado) VALUES ("79848-234", "Eulalia Pires", 2800, "Apto 703, bloco A", "Jardim Tropical", "Dourados", 11);


INSERT INTO Imóvel (AreaTotal, Valor, Segurança, Tipo, EndereçoId, ComodosId) VALUES (596.00, 1500.00, TRUE, "Casa", 1, 1);
INSERT INTO Imóvel (AreaTotal, Valor, Segurança, Tipo, EndereçoId, ComodosId) VALUES (550.72, 8558.00, FALSE, "Casa", 2, 2);
INSERT INTO Imóvel (AreaTotal, Valor, Segurança, Tipo, EndereçoId, ComodosId) VALUES (432.00, 7000.00, TRUE, "Casa", 3, 3);
INSERT INTO Imóvel (AreaTotal, Valor, Segurança, Tipo, EndereçoId, ComodosId) VALUES (102.43, 2350.00, TRUE, "Apartamento", 4, 4);
INSERT INTO Imóvel (AreaTotal, Valor, Segurança, Tipo, EndereçoId, ComodosId) VALUES (71.05, 400.00, FALSE, "Apartamento", 5, 5);
INSERT INTO Imóvel (AreaTotal, Valor, Segurança, Tipo, EndereçoId, ComodosId) VALUES (62.65, 350.00, FALSE, "Apartamento", 6, 6);
INSERT INTO Imóvel (AreaTotal, Valor, Segurança, Tipo, EndereçoId, ComodosId) VALUES (88.13, 1243.00, FALSE, "Apartamento", 7, 7);


 
INSERT INTO Negócio(Fiador, Tipo, ClienteId, ImovelId) VALUES (TRUE, "Aluguel", "054.394.611-83", 4);
INSERT INTO Negócio(Fiador, Tipo, ClienteId, ImovelId) VALUES (TRUE, "Venda", "542.655.573-23", 7 );
INSERT INTO Negócio(Fiador, Tipo, ClienteId, ImovelId) VALUES (FALSE, "Aluguel", "543.978.124-93", 1);
INSERT INTO Negócio(Fiador, Tipo, ClienteId, ImovelId) VALUES (FALSE, "Venda", "543.978.124-93", 6);
