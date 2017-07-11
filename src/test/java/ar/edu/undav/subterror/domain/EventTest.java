package ar.edu.undav.subterror.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sol on 7/9/17.
 */
public class EventTest {

    @Test
    public void testCreation(){
        String sense = "Sentido a Retiro";
        EventType eventType = new EventType("Demora");

        Station estacion = new Station("Linea D", "Congreso");

        Event event = new Event(sense,eventType,estacion);

        Assert.assertEquals(sense,event.getSense());
        Assert.assertEquals(eventType,event.getEventType());
        Assert.assertEquals(estacion,event.getStation());
    }

}
