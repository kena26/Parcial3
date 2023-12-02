package com.Parcial3.entity;

import org.springframework.web.bind.annotation.*;
import com.Parcial3.repository.ResenaRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Otros campos y métodos de la entidad

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

@RestController
@RequestMapping("/api/resenas")
class ResenaController {

    private final ResenaRepository resenaRepository;

    public ResenaController(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    @PostMapping("/guardar")
    public String guardarResena(@RequestBody Resena resena) {
        resenaRepository.save(resena);
        return "Resena guardada con éxito";
    }

    @GetMapping("/obtener/{id}")
    public Resena obtenerResena(@PathVariable Long id) {
        return resenaRepository.findById(id).orElse(null);
    }

    @GetMapping("/obtener-todas")
    public List<Resena> obtenerTodasResenas() {
        return resenaRepository.findAll();
    }

    @PutMapping("/actualizar/{id}")
    public String actualizarResena(@PathVariable Long id, @RequestBody Resena resena) {
        if (resenaRepository.existsById(id)) {
            resena.setId(id);
            resenaRepository.save(resena);
            return "Resena actualizada con éxito";
        } else {
            return "No se encontró la resena con ID: " + id;
        }
    }
}


