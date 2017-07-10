package ar.edu.undav.subterror.domain;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sol on 7/9/17.
 */
public class StationTest {

    @Test
    public void createStation(){
        String line = "Linea E";
        String station = "San Jose";

        Station estacion = new Station(line,station);

        Assert.assertEquals(line,estacion.getLine());
        Assert.assertEquals(station,estacion.getStation());
    }

}
