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

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/event")
public class EventController
{
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Event> getAllEvent(){
        return this.eventService.getAllEvent();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable Long id){
        return this.eventService.getEvent(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<Event> createEvent(HttpServletRequest request,
                                         @RequestParam(value = "sense") String sense,
                                         @RequestParam(value = "eventType") String eventType,
                                         @RequestParam(value = "station") String station){
        StationService stationService = new StationService();
        EventTypeService eventTypeService = new EventTypeService();
        EventService eventService = new EventService();

        Event event = new Event();
        Station _station;
        EventType _eventType;

        // Entras al servicio y buscas los respectivos objetos

        _station = stationService.getStation(request.getParameter(station));
        _eventType = eventTypeService.getEventType(request.getParameter(eventType));


        // Creamos el objeto de tipo evento

        event.setEventType(_eventType);
        event.setSense(sense);
        event.setStation(_station);

        // Guardamos y persistimos en la bd
        eventService.addEvent(event);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}