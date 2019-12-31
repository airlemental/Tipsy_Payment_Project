package net.treXis.tipsy.viewer.repositories;

import net.treXis.tipsy.viewer.model.FundRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundRequestRepository extends JpaRepository<FundRequests, Long> {
}

//Inject the repository into the correct controller
