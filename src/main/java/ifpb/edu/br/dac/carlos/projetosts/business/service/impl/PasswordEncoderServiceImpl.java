package ifpb.edu.br.dac.carlos.projetosts.business.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.business.service.PasswordEncoderService;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;

@Service
public class PasswordEncoderServiceImpl extends BCryptPasswordEncoder implements PasswordEncoderService {

    @Override
    public void encryptPassword(SystemUser systemUser) {
        if(systemUser.getPassword() != null) {
            String encryptedPassword = encode(systemUser.getPassword());
            systemUser.setPassword(encryptedPassword);
        }
    }
   
}
