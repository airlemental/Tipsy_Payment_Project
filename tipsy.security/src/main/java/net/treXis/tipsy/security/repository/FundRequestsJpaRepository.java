package net.treXis.tipsy.security.repository;

import net.treXis.tipsy.security.model.FundRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundRequestsJpaRepository extends JpaRepository<FundRequests, Integer> {
}
