package ifpb.edu.br.dac.carlos.projetosts.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import ifpb.edu.br.dac.carlos.projetosts.business.service.AuthenticationService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.ConverterService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.SystemUserService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.TokenService;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.LoginDTO;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.TokenDTO;
import ifpb.edu.br.dac.carlos.projetosts.presentation.dto.UserDTO;

@RestController
@RequestMapping("/api")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;
    @Autowired
    private ConverterService converterService;
    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO dto) {
        try {
            String token = service.login(dto.getUsername(), dto.getPassword());
            SystemUser entity = systemUserService.findByUsername(dto.getUsername());
            UserDTO systemUserDTO = converterService.userToDTO(entity);
            
            TokenDTO tokenDTO = new TokenDTO(token, systemUserDTO);
            
            return new ResponseEntity(tokenDTO, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PostMapping("/isTokenValid")
    public ResponseEntity isTokenValid(@RequestBody TokenDTO dto) {
        try {
            boolean isTokenValid = tokenService.isValid(dto.getToken());
            
            return new ResponseEntity(isTokenValid, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
