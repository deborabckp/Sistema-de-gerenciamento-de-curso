DROP TABLE IF EXISTS aluno CASCADE;
DROP TABLE IF EXISTS professor CASCADE;
DROP TABLE IF EXISTS curso CASCADE;
DROP TABLE IF EXISTS inscricao;



CREATE TABLE aluno(
	matricula BIGINT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	telefone VARCHAR(14),
	email VARCHAR(50),
	senha VARCHAR(15) NOT NULL,
	curso_de_graduacao VARCHAR(60)
);

CREATE TABLE professor(
	matricula BIGINT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	telefone VARCHAR(14),
	email VARCHAR(50),
	senha VARCHAR(15) NOT NULL,
	formacao VARCHAR(60)
);

CREATE TABLE curso(
	id_curso INT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL, 
	descricao VARCHAR(200),
	data_inicio DATE,
	data_fim DATE,
	carga_horaria INT,
	vagas INT,
	modalidade VARCHAR(30),
	matricula_professor BIGINT REFERENCES professor(matricula) ON DELETE SET NULL
);

CREATE TABLE  inscricao(
	id_inscricao INT PRIMARY KEY,
	data_de_inscricao DATE NOT NULL,
	nota DECIMAL(3, 1),
	frequencia INT,
	status VARCHAR(30),
	matricula_aluno BIGINT REFERENCES aluno(matricula) ON DELETE SET NULL,
	id_curso INT REFERENCES curso(id_curso) ON DELETE SET NULL
);