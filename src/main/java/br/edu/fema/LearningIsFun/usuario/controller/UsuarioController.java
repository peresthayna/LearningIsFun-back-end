package br.edu.fema.LearningIsFun.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fema.LearningIsFun.usuario.Usuario;
import br.edu.fema.LearningIsFun.usuario.dto.UsuarioCadastro;
import br.edu.fema.LearningIsFun.usuario.dto.UsuarioConsulta;
import br.edu.fema.LearningIsFun.usuario.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping()
    public List<UsuarioConsulta> getUsuarios() {
        return UsuarioConsulta.converterParaDTO(usuarioService.getAllUsuarios());
    }
    
    @GetMapping("/ordenados-data")
    public List<UsuarioConsulta> getUsuariosOrdenadosPorDataCadastro() {
        return UsuarioConsulta.converterParaDTO((usuarioService.getAllUsuariosOrderByDataCadastro()));
    }

    @GetMapping("/ordenados-nivel")
    public List<UsuarioConsulta> getUsuariosOrdenadosPorNivel() {
        return UsuarioConsulta.converterParaDTO((usuarioService.getAllUsuariosOrderByNivel()));
    }

    @GetMapping("/buscar/{id}")
    public UsuarioConsulta getUsuarioPorId(@PathVariable(name = "id") Long id) {
        return new UsuarioConsulta(usuarioService.getUsuarioById(id));
    }

    @PostMapping()
    public void cadastrarUsuario(@RequestBody() UsuarioCadastro usuario) {
        usuarioService.saveUsuario(new Usuario(usuario));
    }

    @PutMapping("/atualizar/{id}")
    public void atualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody UsuarioConsulta usuario) {
        usuarioService.updateUsuario(id, new Usuario(usuario));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable(name = "id") Long id) {
        usuarioService.deleteUsuario(id);
    }
}
