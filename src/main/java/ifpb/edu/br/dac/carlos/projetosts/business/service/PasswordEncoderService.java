package ifpb.edu.br.dac.carlos.projetosts.business.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;

public interface PasswordEncoderService extends PasswordEncoder {
    
    void encryptPassword(SystemUser systemUser);

}