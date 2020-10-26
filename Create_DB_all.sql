DROP DATABASE IF EXISTS crud_escola;
CREATE DATABASE crud_escola;
USE crud_escola;

DROP TABLE IF EXISTS curso;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE curso (
    id    INT NOT NULL AUTO_INCREMENT,
    nome  VARCHAR(50) NOT NULL,
    CONSTRAINT curso_pk PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS materia;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE materia (
    id      INT NOT NULL AUTO_INCREMENT,
    nome     VARCHAR(50) NOT NULL,
    curso_id INT NOT NULL,
    CONSTRAINT materia_pk PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS professor;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE professor (
    id         INT NOT NULL AUTO_INCREMENT,
    nome       VARCHAR(50) NOT NULL,
    cpf        VARCHAR(20) NOT NULL,
    formacao   VARCHAR(50) NOT NULL,
    materia_id INT NOT NULL,
    CONSTRAINT professor_pk PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS aluno;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE aluno (
    id       INT NOT NULL AUTO_INCREMENT,
    nome     VARCHAR(50) NOT NULL,
    ra       VARCHAR(20) NOT NULL,
    cpf      VARCHAR(20) NOT NULL,
    nasc  DATE NOT NULL,
    curso_id INT NOT NULL,
    CONSTRAINT aluno_pk PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;  

CREATE UNIQUE INDEX professor_idx ON
    professor (
        materia_id
    ASC ); 

ALTER TABLE aluno
    ADD CONSTRAINT aluno_curso_fk FOREIGN KEY ( curso_id )
        REFERENCES curso ( id );

ALTER TABLE materia
    ADD CONSTRAINT materia_curso_fk FOREIGN KEY ( curso_id )
        REFERENCES curso ( id );

ALTER TABLE professor
    ADD CONSTRAINT professor_materia_fk FOREIGN KEY ( materia_id )
        REFERENCES materia ( id );