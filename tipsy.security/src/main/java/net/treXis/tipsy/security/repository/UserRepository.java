package net.treXis.tipsy.security.repository;

import net.treXis.tipsy.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Make sure the JpaRepository <> area is the entity, type of primary key, or everything starts to fail

}
