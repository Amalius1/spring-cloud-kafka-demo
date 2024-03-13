package pl.aml.bk.demo.kafkasync.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.aml.bk.demo.kafkasync.cloud.events.EventProducer;

@Service
@RequiredArgsConstructor
@Slf4j
public class MangeService {

    private final EventProducer eventProducer;

    public void upload() {
        log.info("Uploading file");
        eventProducer.sendEvent();
        log.info("File uploaded");
    }


}
