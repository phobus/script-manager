package io.home.service;

import io.home.model.converter.ArgumentsConverter;
import io.home.model.converter.EnvironmentConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ConverterService {

    private final ArgumentsConverter argumentsConverter;
    private final EnvironmentConverter environmentConverter;

    public ConverterService() {
        argumentsConverter = new ArgumentsConverter();
        environmentConverter = new EnvironmentConverter();
    }

    public String argumentsToString(List<String> argumentList) {
        return argumentsConverter.convertToDatabaseColumn(argumentList);
    }

    public List<String> argumentsToList(String argumentText) {
        return argumentsConverter.convertToEntityAttribute(argumentText);
    }

    public String environmentToString(Map<String, String> environmentMap) {
        return environmentConverter.convertToDatabaseColumn(environmentMap);
    }

    public Map<String, String> environmentToMap(String environmentText) {
        return environmentConverter.convertToEntityAttribute(environmentText);
    }
}
