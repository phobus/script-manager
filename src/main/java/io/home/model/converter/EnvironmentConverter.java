package io.home.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Converter
public class EnvironmentConverter implements AttributeConverter<Map<String, String>, String> {

    public static final String SEPARATOR = ";";
    public static final String EQUALS = "=";

    public static final int NAME_INDEX = 0;
    public static final int VALUE_INDEX = 1;

    @Override
    public String convertToDatabaseColumn(Map<String, String> environmentMap) {
        if (environmentMap == null) {
            return null;
        }
        return environmentMap.entrySet().stream()
                .map(e -> e.getKey() + EQUALS + e.getValue())
                .collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String environment) {
        if (environment == null || environment.trim().isEmpty()) {
            return new HashMap<>();
        }
        return Arrays.stream(environment.split(SEPARATOR))
                .map(entry -> entry.split(EQUALS))
                .collect(Collectors.toMap(o -> o[NAME_INDEX], o -> o.length == 1 ? "" : o[VALUE_INDEX]));
    }
}
