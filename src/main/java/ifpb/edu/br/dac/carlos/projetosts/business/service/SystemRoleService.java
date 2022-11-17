package ifpb.edu.br.dac.carlos.projetosts.business.service;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemRole;

public interface SystemRoleService {
    
    public enum AVAILABLE_ROLES {ADMIN, USER}

    void createDefaultValues();
    
    SystemRole findByName(String name);
    
    SystemRole findDefault();
}
