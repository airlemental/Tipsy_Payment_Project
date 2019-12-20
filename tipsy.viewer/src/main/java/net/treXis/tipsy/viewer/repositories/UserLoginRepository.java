package net.treXis.tipsy.viewer.repositories;


import net.treXis.tipsy.viewer.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
}
