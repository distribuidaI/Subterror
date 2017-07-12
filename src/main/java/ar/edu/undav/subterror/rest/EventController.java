package ar.edu.undav.subterror.rest;

/**
 * Created by leo on 6/11/17.
 */
import ar.edu.undav.subterror.domain.Event;
import ar.edu.undav.subterror.domain.EventType;
import ar.edu.undav.subterror.domain.Station;
import ar.edu.undav.subterror.service.EventService;
import ar.edu.undav.subterror.service.EventTypeService;
import ar.edu.undav.subterror.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/event")
public class EventController
{
    private EventService eventService;
    private StationService stationService;
    private EventTypeService eventTypeService;

    @Autowired
    public EventController(EventService eventService,StationService stationService, EventTypeService eventTypeService){
        this.eventService = eventService;
        this.stationService = stationService;
        this.eventTypeService = eventTypeService;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Event> getAllEvent(){
        return this.eventService.getAllEvent();
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ResponseEntity<Collection<Event>> getEventByEventType(@RequestParam(value = "eventType") String eventType) {
        Collection<Event> events = eventService.getEventByEventTypeByDescription(eventType);

        return ResponseEntity.ok(events);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Event> createEvent(@RequestParam(value = "sense") String sense,
                                             @RequestParam(value = "eventType") String eventType,
                                             @RequestParam(value = "station") String station){

        Station _station;
        EventType _eventType;

        // Entras al servicio y buscas los respectivos objetos
        _eventType = eventTypeService.getEventType(eventType);
        _station = stationService.getStation(station);

        // Creamos el objeto de tipo evento

        Event event = new Event(sense,_eventType,_station);

        // Guardamos y persistimos en la bd
        eventService.addEvent(event);

        return new ResponseEntity<Event>(event,HttpStatus.CREATED);
    }
}