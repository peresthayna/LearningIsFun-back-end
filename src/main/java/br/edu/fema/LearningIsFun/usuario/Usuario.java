package br.edu.fema.LearningIsFun.usuario;

import java.time.LocalDateTime;

import br.edu.fema.LearningIsFun.usuario.dto.UsuarioCadastro;
import br.edu.fema.LearningIsFun.usuario.dto.UsuarioConsulta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "pontuacao")
    private int pontuacao;

    @Column(name = "nivel")
    private int nivel;
    
    @Column(name = "trofeu")
    private String trofeu;

    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataCadastro;

    public Usuario(UsuarioCadastro usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.avatar = usuario.getAvatar();
        this.pontuacao = 0;
        this.nivel = 0;
        this.dataCadastro = LocalDateTime.now();
        this.trofeu = "";
    }

    public Usuario(UsuarioConsulta usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.avatar = usuario.getAvatar();
        this.pontuacao = usuario.getPontuacao();
        this.nivel = usuario.getNivel();
        this.dataCadastro = LocalDateTime.now();
        this.trofeu = usuario.getTrofeu();
    }
}
