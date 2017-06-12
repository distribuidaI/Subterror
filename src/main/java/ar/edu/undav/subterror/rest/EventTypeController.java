package ar.edu.undav.subterror.rest;

import ar.edu.undav.subterror.model.EventType;
import ar.edu.undav.subterror.repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leo on 6/11/17.
 */

@RestController
@RequestMapping(value = "/eventtype")
public class EventTypeController {

    private EventTypeRepository eventTypeRepository;

    @Autowired
    public EventTypeController(EventTypeRepository eventTypeRepository){
        this.eventTypeRepository = eventTypeRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<EventType> getAll(){
        return this.eventTypeRepository.findAll();
    }
}
