package ar.edu.undav.subterror.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by leo on 6/11/17.
 */

@Repository
public interface EventRepository extends JpaRepository<Event,Long>{

    public Event findByStation(Station station);

    public Event findByDate(Date date);

    public Collection<Event> findByEventType_Description(String description);
}
