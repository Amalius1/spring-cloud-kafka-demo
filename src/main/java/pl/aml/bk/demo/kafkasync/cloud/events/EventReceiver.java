package pl.aml.bk.demo.kafkasync.cloud.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.aml.bk.demo.kafkasync.service.ConfigDataHolder;
import pl.aml.bk.demo.kafkasync.service.ManageService;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventReceiver {

    private final ConfigDataHolder configDataHolder;
    private final ManageService manageService;

    @EventListener(CustomEvent.class)
    public void onApplicationEvent(CustomEvent event) {
        log.info("Received event: {}", event);
        String newConfigData = manageService.download();
        configDataHolder.setConfigData(newConfigData);
    }

}
