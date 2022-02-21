package io.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.File;

@Entity
public class LogFile {

    @Id
    @GeneratedValue
    private Long id;

    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
