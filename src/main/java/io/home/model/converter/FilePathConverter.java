package io.home.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.File;

@Converter
public class FilePathConverter implements AttributeConverter<File, String> {
    @Override
    public String convertToDatabaseColumn(File file) {
        return file.getAbsolutePath();
    }

    @Override
    public File convertToEntityAttribute(String path) {
        return new File(path);
    }
}
