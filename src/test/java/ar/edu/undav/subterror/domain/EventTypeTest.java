package ar.edu.undav.subterror.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sol on 7/9/17.
 */
public class EventTypeTest {

    @Test
    public void creationEventType(){
        String description = "Linea suspendida";

        EventType eventType = new EventType(description);

        Assert.assertEquals(description,eventType.getDescription());
    }
}
