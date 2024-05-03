package br.edu.fema.LearningIsFun.usuario.repository;

import br.edu.fema.LearningIsFun.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByOrderByDataCadastroDesc();
    List<Usuario> findAllByOrderByNivelDesc();
}
