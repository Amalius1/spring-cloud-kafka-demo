package pl.aml.bk.demo.kafkasync.cloud.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventProducer {

    private final BusProperties busProperties;
    private final ApplicationEventPublisher applicationEventPublisher;

    public void sendEvent() {
        log.info("Sending event");
        applicationEventPublisher.publishEvent(new CustomEvent(busProperties.getId(), busProperties.getId(), "**"));
    }
}
