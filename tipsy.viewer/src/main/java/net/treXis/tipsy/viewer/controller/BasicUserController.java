package net.treXis.tipsy.viewer.controller;

import net.treXis.tipsy.viewer.model.BasicUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class BasicUserController {

    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/fund_requests/{id}")
    @ResponseBody
    public BasicUser findById(@PathVariable long id) {
        return new BasicUser();  // What do I need to do to handle this incoming data?
    }

}
