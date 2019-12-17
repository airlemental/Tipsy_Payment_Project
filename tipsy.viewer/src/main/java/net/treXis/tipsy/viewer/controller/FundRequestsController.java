package net.treXis.tipsy.viewer.controller;

import net.treXis.tipsy.viewer.model.FundRequests;
import net.treXis.tipsy.viewer.repositories.FundRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fundrequests")
public class FundRequestsController {

    private final FundRequestRepository fundRequestRepository;
    @Autowired
    public FundRequestsController(FundRequestRepository fundRequestRepository){
        this.fundRequestRepository = fundRequestRepository;
    }

//    @GetMapping
//    public List<FundRequests> list(){
//        List<FundRequests> fundRequests = new ArrayList<>();
//        return fundRequests;
//    }

    // Replaced by Jpa Code
    @GetMapping
    public List<FundRequests> list(){
        return fundRequestRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK) // code 200, changes the original 201 code.
    public void create(@RequestBody FundRequests fundRequests){  // for processing new Fund Requests
        fundRequestRepository.save(fundRequests); // Added for Jpa repo
    }

    @GetMapping("/{id}")
    public FundRequests get(@PathVariable("id") long id) {  // will return a single fund request from an ID search
//        return new FundRequests();
        return fundRequestRepository.getOne(id);
    }

}
