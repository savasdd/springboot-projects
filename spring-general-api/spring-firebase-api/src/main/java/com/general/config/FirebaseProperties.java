package com.general.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

//@ConfigurationProperties(prefix = "gcp.firebase")
//@ConfigurationPropertiesScan
public class FirebaseProperties {

    private Resource service;

    public Resource getService() {
        return service;
    }

    public void setService(Resource service) {
        this.service = service;
    }

}
