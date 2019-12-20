package net.treXis.tipsy.security.repository;

import net.treXis.tipsy.security.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
}
