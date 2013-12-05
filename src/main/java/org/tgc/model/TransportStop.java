package org.tgc.model;

/**
 * Created by rajeevguru on 05/12/13.
 */
public class TransportStop {

    private Transport transport;

    private Stop stop;

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public TransportStop() {

    }

    public TransportStop(Stop stop, Transport transport) {

        this.stop = stop;
        this.transport = transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportStop)) return false;

        TransportStop that = (TransportStop) o;

        if (stop != null ? !stop.equals(that.stop) : that.stop != null) return false;
        if (transport != null ? !transport.equals(that.transport) : that.transport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transport != null ? transport.hashCode() : 0;
        result = 31 * result + (stop != null ? stop.hashCode() : 0);
        return result;
    }
}
