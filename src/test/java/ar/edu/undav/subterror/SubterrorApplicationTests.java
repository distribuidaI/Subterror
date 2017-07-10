package ar.edu.undav.subterror;

import ar.edu.undav.subterror.domain.Event;
import ar.edu.undav.subterror.domain.EventType;
import ar.edu.undav.subterror.domain.Station;
import ar.edu.undav.subterror.domain.EventRepository;
import ar.edu.undav.subterror.domain.EventTypeRepository;
import ar.edu.undav.subterror.domain.StationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import javax.persistence.EntityManager;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubterrorApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private EventTypeRepository eventTypeRepository;

	@Autowired
	private StationRepository stationRepository;

	@Autowired
	private EventRepository eventRepository;

	@Test
	public void contextLoads() {}

	@Test
	@Transactional
	public void testEventType(){
		EventType eventType = new EventType("Demora");
		entityManager.persist(eventType);
		entityManager.flush();

		EventType found = eventTypeRepository.findByDescription(eventType.getDescription());

		assertThat(found.getDescription(),equalTo(eventType.getDescription()));
	}

	@Test
	@Transactional
	public void testStation(){
		Station estacion = new Station("Linea D", "Congreso");
		entityManager.persist(estacion);
		entityManager.flush();

		Station found = stationRepository.findByStation(estacion.getStation());

		assertThat(found.getLine(),equalTo(estacion.getLine()));
	}

	@Test
	@Transactional
	public void testEvent(){
		String sense = "Sentido a sarasa";
		EventType eventType = new EventType("Demora");
		entityManager.persist(eventType);
		entityManager.flush();

		Station estacion = new Station("Linea D", "Congreso");
		entityManager.persist(estacion);
		entityManager.flush();

		Event event = new Event(sense,eventType,estacion);

		entityManager.persist(event);
		entityManager.flush();

		Event found = eventRepository.findByStation(event.getStation());

		assertThat(found.getStation(),equalTo(estacion.getStation()));
	}

}
