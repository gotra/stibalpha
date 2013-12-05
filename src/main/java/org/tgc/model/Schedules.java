package org.tgc.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rajeevguru on 30/11/13.
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "schedules")
public class Schedules {

    @XmlElement(name="schedule")
    private List<Schedule> times;

    public List<Schedule> getTimes() {
        return times;
    }

    public void setTimes(List<Schedule> times) {
        this.times = times;
    }
}
