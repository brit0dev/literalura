package br.com.alura.literalura.service;

public interface IDataConverter {
    public <T> T getData(Class<T> someClass, String json);
}
