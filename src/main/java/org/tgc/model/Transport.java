package org.tgc.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by rajeevguru on 28/11/13.
 */
public class Transport {


    private String visibleId;

    private int direction;

    private String destination;

    // the count of the transport, eg: nth transport having same visible ID arriving at the same stop in the same direction
    private int count;

    public Transport() {
    }

    public Transport(String visibleId, int direction, String destination, int count) {
        this.visibleId = visibleId;
        this.direction = direction;
        this.destination = destination;
        this.count = count;
    }

    public String getVisibleId() {
        return visibleId;
    }

    public void setVisibleId(String visibleId) {
        this.visibleId = visibleId;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;

        Transport transport = (Transport) o;

        if (count != transport.count) return false;
        if (direction != transport.direction) return false;
        if (destination != null ? !destination.equals(transport.destination) : transport.destination != null)
            return false;
        if (visibleId != null ? !visibleId.equals(transport.visibleId) : transport.visibleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = visibleId != null ? visibleId.hashCode() : 0;
        result = 31 * result + direction;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }
}
