package ifpb.edu.br.dac.carlos.projetosts.business.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;

public interface SystemUserService extends UserDetailsService {
    
    public SystemUser save(SystemUser systemUser);
    
    public SystemUser update(SystemUser systemUser);
    
    public void delete(Integer id);
    
    public SystemUser findById(Integer id);

    public SystemUser findByUsername(String username);
    
    public Iterable<SystemUser> findAll();
    
    public List<SystemUser> find(SystemUser filter);
}
