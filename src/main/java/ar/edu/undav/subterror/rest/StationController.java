package ar.edu.undav.subterror.rest;

import ar.edu.undav.subterror.domain.Station;
import ar.edu.undav.subterror.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leo on 6/14/17.
 */
@RestController
@RequestMapping(value = "/station")
public class StationController {
    private StationService stationService;

    @Autowired
    public StationController(StationService stationService){
        this.stationService = stationService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Station> getAll(){
        return this.stationService.getAllStation();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Station getStation(@PathVariable Long id){
        return stationService.getStationById(id);
    }

}
