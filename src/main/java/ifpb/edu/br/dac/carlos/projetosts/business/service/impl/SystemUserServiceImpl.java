package ifpb.edu.br.dac.carlos.projetosts.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.carlos.projetosts.business.service.PasswordEncoderService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.SystemRoleService;
import ifpb.edu.br.dac.carlos.projetosts.business.service.SystemUserService;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemRole;
import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemUser;
import ifpb.edu.br.dac.carlos.projetosts.model.repository.SystemUserRepository;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserRepository repository;
    @Autowired
    private SystemRoleService systemRoleService;
    @Autowired
    private PasswordEncoderService passwordEncoderService;
    
    @Override
    public SystemUser save(SystemUser systemUser) {
        if(systemUser.getId() != null) {
            throw new IllegalStateException("User already exists. You can try to update it.");
        }
        passwordEncoderService.encryptPassword(systemUser);
        
        List<SystemRole> roles = new ArrayList<>();
        roles.add(systemRoleService.findDefault());
        systemUser.setRoles(roles);
        
        return repository.save(systemUser);
    }
    
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public SystemUser update(SystemUser systemUser) {
        return repository.save(systemUser);
    }
    
    @Override
    public SystemUser findById(Integer id) {
        if(id == null)
            throw new IllegalStateException("Id cannot be null");
        
        return repository.findById(id).get();
    }
    
    @Override
    public List<SystemUser> findAll() {
        return repository.findAll();
    }
    
    @Override
    public List<SystemUser> find(SystemUser filter) {
        Example example = Example.of(filter,
                ExampleMatcher.matching()
                    .withIgnoreCase()
                    .withStringMatcher(StringMatcher.CONTAINING));
        
        return repository.findAll(example);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser user = findByUsername(username);
        
        if(user == null) {
            throw new UsernameNotFoundException(String.format("Could not find any user with username %s", username));
        }
        
        return user;
    }

    @Override
    public SystemUser findByUsername(String username) {
        List<SystemUser> user = repository.findByUsername(username);
        
        return user.get(0);
        
    }
}
