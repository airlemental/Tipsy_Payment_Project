package net.treXis.tipsy.security.repository;

import net.treXis.tipsy.security.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private UserJpaRepository userJpaRepository;

    public Users create(Users user){
        return userJpaRepository.saveAndFlush(user);
    }

    public Users update(Users user){
        return userJpaRepository.saveAndFlush(user);
    }

    public Users delete(Users user){
        return userJpaRepository.saveAndFlush(user);
    }

}
