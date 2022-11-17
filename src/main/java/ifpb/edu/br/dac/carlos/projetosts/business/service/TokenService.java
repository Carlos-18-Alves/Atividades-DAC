package ifpb.edu.br.dac.carlos.projetosts.business.service;

import javax.servlet.http.HttpServletRequest;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

public interface TokenService {
    
    String generate(SystemUser user);
    
    Claims getClaims(String token) throws ExpiredJwtException;
    
    boolean isValid(String token);
    
    String getUsername(String token);
    
    Integer getUserId(String token);
    
    String get(HttpServletRequest request);
    
}