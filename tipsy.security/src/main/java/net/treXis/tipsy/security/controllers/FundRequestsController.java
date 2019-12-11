package net.treXis.tipsy.security.controllers;

import net.treXis.tipsy.security.model.FundRequests;
import net.treXis.tipsy.security.repository.FundRequestsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fundrequests")
public class FundRequestsController {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(FundRequestsController.class);

    @Value("{ninja.site.test}")
    private String testString;

    private final FundRequestsRepository fundRequestsRepository;
    @Autowired
    public FundRequestsController(FundRequestsRepository fundRequestsRepository){
        this.fundRequestsRepository = fundRequestsRepository;
    }

    @GetMapping
    public List<FundRequests> list(){
        LOG.debug("Connection Error: " + testString);
        return fundRequestsRepository.findAll();
    }

    //Get
    @GetMapping
    @RequestMapping("{id}")
    public FundRequests get(@PathVariable Long id){
        return fundRequestsRepository.getOne(id);
    }

    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FundRequests create(@RequestBody final FundRequests fundRequest){
        return fundRequestsRepository.saveAndFlush(fundRequest);
    }

    //Delete
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        fundRequestsRepository.deleteById(id);

    }

    //Update
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)  //would need .PATCH to do partial replacements of data fields
    public FundRequests update(@PathVariable Long id, @RequestBody FundRequests fundRequest){
        FundRequests existingFunds = fundRequestsRepository.getOne(id);
        BeanUtils.copyProperties(fundRequest, existingFunds, "from_user_account");
        return fundRequestsRepository.saveAndFlush(fundRequest);
    }
}
