package com.construction.api;


import com.construction.logic.ParticipantLogic;
import com.construction.request.CreateParticipantRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api/v1/participants")
@Slf4j
public class Api {

    @Autowired
    private ParticipantLogic participantLogic;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public void createParticipant(@RequestBody CreateParticipantRequest r) {
        participantLogic.createParticipants(r);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getClient(@PathVariable("id") String id) {
        return "";
    }

}
