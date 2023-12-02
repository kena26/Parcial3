package com.Parcial3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Metodo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/guardarComentario")
    public String guardarComentario(
            @RequestParam("nombre_Usuario") String nombre_Usuario,
            @RequestParam("id_Cuenta") int id_Cuenta,
            @RequestParam("coment") String coment) {

        String sql = "INSERT INTO Comentarios (nombre_usuario, id_cuenta, coment) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, nombre_Usuario, id_Cuenta, coment);

        return "Comentario guardado con exito";
    }
}
