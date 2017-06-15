package ar.edu.undav.subterror.domain;

import ar.edu.undav.subterror.domain.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by leo on 6/11/17.
 */

@Repository
public interface EventTypeRepository extends JpaRepository<EventType,Long>{

    public EventType findByDescription(String Description);

}
