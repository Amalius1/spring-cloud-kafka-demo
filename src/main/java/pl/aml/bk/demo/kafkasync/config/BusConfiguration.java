package pl.aml.bk.demo.kafkasync.config;

import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;
import pl.aml.bk.demo.kafkasync.cloud.events.CustomEvent;

@Configuration
@RemoteApplicationEventScan(basePackageClasses = CustomEvent.class)
public class BusConfiguration {
}
