package com.unillanos.software3.bestore.domain.services.implementation;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.unillanos.software3.bestore.domain.services.interfaces.ImageService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    private final AmazonS3 amazonS3;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Override
    public String uploadFile(String entity, MultipartFile file) {
        File mainFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream stream = new FileOutputStream(mainFile)) {
            stream.write(file.getBytes());
            String newFileName = UUID.randomUUID().toString().replace("-", "");
            //make public
            PutObjectRequest request = new PutObjectRequest(bucketName, entity + "/" + newFileName, mainFile);
            request.setCannedAcl(CannedAccessControlList.PublicRead);
            amazonS3.putObject(request);
            return amazonS3.getUrl(bucketName, entity + "/" + newFileName).toString();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean deleteFile(String path) {
        try {
            String[] parts = path.split("/");
            String fileName = parts[parts.length-2]+"/"+parts[parts.length - 1];
            amazonS3.deleteObject(bucketName, fileName);
            return true;
        }catch (Exception ex){
            LOGGER.error(ex.getMessage(), ex);
        }
        return false;
    }

}