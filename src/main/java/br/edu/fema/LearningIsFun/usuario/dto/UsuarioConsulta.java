package br.edu.fema.LearningIsFun.usuario.dto;

import br.edu.fema.LearningIsFun.usuario.Usuario;
import lombok.Getter;

import java.util.List;

@Getter
public class UsuarioConsulta {
    private Long id;
    private String nome;
    private String avatar;
    private int pontuacao;
    private int nivel;
    private String trofeu;

    public UsuarioConsulta(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.avatar = usuario.getAvatar();
        this.pontuacao = usuario.getPontuacao();
        this.nivel = usuario.getNivel();
        this.nivel = usuario.getNivel();
        this.trofeu = usuario.getTrofeu();
    }

    public static List<UsuarioConsulta> converterParaDTO(List<Usuario> usuarios) {
        return usuarios.stream().map(usuario -> new UsuarioConsulta(usuario)).toList();
    }
}
