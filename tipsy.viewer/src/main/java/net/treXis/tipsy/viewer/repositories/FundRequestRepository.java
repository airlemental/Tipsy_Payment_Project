package net.treXis.tipsy.viewer.repositories;

import net.treXis.tipsy.viewer.model.FundRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRequestRepository extends JpaRepository<FundRequests, Long> {
}

//Inject the repository into the correct controller
