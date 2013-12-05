package org.tgc.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by rajeevguru on 20/11/13.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Stop")
public class Stop {

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    private String name;
    private Double latitude;
    private Double longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stop() {
    }

    public Stop(Stop stop) {
        this.id = stop.id;
        this.name = stop.name;
        this.latitude = stop.latitude;
        this.longitude = stop.longitude;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stop)) return false;

        Stop stop = (Stop) o;

        if (id != null ? !id.equals(stop.id) : stop.id != null) return false;
        if (latitude != null ? !latitude.equals(stop.latitude) : stop.latitude != null) return false;
        if (longitude != null ? !longitude.equals(stop.longitude) : stop.longitude != null) return false;
        if (name != null ? !name.equals(stop.name) : stop.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}
