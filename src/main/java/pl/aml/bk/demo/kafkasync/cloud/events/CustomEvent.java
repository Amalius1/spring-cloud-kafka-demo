package pl.aml.bk.demo.kafkasync.cloud.events;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

import java.io.Serializable;


public class CustomEvent extends RemoteApplicationEvent implements Serializable {

    // For serialization
    public CustomEvent() {
    }

    public CustomEvent(Object source, String originService, String destinationService) {
        // originService is the unique context ID of the sender
        // destinationService is the service to send the event to, use "*" for all services
        super(source, originService, () -> destinationService);
    }

}
