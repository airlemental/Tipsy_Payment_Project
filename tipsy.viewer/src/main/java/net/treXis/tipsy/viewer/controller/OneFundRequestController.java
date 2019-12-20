package net.treXis.tipsy.viewer.controller;

import net.treXis.tipsy.viewer.model.OneFundRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OneFundRequestController {

    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/fund_requests/{id}")
    @ResponseBody
    public OneFundRequest findById(@PathVariable long id) {
        return new OneFundRequest();  // What do I need to do to handle this incoming data?
    }

}
