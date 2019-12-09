package net.treXis.tipsy.security.repository;

import net.treXis.tipsy.security.model.FundRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FundRequestsRepository {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private FundRequestsJpaRepository fundRequestsJpaRepository;

    public FundRequests create(FundRequests fundRequests){
        return fundRequestsJpaRepository.saveAndFlush(fundRequests);
    }

    public FundRequests update(FundRequests fundRequests){
        return fundRequestsJpaRepository.saveAndFlush(fundRequests);
    }

    public FundRequests delete(FundRequests fundRequests){
        return fundRequestsJpaRepository.saveAndFlush(fundRequests);
    }

    public Optional<FundRequests> find(Integer from_user_account){
        return fundRequestsJpaRepository.findById(from_user_account);
    }

}
