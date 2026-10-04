package me.dio.academia.digital.entity.form;

import me.dio.academia.digital.entity.AvaliacaoFisica;

import javax.validation.constraints.NotNull;

public class AvaliacaoFisicaForm {

    @NotNull
    private Long alunoId;

    private double peso;
    private double altura;

    public AvaliacaoFisica converter() {
        AvaliacaoFisica avaliacao = new AvaliacaoFisica();
        avaliacao.setPeso(peso);
        avaliacao.setAltura(altura);
        return avaliacao;
    }

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
}
