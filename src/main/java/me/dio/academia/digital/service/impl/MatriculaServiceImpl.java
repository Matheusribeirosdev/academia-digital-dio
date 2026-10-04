package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MatriculaServiceImpl {

    private final MatriculaRepository repository;
    private final AlunoRepository alunoRepository;

    public MatriculaServiceImpl(MatriculaRepository repository,
                                AlunoRepository alunoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
    }

    public Matricula create(MatriculaForm form) {
        Aluno aluno = alunoRepository.findById(form.getAlunoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        return repository.save(matricula);
    }

    public List<Matricula> getAll(String bairro) {
        if (bairro == null || bairro.trim().isEmpty()) {
            return repository.findAll();
        }
        return repository.findByAlunoBairroIgnoreCase(bairro);
    }

    public Matricula get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada"));
    }

    public void delete(Long id) {
        Matricula matricula = get(id);
        repository.delete(matricula);
    }
}
