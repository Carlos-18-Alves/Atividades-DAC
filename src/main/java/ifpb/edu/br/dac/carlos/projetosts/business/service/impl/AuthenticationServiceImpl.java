package ifpb.edu.br.dac.carlos.projetosts.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.business.service.AuthenticationService;
//import ifpb.edu.br.dac.carlos.projetosts.business.service.ConverterService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.SystemUserService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.TokenService;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
  
    @Override
    public String login(String username, String password) {
            return localLogin(username, password);
    }
    
    private String localLogin(String username, String password) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password));
        
        SystemUser user = systemUserService.findByUsername(username);
        
        return tokenService.generate(user);
    }
    
//    private String suapLogin(String username, String password) {
//        String jsonToken = suapService.login(username, password);
//        this.suapToken = converterService.jsonToToken(jsonToken);
//        
//        if(this.suapToken == null)
//            throw new IllegalArgumentException("Incorrect Email or Password");
//        
//        SystemUser user = systemUserService.findByUsername(username);
//        
//        if(user == null) {
//            String json = suapService.findUser(suapToken, username);
//            user = converterService.jsonToUser(json);
//            
//            user = systemUserService.save(user);
//        }
//        
//        return tokenService.generate(user);
//    }

    @Override
    public SystemUser getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (SystemUser) authentication.getPrincipal();
    }

}
