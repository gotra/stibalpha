package org.tgc;

import org.tgc.model.Transport;
import org.tgc.model.TransportStop;

import java.util.Date;
import java.util.Map;

/**
 * Created by rajeevguru on 03/12/13.
 */
public class TransportCache {

    private TransportCache instance;

    private  TransportCache() {

    }

    private Map<TransportStop,Date> scheduleMap;

    public TransportCache getInstance() {

        if (instance == null) {
            instance = new TransportCache();
        }
        return instance;
    }

    public Date get


}
