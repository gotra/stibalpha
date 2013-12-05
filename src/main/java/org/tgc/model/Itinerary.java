package org.tgc.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajeevguru on 21/11/13.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stops")
public class Itinerary {

    @XmlElement(name = "stop", type = Stop.class)
    private List<Stop> stops = new ArrayList<Stop>();


    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public Itinerary(Itinerary itinerary) {
        this.stops = new ArrayList<Stop>(itinerary.stops);
    }

    public Itinerary() {
    }
}
