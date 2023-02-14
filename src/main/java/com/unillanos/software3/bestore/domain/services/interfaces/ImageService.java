package com.unillanos.software3.bestore.domain.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String uploadFile(String e,MultipartFile file);

    boolean deleteFile(String path);
}