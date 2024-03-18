package pl.aml.bk.demo.kafkasync.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.aml.bk.demo.kafkasync.cloud.events.EventProducer;
import pl.aml.bk.demo.kafkasync.cloud.s3.S3FileManager;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManageService {

    @Value("${minio.bucket}")
    private String bucket;
    @Value("${app.config-file-name}")
    private String configFileName;

    private final EventProducer eventProducer;

    private final S3FileManager s3FileManager;

    @SneakyThrows
    public void upload(MultipartFile file) {
        log.info("Uploading file");
        s3FileManager.uploadFile(bucket, configFileName, file);
        eventProducer.sendEvent();
        log.info("File uploaded");
    }

    public String download() {
        log.info("Downloading file");
        String s = s3FileManager.downloadFile(bucket, configFileName);
        log.info("File downloaded");
        return s;
    }

}
