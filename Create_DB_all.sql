DROP DATABASE IF EXISTS crud_escola;
CREATE DATABASE crud_escola;
USE crud_escola;

DROP TABLE IF EXISTS cursos;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE cursos 
(
    id_curso				INT NOT NULL AUTO_INCREMENT,
    nome_curso				VARCHAR(50) NOT NULL,
    periodo_curso			VARCHAR(10) NOT NULL,
    PRIMARY KEY ( id_curso ),
    UNIQUE ( nome_curso )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS materias;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE materias 
(
    id_materia     			INT NOT NULL AUTO_INCREMENT,
    nome_materia			VARCHAR(50) NOT NULL,
    semestre_materia 		INT NOT NULL,
    curso_id        		INT NOT NULL,
    professor_id  			INT,
    PRIMARY KEY ( id_materia ),
    CONSTRAINT mat_unique UNIQUE ( nome_materia, semestre_materia, curso_id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS professores;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE professores 
(
    id_professor			INT NOT NULL AUTO_INCREMENT,
    nome_professor      	VARCHAR(50) NOT NULL,
    cpf_professor       	VARCHAR(20) NOT NULL,
    formacao_professor		VARCHAR(50) NOT NULL,
    usuario_id				INT,
    PRIMARY KEY ( id_professor ),
    UNIQUE ( cpf_professor, usuario_id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS alunos;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE alunos
(
    id_aluno       			INT NOT NULL AUTO_INCREMENT,
    nome_aluno     			VARCHAR(50) NOT NULL,
    ra_aluno       			VARCHAR(20) NOT NULL,
    cpf_aluno      			VARCHAR(20) NOT NULL,
    nasc_aluno     			DATE NOT NULL,
    usuario_id				INT,
    PRIMARY KEY ( id_aluno ),
    UNIQUE ( ra_aluno, cpf_aluno, usuario_id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS matriculas;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE matriculas 
(
	id_matricula			INT NOT NULL AUTO_INCREMENT,
    materia_id      		INT NOT NULL,
    aluno_id        		INT NOT NULL,
    ano_matricula			INT NOT NULL,
    semestre_matricula		INT NOT NULL,
    nota_1_matricula    	INT NULL DEFAULT 0.0,
    nota_2_matricula    	INT NULL DEFAULT 0.0,
    nota_final_matricula	DOUBLE NULL DEFAULT 0.0,
    faltas_matricula        INT NULL DEFAULT 0,
    situacao_id 			INT NOT NULL,
    PRIMARY KEY ( id_matricula )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS situacoes;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE situacoes 
(
    id_situacao        		INT NOT NULL AUTO_INCREMENT,
    descricao_situacao		VARCHAR(20),
    PRIMARY KEY ( id_situacao ),
    UNIQUE ( descricao_situacao )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS usuarios;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE usuarios 
(
    id_usuario        		INT NOT NULL AUTO_INCREMENT,
    user_usuario      		VARCHAR(20) NOT NULL,
    password_usuario  		VARCHAR(255) NOT NULL,
    regra_usuario			VARCHAR(20) NOT NULL,
    ativo_usuario			BOOLEAN NULL DEFAULT 0,
    PRIMARY KEY ( id_usuario ),
    UNIQUE ( user_usuario )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE materias
    ADD CONSTRAINT materias_cursos_fk FOREIGN KEY ( curso_id )
        REFERENCES cursos ( id_curso );

ALTER TABLE materias
    ADD CONSTRAINT materias_professores_fk FOREIGN KEY ( professor_id )
        REFERENCES professores ( id_professor );

ALTER TABLE matriculas
    ADD CONSTRAINT matriculas_alunos_fk FOREIGN KEY ( aluno_id )
        REFERENCES alunos ( id_aluno );

ALTER TABLE matriculas
    ADD CONSTRAINT matriculas_materias_fk FOREIGN KEY ( materia_id )
        REFERENCES materias ( id_materia );
        
ALTER TABLE matriculas
    ADD CONSTRAINT matriculas_situacoes_fk FOREIGN KEY ( situacao_id )
        REFERENCES situacoes ( id_situacao );
        
ALTER TABLE alunos
    ADD CONSTRAINT alunos_usuarios_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuarios ( id_usuario );

ALTER TABLE professores
    ADD CONSTRAINT professores_usuarios_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuarios ( id_usuario );

-- Usuário - Administrador
insert into usuarios (user_usuario, password_usuario, regra_usuario, ativo_usuario)
values ('admin', '$2a$10$TMfY1IunLWQy/wfKgltNZ.jyaJObeOdAfBK2VPicJzVh10P0nnDQO', 'ROLE_ADM', 1);