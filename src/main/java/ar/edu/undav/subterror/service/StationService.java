package ar.edu.undav.subterror.service;

import ar.edu.undav.subterror.domain.Station;
import ar.edu.undav.subterror.domain.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by leo on 6/15/17.
 */

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAllStation(){
        return stationRepository.findAll();
    }

    public Station getStation(String station){
        return stationRepository.findByStation(station);
    }

    public Station getStationById(Long id){
        return stationRepository.findOne(id);
    }

    public void addStation(Station station){
        stationRepository.save(station);
    }

    public void updateStation(Long id,Station station){
        stationRepository.save(station);
    }

    public void deleteStation(Long id){
        stationRepository.delete(id);
    }
}
