package br.com.model;
import java.math.BigDecimal;

public class DadosFrete {
	
	private String nome;
	private String origem;
	private String destino;
	private Double automonia;
	private BigDecimal valorCombustivel;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getAutomonia() {
		return automonia;
	}
	public void setAutomonia(Double automonia) {
		this.automonia = automonia;
	}
	public BigDecimal getValorCombustivel() {
		return valorCombustivel;
	}
	public void setValorCombustivel(BigDecimal valorCombustivel) {
		this.valorCombustivel = valorCombustivel;
	}	
}