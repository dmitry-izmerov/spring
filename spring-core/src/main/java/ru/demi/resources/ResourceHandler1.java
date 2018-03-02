package ru.demi.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ResourceHandler1 extends ResourceHandler {

    public ResourceHandler1(@Value("${resource1Path}") Resource resource) {
        super(resource);
    }
}
