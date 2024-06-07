package br.com.desafio.literalura.service;

public interface IConversoDados {
    <T> T getData(String json, Class<T> classe);
}
