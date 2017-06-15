package ar.edu.undav.subterror.model;

import ar.edu.undav.subterror.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by leo on 6/11/17.
 */

@Repository
public interface StationRepository extends JpaRepository<Station,Long> {
    public Station findByStation(String station);
}
