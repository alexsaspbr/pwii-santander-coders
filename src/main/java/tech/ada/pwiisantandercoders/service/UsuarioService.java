package tech.ada.pwiisantandercoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tech.ada.pwiisantandercoders.model.Usuario;
import tech.ada.pwiisantandercoders.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetails buscarUsuarioPorLogin(String login) {
        return this.usuarioRepository.findByLogin(login);
    }

    public Usuario registrar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }
}
