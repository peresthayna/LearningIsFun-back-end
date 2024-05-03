package br.edu.fema.LearningIsFun.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fema.LearningIsFun.usuario.Usuario;
import br.edu.fema.LearningIsFun.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> getAllUsuariosOrderByDataCadastro() {
        return usuarioRepository.findAllByOrderByDataCadastroDesc();
    }

    public List<Usuario> getAllUsuariosOrderByNivel() {
    	List<Usuario> usuarios = usuarioRepository.findAllByOrderByNivelDesc();
        for(int i = 0; i < usuarios.size(); i++) {
        	if(i == 0) {
        		usuarios.get(i).setTrofeu("assets/main/trofeu ouro.png");
        	} else if(i == 1) {
        		usuarios.get(i).setTrofeu("assets/main/trofeu prata.png");
        	} else if(i == 2) {
        		usuarios.get(i).setTrofeu("assets/main/trofeu bronze.png");
        	} else {
        		usuarios.get(i).setTrofeu("");
        	}
        }
        usuarios.forEach(usuario -> usuarioRepository.save(usuario));
    	return usuarios;
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
        }
        throw new IllegalArgumentException("Usuario não encontrado");
    }
}
