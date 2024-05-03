package br.edu.fema.LearningIsFun.usuario.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class UsuarioCadastro {
    private Long id;
    private String nome;
    private String avatar;
}
