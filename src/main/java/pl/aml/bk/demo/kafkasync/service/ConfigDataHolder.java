package pl.aml.bk.demo.kafkasync.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Getter
@Component
@Slf4j
public class ConfigDataHolder {

    private String configData;

    public void setConfigData(String configData) {
        log.info("Setting config data");
        this.configData = configData;
    }

}
