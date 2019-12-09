package net.treXis.tipsy.security.repository;

import com.sun.xml.bind.v2.model.core.ID;
import net.treXis.tipsy.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, ID> {

    List<Users> findByUser_accountIn(List<Users> users);

    List<Users> findByUsernameIn(List<Users> users);

    Optional<Users> findById(ID user_account);

    Optional<Users> findUsersByUsernameIs(String username);

    Users create(Users user);

    Users findById(int user_account);
}
