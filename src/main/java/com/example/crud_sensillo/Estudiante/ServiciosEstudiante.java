package com.example.crud_sensillo.Estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosEstudiante {

    @Autowired
    private RepositoryEstudiantes repositoryEstudiantes;

    public List<Estudiante> obtenerTodos() {
        return repositoryEstudiantes.findAll();
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        return repositoryEstudiantes.findById(id);
    }

    public Estudiante guardar(Estudiante estudiante) {
        return repositoryEstudiantes.save(estudiante);
    }

    public void eliminar(Long id) {
        repositoryEstudiantes.deleteById(id);
    }

    public Estudiante actualizar(Long id, Estudiante estudianteActualizado) {
        return repositoryEstudiantes.findById(id).map(estudiante -> {
            estudiante.setNombre(estudianteActualizado.getNombre());
            estudiante.setApellido(estudianteActualizado.getApellido());
            estudiante.setMatricula(estudianteActualizado.getMatricula());
            estudiante.setEdad(estudianteActualizado.getEdad());
            return repositoryEstudiantes.save(estudiante);
        }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }
}
