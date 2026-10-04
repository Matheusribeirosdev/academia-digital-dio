package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl {

    private final AvaliacaoFisicaRepository repository;
    private final AlunoRepository alunoRepository;

    public AvaliacaoFisicaServiceImpl(AvaliacaoFisicaRepository repository,
                                      AlunoRepository alunoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
    }

    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        Aluno aluno = alunoRepository.findById(form.getAlunoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

        AvaliacaoFisica avaliacao = form.converter();
        avaliacao.setAluno(aluno);
        return repository.save(avaliacao);
    }

    public AvaliacaoFisica get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada"));
    }

    public List<AvaliacaoFisica> getAll() {
        return repository.findAll();
    }

    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm form) {
        AvaliacaoFisica avaliacao = get(id);
        avaliacao.setPeso(form.getPeso());
        avaliacao.setAltura(form.getAltura());
        return repository.save(avaliacao);
    }

    public void delete(Long id) {
        AvaliacaoFisica avaliacao = get(id);
        repository.delete(avaliacao);
    }
}
