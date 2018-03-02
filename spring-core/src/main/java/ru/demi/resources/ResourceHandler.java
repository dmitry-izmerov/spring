package ru.demi.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;

public class ResourceHandler {
    private Resource resource;

    public ResourceHandler(Resource resource) {
        this.resource = resource;
    }

    public boolean isAvailable() {
        return resource.exists() && resource.isReadable();
    }

    public String getContent() throws IOException {
        return new BufferedReader(new InputStreamReader(resource.getInputStream()))
            .lines()
            .collect(Collectors.joining(System.lineSeparator()));
    }
}
