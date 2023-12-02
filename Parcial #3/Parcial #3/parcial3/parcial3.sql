CREATE DATABASE IF NOT EXISTS ParcialFinal;

USE ParcialFinal;

CREATE TABLE IF NOT EXISTS Resenas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL,
    id_cuenta INT NOT NULL,
    reseña TEXT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO Resenas (nombre_usuario, id_cuenta, reseña) VALUES ('UsuarioEjemplo', 123, 'Esta es una reseña de ejemplo.');

SELECT * FROM Resenas;
