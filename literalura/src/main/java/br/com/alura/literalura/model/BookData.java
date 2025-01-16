package br.com.alura.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(int id, String title, List<String> languages, int download_count, List<AuthorData> authors) {

}
