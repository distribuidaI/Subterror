package ar.edu.undav.subterror.repository;

import ar.edu.undav.subterror.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by leo on 6/11/17.
 */

@Repository
public interface EventRepository extends JpaRepository<Event,Long>{

}
