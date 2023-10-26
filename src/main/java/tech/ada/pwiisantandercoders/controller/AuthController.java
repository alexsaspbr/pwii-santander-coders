package tech.ada.pwiisantandercoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.pwiisantandercoders.dto.AutenticacaoDTO;
import tech.ada.pwiisantandercoders.dto.LoginResponseDTO;
import tech.ada.pwiisantandercoders.dto.RegistroDTO;
import tech.ada.pwiisantandercoders.model.Usuario;
import tech.ada.pwiisantandercoders.service.TokenService;
import tech.ada.pwiisantandercoders.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AutenticacaoDTO autenticacaoDTO) {

        var usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(autenticacaoDTO.login(), autenticacaoDTO.password());

        var authentication = this.authenticationManager.authenticate(usernamePasswordAuthentication);

        String token = this.tokenService.gerarToken((Usuario)authentication.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody RegistroDTO registroDTO) {

        if (this.usuarioService.buscarUsuarioPorLogin(registroDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String passwordEncrypted = new BCryptPasswordEncoder().encode(registroDTO.password());
        Usuario usuario = new Usuario(registroDTO.login(), passwordEncrypted, registroDTO.role());

        this.usuarioService.registrar(usuario);

        return ResponseEntity.ok().build();

    }


}
