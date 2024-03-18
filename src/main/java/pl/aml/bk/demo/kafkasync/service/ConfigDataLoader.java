package pl.aml.bk.demo.kafkasync.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConfigDataLoader {

    private final ConfigDataHolder configDataHolder;

    @EventListener(ApplicationReadyEvent.class)
    public void loadConfigData() {
        log.info("Loading config data at startup");
        String configData = configDataHolder.getConfigData();
        log.info("Config data loaded: {}", configData);
    }

}
