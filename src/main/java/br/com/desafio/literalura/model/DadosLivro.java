package br.com.desafio.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String title,
                         @JsonAlias("languages") List<Language> languages,
                         @JsonAlias("download_count") Integer downloadCount,
                         @JsonAlias("authors") List<DadosAutor> authors) {}
