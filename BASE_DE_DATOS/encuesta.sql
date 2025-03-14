-- Asegurarse de estar en la base de datos correcta
USE bdencuesta;

-- Desactivar comprobación de claves foráneas para evitar errores durante el DROP y la creación
SET FOREIGN_KEY_CHECKS = 0;

-- ============================================
-- Eliminar tablas en orden inverso de dependencias
-- ============================================
DROP TABLE IF EXISTS paquete_turistico_encuesta;
DROP TABLE IF EXISTS organiza_viaje_encuesta;
DROP TABLE IF EXISTS aranceles_encuesta;
DROP TABLE IF EXISTS alojamiento_encuesta_pais;
DROP TABLE IF EXISTS acompanante_encuesta;
DROP TABLE IF EXISTS encuestas;
DROP TABLE IF EXISTS paquete_turistico;
DROP TABLE IF EXISTS organiza_viaje;
DROP TABLE IF EXISTS aranceles;
DROP TABLE IF EXISTS alojamiento;
DROP TABLE IF EXISTS acompanantes;
DROP TABLE IF EXISTS motivo_viaje;
DROP TABLE IF EXISTS tipo_gasto;
DROP TABLE IF EXISTS paises;
DROP TABLE IF EXISTS usuarios;

-- ============================================
-- Crear tablas independientes (base)
-- ============================================
CREATE TABLE usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(45) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  usuario VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY usuario_UNIQUE (usuario)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE paises (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE motivo_viaje (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE tipo_gasto (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE acompanantes (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE alojamiento (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE aranceles (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE organiza_viaje (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE paquete_turistico (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(120) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ============================================
-- Insertar datos en tablas base
-- ============================================
INSERT INTO usuarios VALUES 
  (1, 'Darwin', 'Quintana', 'darwin.quintana', '25f9e794323b453885f5181f1b624d0b'),
  (2, 'Allison', 'Quintana', 'allison.quintana', 'e807f1fcf82d132f9bb018ca6738a19f');

INSERT INTO paises VALUES 
  (1, 'Venezuela'),
  (2, 'Paraguay'),
  (3, 'Chile'),
  (4, 'Panama'),
  (5, 'Argentina');

INSERT INTO motivo_viaje VALUES 
  (1, '1. Visita a familiares o amigos'),
  (2, '2. Vacaciones (recreación, ocio, sol y playa)'),
  (3, '3. Compras'),
  (4, '4. Turismo Cultural'),
  (5, '5. Asistencia a eventos artísticos y/o deportivos destino'),
  (6, '6. Estudio y/o formación'),
  (7, '7. Tratamiento de salud y belleza'),
  (8, '8. Religioso'),
  (9, '9. Asistencia a Congresos, Seminarios, convenciones'),
  (10, '10. Trabajo remunerado en destino'),
  (11, '11. Trabajo o negocios (no remunerado en destino)'),
  (12, '12. Participación en eventos artísticos y/o deportivos'),
  (13, '13. Tránsito'),
  (14, '14. Otro.');

INSERT INTO tipo_gasto VALUES 
  (1, 'a. Paquete turístico'),
  (2, 'b. Transporte Internacional');

INSERT INTO acompanantes VALUES 
  (1, 'Solo'),
  (2, 'Amigos'),
  (3, 'Familia'),
  (4, 'Compañeros de trabajo y/o estudio'),
  (5, 'Otro');

INSERT INTO alojamiento VALUES 
  (1, 'Vivienda Propia'),
  (2, 'Hotel / Apartahotel'),
  (3, 'Vivienda familiar o de amigos'),
  (4, 'Vivienda en alquiler'),
  (5, 'Otro tipo de vivienda');

INSERT INTO aranceles VALUES 
  (1, '¿Hubo gasto?'),
  (2, 'Pagado por usted'),
  (3, 'Terceros que NO hacen parte del grupo'),
  (4, 'Terceros que SI hacen parte del grupo'),
  (5, '¿Para cuantas personas?');

INSERT INTO organiza_viaje VALUES 
  (1, '1. Paquete turístico organizado por una agencia de viajes en Colombia'),
  (2, '2. Paquete turístico organizado por una agencia de viajes en el país de visita'),
  (3, '3. Paquete turístico organizado por terceros que no sean agencias de viajes'),
  (4, '4. Viaje organizado por cuenta propia'),
  (5, '5. Otro');

INSERT INTO paquete_turistico VALUES 
  (1, '1. Alojamiento'),
  (2, '2. Transporte internacional'),
  (3, '3. Alimentos y bebidas (No incluidos en el alojamiento)'),
  (4, '4. Servicios culturales y de entretenimiento.'),
  (5, '5. Servicios deportivos y recreacionales (Ej.: Actividades de aventura, ecológicas, otros)'),
  (6, '6. Tours en destino (con servicio de guía)'),
  (7, '7. Transporte aéreo interno en el destino'),
  (8, '8. Otro transporte interno'),
  (9, '9. Otro servicio.');

-- ============================================
-- Crear tablas dependientes
-- ============================================
CREATE TABLE encuestas (
  id INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  id_pais_reside_permanen INT NOT NULL,
  id_motivo_viaje INT NOT NULL,
  id_tipo_gasto INT NOT NULL,
  nacionalidad VARCHAR(120) NOT NULL,
  sexo VARCHAR(45) NOT NULL,
  edad INT NOT NULL,
  otro_acompanante VARCHAR(120) DEFAULT NULL,
  nro_acompanantes INT DEFAULT NULL,
  otro_motivo_viaje VARCHAR(120) DEFAULT NULL,
  otro_organiza_viaje VARCHAR(120) DEFAULT NULL,
  otro_paquete_turistico VARCHAR(120) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY id_idx (id_usuario),
  KEY encuesta_fk_pais1_idx (id_pais_reside_permanen),
  KEY motivo_viaje_fk_idx (id_motivo_viaje),
  KEY tipo_gasto_fk_idx (id_tipo_gasto),
  CONSTRAINT encuesta_fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id),
  CONSTRAINT encuesta_fk_pais1 FOREIGN KEY (id_pais_reside_permanen) REFERENCES paises (id),
  CONSTRAINT motivo_viaje_fk FOREIGN KEY (id_motivo_viaje) REFERENCES motivo_viaje (id),
  CONSTRAINT tipo_gasto_fk FOREIGN KEY (id_tipo_gasto) REFERENCES tipo_gasto (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE acompanante_encuesta (
  id INT NOT NULL AUTO_INCREMENT,
  id_acompanante INT NOT NULL,
  id_encuesta INT NOT NULL,
  PRIMARY KEY (id),
  KEY acompanante_fk_acompanante_encuesta_idx (id_acompanante),
  KEY encuesta_fk_acompanante_encuesta_idx (id_encuesta),
  CONSTRAINT acompanante_fk_acompanante_encuesta FOREIGN KEY (id_acompanante) REFERENCES acompanantes (id),
  CONSTRAINT encuesta_fk_acompanante_encuesta FOREIGN KEY (id_encuesta) REFERENCES encuestas (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE alojamiento_encuesta_pais (
  id INT NOT NULL AUTO_INCREMENT,
  id_pais_visita INT NOT NULL,
  id_alojamiento INT NOT NULL,
  id_encuesta INT NOT NULL,
  nro_noches INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  KEY pais_fk_idx (id_pais_visita),
  KEY alojamiento_fk_idx (id_alojamiento),
  KEY encuesta_fk_idx (id_encuesta),
  CONSTRAINT alojamiento_fk FOREIGN KEY (id_alojamiento) REFERENCES alojamiento (id),
  CONSTRAINT encuesta_fk FOREIGN KEY (id_encuesta) REFERENCES encuestas (id),
  CONSTRAINT pais_fk FOREIGN KEY (id_pais_visita) REFERENCES paises (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE aranceles_encuesta (
  id INT NOT NULL AUTO_INCREMENT,
  id_aranceles INT NOT NULL,
  id_encuesta INT NOT NULL,
  hubo_gastos VARCHAR(45) NOT NULL,
  valor DECIMAL(10,0) NOT NULL,
  tipo_moneda VARCHAR(45) NOT NULL,
  nro_personas INT NOT NULL,
  PRIMARY KEY (id),
  KEY aranceles_fk_aran_encu_idx (id_aranceles),
  KEY encuesta_fk_aran_encue_idx (id_encuesta),
  CONSTRAINT aranceles_fk_aran_encu FOREIGN KEY (id_aranceles) REFERENCES aranceles (id),
  CONSTRAINT encuesta_fk_aran_encue FOREIGN KEY (id_encuesta) REFERENCES encuestas (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE organiza_viaje_encuesta (
  id INT NOT NULL AUTO_INCREMENT,
  id_organiza_viaje INT NOT NULL,
  id_encuesta INT NOT NULL,
  PRIMARY KEY (id),
  KEY organiza_viaje_fk_org_via_encue_idx (id_organiza_viaje),
  KEY encuesta_fk_org_viaj_encu_idx (id_encuesta),
  CONSTRAINT organiza_viaje_fk_org_via_encue FOREIGN KEY (id_organiza_viaje) REFERENCES organiza_viaje (id),
  CONSTRAINT encuesta_fk_org_viaj_encu FOREIGN KEY (id_encuesta) REFERENCES encuestas (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE paquete_turistico_encuesta (
  id INT NOT NULL AUTO_INCREMENT,
  id_paquete_turistico INT NOT NULL,
  id_encuesta INT NOT NULL,
  PRIMARY KEY (id),
  KEY paque_turis_fk_paq_tur_encu_idx (id_paquete_turistico),
  KEY paque_turis_fk_encuesta_idx (id_encuesta),
  CONSTRAINT paque_turis_fk_paq_tur_encu FOREIGN KEY (id_paquete_turistico) REFERENCES paquete_turistico (id),
  CONSTRAINT paque_turis_fk_encuesta FOREIGN KEY (id_encuesta) REFERENCES encuestas (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ============================================
-- Reactivar comprobación de claves foráneas
-- ============================================
SET FOREIGN_KEY_CHECKS = 1;
