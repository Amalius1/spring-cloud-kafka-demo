package pl.aml.bk.demo.kafkasync.cloud.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class S3FileManager {

    private final AmazonS3 amazonS3;


    public void uploadFile(String bucketName, String key, MultipartFile file) {
        log.info("Uploading file to S3");
        try {
            amazonS3.putObject(bucketName, key, file.getInputStream(), new ObjectMetadata());
        } catch (IOException e) {
            log.error("Error while uploading file to S3", e);
            throw new RuntimeException("Error while uploading file to S3", e);
        }
    }

    public String downloadFile(String bucketName, String key) {
        log.info("Downloading file from S3");
        try (S3Object object = amazonS3.getObject(new GetObjectRequest(bucketName, key))) {
            byte[] bytes = object.getObjectContent().readAllBytes();
            String s = new String(bytes);
            log.info("File content: {}", s);
            return s;
        } catch (IOException e) {
            log.error("Error while downloading file from S3", e);
            throw new RuntimeException("Error while downloading file from S3", e);
        }

    }

}
