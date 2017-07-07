package ar.edu.undav.subterror.service;

import ar.edu.undav.subterror.domain.EventType;
import ar.edu.undav.subterror.domain.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by leo on 6/15/17.
 */

@Service
public class EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    public List<EventType> getAllEventType(){
        return eventTypeRepository.findAll();
    }

    public EventType getEventType(String description){
        return eventTypeRepository.findByDescription(description);
    }

    public EventType getEventTypeById(Long id){
        return eventTypeRepository.findOne(id);
    }

    public void addEventType(EventType eventType){
        eventTypeRepository.save(eventType);
    }

    public void updateEventType(Long id,EventType eventType){
        eventTypeRepository.save(eventType);
    }

    public void deleteEventType(Long id){
        eventTypeRepository.delete(id);
    }

}
