package com.general.controller;

import com.general.dto.FileDto;
import com.general.service.MinioService;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static org.springframework.web.servlet.HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class MiniController {

    private final MinioService service;

    public MiniController(MinioService service) {
        this.service = service;
    }


    @GetMapping(value = "/minios/all")
    public ResponseEntity<List<FileDto>> getAll() {
        return new ResponseEntity<>(service.getListObjects(), HttpStatus.OK);
    }

    @GetMapping(value = "/minios")
    public ResponseEntity<Object> getObject(@RequestParam("filename") String fileName) throws IOException {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(IOUtils.toByteArray(service.getObjects(fileName)));
    }

    @PostMapping(value = "/minios/upload")
    public ResponseEntity<FileDto> upload(@ModelAttribute FileDto fileDto) {
        return new ResponseEntity<>(service.uploadFile(fileDto), HttpStatus.CREATED);
    }


    @GetMapping(value = "/minios/download")
    public ResponseEntity<Object> objectDownload(HttpServletRequest request) throws IOException {
        String pattern = (String) request.getAttribute(BEST_MATCHING_PATTERN_ATTRIBUTE);
        String fileName = new AntPathMatcher().extractPathWithinPattern(pattern, request.getServletPath());

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(IOUtils.toByteArray(service.getObjects(fileName)));
    }


}
