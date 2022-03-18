package com.dio_class.devweek.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class FaixaEtaria {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private Long id;
  private Integer Faixa_i;
  private Integer Faixa_n;
  private String Descricao;

  public FaixaEtaria(Integer faixaI, Integer faixaN, String descricao) {
    Faixa_i = faixaI;
    Faixa_n = faixaN;
    Descricao = descricao;
  }

  public FaixaEtaria() {}

  public Long getId() {
    return id;
  }

  public Integer getFaixa_i() {
    return Faixa_i;
  }

  public void setFaixa_i(Integer faixa_i) {
    Faixa_i = faixa_i;
  }

  public Integer getFaixa_n() {
    return Faixa_n;
  }

  public void setFaixa_n(Integer faixa_n) {
    Faixa_n = faixa_n;
  }

  public String getDescricao() {
    return Descricao;
  }

  public void setDescricao(String descricao) {
    this.Descricao = descricao;
  }

}
