package io.home.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;

@Converter
public class ArgumentsConverter implements AttributeConverter<List<String>, String> {

    public static final String SEPARATOR = " ";

    @Override
    public String convertToDatabaseColumn(List<String> argumentList) {
        if (argumentList == null) {
            return null;
        }
        return String.join(SEPARATOR, argumentList);
    }

    @Override
    public List<String> convertToEntityAttribute(String argumentText) {
        if (argumentText == null || argumentText.trim().isEmpty()) {
            return null;
        }
        return Arrays.asList(argumentText.split(SEPARATOR));
    }
}
