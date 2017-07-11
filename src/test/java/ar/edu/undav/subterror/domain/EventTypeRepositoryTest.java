package ar.edu.undav.subterror.domain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sol on 7/9/17.
 */
public class EventTypeRepositoryTest {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Test
    public void testSave(){
        String description = "Demora por inconvenientes";
        EventType eventType = new EventType(description);

        eventTypeRepository.save(eventType);
    }

    @Test
    public void testFindAll(){
        List<EventType> eventList = eventTypeRepository.findAll();

        for (EventType e : eventList) {
            System.out.println(e);
        }
    }
}

