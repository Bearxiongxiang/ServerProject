package com.beacon.imchat.controller;

import com.beacon.imchat.domain.Event;
import com.beacon.imchat.mapper.EventMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/event")
public class EventController {
    private Logger logger = Logger.getLogger(EventController.class);
    private Event event = null;
    List<Event> events = null;

    private EventMapper eventDao;

    @Autowired
    public EventController(EventMapper eventDao){
        this.eventDao = eventDao;
    }

    @RequestMapping(value = "/getEvent", method = RequestMethod.GET)
    public Map getEvent(@RequestParam(name = "eventName", required = false) String eventName) {
        Map<String, Object> map = new HashMap();
        map.put("status", "SUCCESS");
        try {
            logger.info("query one record");
            event = eventDao.getEventByName(eventName);
        } catch (Exception e) {
            map.put("status", "Error");
        }
        map.put("data", event);
        return map;
    }

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public Map getEvents(@RequestParam(name = "eventName", required = false) String eventName) {
        Map<String, Object> map = new HashMap();
        map.put("status", "SUCCESS");
        try {
            logger.info("query one record");
            events = eventDao.getEvents();
        } catch (Exception e) {
            map.put("status", "Error");
        }
        if (events != null) {
            map.put("data", events);
        }
        return map;
    }

    @RequestMapping(value = "/test", method = RequestMethod.OPTIONS)
    public Map test(@RequestParam(name = "eventName", required = false) String eventName) {
        Map map = new HashMap();
        map.put("testKey","testValue");
        return map;
    }




}
