package ar.edu.undav.subterror.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by sol on 7/9/17.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(value = "classpath:application.test.properties")
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Autowired
    private StationRepository stationRepository;

    @Test
    public void testSave(){
        EventType eventType = eventTypeRepository.findOne(new Long(9));
        Station station = stationRepository.findOne(new Long(9));
        String sense = "Sentido a Retiro";

        Event event = new Event(sense,eventType,station);

        eventRepository.save(event);
    }

    @Test
    public void testFindAll(){
        List<Event> eventList = eventRepository.findAll();

        for (Event e : eventList) {
            System.out.println(e);
        }
    }
}
