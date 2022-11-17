package ifpb.edu.br.dac.carlos.projetosts.business.service;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;

public interface AuthenticationService {

    public String login(String username, String password);
    
    public SystemUser getLoggedUser();
}
