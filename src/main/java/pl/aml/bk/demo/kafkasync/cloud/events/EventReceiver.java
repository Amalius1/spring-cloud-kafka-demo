package pl.aml.bk.demo.kafkasync.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventReceiver {

    @EventListener
    public void onApplicationEvent(RefreshRemoteApplicationEvent event) {
        log.info("Received event: {}", event);
    }

}
