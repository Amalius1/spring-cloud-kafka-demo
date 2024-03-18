package pl.aml.bk.demo.kafkasync.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.aml.bk.demo.kafkasync.service.ConfigDataHolder;
import pl.aml.bk.demo.kafkasync.service.ManageService;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManageService service;
    private final ConfigDataHolder configDataHolder;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadConfig(@RequestParam("file") MultipartFile file) {
        service.upload(file);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadConfig() {
        String download = service.download();
        return ResponseEntity.ok(download);
    }

    @GetMapping("/current")
    public ResponseEntity<String> getCurrentConfig() {
        return ResponseEntity.ok(configDataHolder.getConfigData());
    }

}
