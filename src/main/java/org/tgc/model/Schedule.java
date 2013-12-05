package org.tgc.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * Created by rajeevguru on 30/11/13.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "schedule")
public class Schedule {

    private int hour;

    private Minutes minutes;



    public int getHour() {

        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Minutes getMinutes() {
        return minutes;
    }

    public void setMinutes(Minutes minutes) {
        this.minutes = minutes;
    }

    public Schedule() {

    }
}
