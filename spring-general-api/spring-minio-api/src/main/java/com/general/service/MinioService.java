package com.general.service;


import com.general.dto.FileDto;

import java.io.InputStream;
import java.util.List;

public interface MinioService {

    public List<FileDto> getListObjects();

    public InputStream getObjects(String fileName);

    public FileDto uploadFile(FileDto dto);

}
