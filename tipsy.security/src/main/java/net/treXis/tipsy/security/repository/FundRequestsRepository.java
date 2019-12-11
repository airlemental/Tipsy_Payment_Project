package net.treXis.tipsy.security.repository;

import net.treXis.tipsy.security.model.FundRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundRequestsRepository extends JpaRepository<FundRequests, Long> {

                 // Make sure the JpaRepository <> area is the entity, type of primary key, or everything starts to fail
}
