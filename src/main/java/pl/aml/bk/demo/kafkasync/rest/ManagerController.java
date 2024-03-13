package pl.aml.bk.demo.kafkasync.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.aml.bk.demo.kafkasync.service.MangeService;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final MangeService service;

    @PostMapping("/upload")
    public ResponseEntity<?> upload() {
        service.upload();
        return ResponseEntity.accepted().build();
    }

}
