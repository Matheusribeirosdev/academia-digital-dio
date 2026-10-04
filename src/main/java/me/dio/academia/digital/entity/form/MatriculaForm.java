package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotNull;

public class MatriculaForm {

    @NotNull
    private Long alunoId;

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
}
