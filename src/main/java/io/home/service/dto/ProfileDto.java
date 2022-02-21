package io.home.service.dto;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ProfileDto implements Serializable {
    private Long id;
    private File file;
    private File workingPath;
    private List<String> arguments;
    private Map<String, String> environment;

    public ProfileDto() {
    }

    public ProfileDto(Long id, File file, File workingPath, List<String> arguments, Map<String, String> environment) {
        this.id = id;
        this.file = file;
        this.workingPath = workingPath;
        this.arguments = arguments;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getWorkingPath() {
        return workingPath;
    }

    public void setWorkingPath(File workingPath) {
        this.workingPath = workingPath;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public Map<String, String> getEnvironment() {
        return environment;
    }

    public void setEnvironment(Map<String, String> environment) {
        this.environment = environment;
    }
}
