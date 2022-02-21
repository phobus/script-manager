package io.home.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Profile {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String file;
    private String workingPath;
    private List<String> arguments = new ArrayList<>();
    private Map<String, String> environment = new HashMap<>();

    public Profile() {
    }

    public Profile(Long id, String file, String workingPath, List<String> arguments, Map<String, String> environment) {
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getWorkingPath() {
        return workingPath;
    }

    public void setWorkingPath(String workingPath) {
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
