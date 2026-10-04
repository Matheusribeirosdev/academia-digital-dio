package me.dio.academia.digital.entity.form;

import me.dio.academia.digital.entity.Aluno;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AlunoForm {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String bairro;

    @NotNull
    private LocalDate dataDeNascimento;

    public Aluno converter() {
        return new Aluno(nome, cpf, bairro, dataDeNascimento);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public LocalDate getDataDeNascimento() { return dataDeNascimento; }
    public void setDataDeNascimento(LocalDate dataDeNascimento) { this.dataDeNascimento = dataDeNascimento; }
}
