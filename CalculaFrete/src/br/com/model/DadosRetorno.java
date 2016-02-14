package br.com.model;

import java.math.BigDecimal;
import java.util.List;

public class DadosRetorno {
	
	private Long id;
	private List<String> rotas;
	private BigDecimal valorFrete;
	
	
	public BigDecimal getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<String> getRotas() {
		return rotas;
	}
	public void setRotas(List<String> rotas) {
		this.rotas = rotas;
	}
}