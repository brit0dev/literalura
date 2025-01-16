package br.com.alura.literalura.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(Class<T> someClass, String json) {
        try {
           return mapper.readValue(json, someClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
