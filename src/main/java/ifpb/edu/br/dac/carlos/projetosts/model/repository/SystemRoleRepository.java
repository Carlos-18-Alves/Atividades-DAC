package ifpb.edu.br.dac.carlos.projetosts.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.carlos.projetosts.model.entitity.SystemRole;

@Repository
public interface SystemRoleRepository extends JpaRepository<SystemRole, Integer>{

    Optional<SystemRole> findByName(String name);
}
