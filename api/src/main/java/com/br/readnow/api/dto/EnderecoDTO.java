package com.br.readnow.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    private String email;
    private String nomeDestino;
    private String logradouro;
    private String bairro;
    private String numeroCasa;
    private String cep;
    private String complemento;
    private String cidade;
    private String estado;
    private String pais;
}