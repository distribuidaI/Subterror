package ar.edu.undav.subterror.domain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sol on 7/9/17.
 */
public class StationRepositoryTest {
    @Autowired
    private StationRepository stationRepository;

    @Test
    public void testSave(){
        String line = "Linea C";
        String station = "Plaza constitucion";

        Station estacion = new Station(line,station);

        stationRepository.save(estacion);
    }

    @Test
    public void testFindAll(){
        List<Station> stationList = stationRepository.findAll();

        for (Station s : stationList) {
            System.out.println(s);
        }
    }
}
