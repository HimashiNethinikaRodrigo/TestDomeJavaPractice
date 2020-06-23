package main.edu.testdome.java.alertservice;

import java.util.Date;
import java.util.UUID;

public class AlertService {
    private final AlertDAO storage;

    public AlertService(AlertDAO storage){

        this.storage = storage;
    }
    public UUID raiseAlert() {
        return this.storage.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return this.storage.getAlert(id);
    }
}
