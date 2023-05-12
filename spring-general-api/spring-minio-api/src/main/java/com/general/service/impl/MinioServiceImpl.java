package com.general.service.impl;

import com.general.dto.FileDto;
import com.general.service.MinioService;
import io.minio.*;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MinioServiceImpl implements MinioService {

    @Value("${minio.bucket.name}")
    private String bucketName;
    private final MinioClient client;

    public MinioServiceImpl(MinioClient client) {
        this.client = client;
    }

    @Override
    public List<FileDto> getListObjects() {
        var list = new ArrayList<FileDto>();
        try {
            var result = client.listObjects(ListObjectsArgs.builder().bucket(bucketName).recursive(true).build());

            for (Result<Item> item : result) {
                var dto = FileDto.builder().filename(item.get().objectName()).size(item.get().size()).url(getPreSignedUrl(item.get().objectName())).build();
                list.add(dto);
            }

            log.info("list objects {}", list.size());
        } catch (Exception e) {
            log.error("Happened error when get list objects from minio: ", e);
            return null;
        }
        return list;
    }

    @Override
    public InputStream getObjects(String fileName) {
        InputStream stream;

        try {
            stream = client.getObject(GetObjectArgs.builder().bucket(bucketName).object(fileName).build());
            log.info("get objects: {}", fileName);

        } catch (Exception e) {
            log.error("Happened error when get list objects from minio: ", e);
            return null;
        }

        return stream;
    }

    @Override
    public FileDto uploadFile(FileDto dto) {
        try {
            client.putObject(PutObjectArgs.builder().
                    bucket(bucketName).
                    object(dto.getFile().getOriginalFilename()).
                    stream(dto.getFile().getInputStream(), dto.getFile().getSize(), -1).build());

            log.info("upload objects");
        } catch (Exception e) {
            log.error("Happened error when upload file: ", e);
            return null;
        }

        var fileDto = FileDto.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .size(dto.getFile().getSize())
                .url(getPreSignedUrl(dto.getFile().getOriginalFilename()))
                .filename(dto.getFile().getOriginalFilename())
                .build();

        return fileDto;
    }

    private String getPreSignedUrl(String filename) {
        return "http://localhost:8085/file/".concat(filename);
    }
}
