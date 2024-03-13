package pl.aml.bk.demo.kafkasync.cloud.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventReceiver {

    @EventListener(CustomEvent.class)
    public void onApplicationEvent(CustomEvent event) {
        log.info("Received event: {}", event);
    }

}
