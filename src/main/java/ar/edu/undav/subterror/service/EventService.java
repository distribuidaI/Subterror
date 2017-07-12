package ar.edu.undav.subterror.service;

import ar.edu.undav.subterror.domain.Event;
import ar.edu.undav.subterror.domain.EventRepository;
import ar.edu.undav.subterror.domain.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by leo on 6/15/17.
 */

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvent(){
        return eventRepository.findAll();
    }

    public Event getEvent(Long id){
        return eventRepository.findOne(id);
    }

    public Collection<Event> getEventByEventTypeByDescription(String description){
        return eventRepository.findByEventType_Description(description);
    }

    public void addEvent(Event event){
        eventRepository.save(event);
    }

    public void updateEvent(Long id, Event event){
        eventRepository.save(event);
    }

    public void deleteEvent(Long id){
        eventRepository.delete(id);
    }

}
