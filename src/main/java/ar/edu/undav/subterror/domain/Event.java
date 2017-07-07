package ar.edu.undav.subterror.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by leo on 6/11/17.
 */

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date date = new Date();

    private String sense;

    @ManyToOne
    @JoinColumn(name = "event_type")
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name="station")
    private Station station;

    public Event() {}

    public Event(String sense, EventType eventType, Station station) {
        this.sense = sense;
        this.eventType = eventType;
        this.station = station;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSense() {
        return sense;
    }

    public void setSense(String sense) {
        this.sense = sense;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
