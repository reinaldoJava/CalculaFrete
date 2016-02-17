package br.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Mapa implements Comparable<Mapa>{
	@Id
	@GeneratedValue
	@Column(name = "rota_id")
	private Long id;
	@Column(name = "rota_nome")
	private String nome;
	@Column(name = "rota_origem")
	private String origem;
	@Column(name = "rota_destino")
	private String destino;
	@Column(name = "rota_distancia")
	private Double distanciaKM;
	@Transient
	private Mapa outraRota;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Double getDistanciaKM() {
		return distanciaKM;
	}
	public void setDistanciaKM(Double distanciaKM) {
		this.distanciaKM = distanciaKM;
	}
	public Mapa(String nome, String origem, String destino, Double distanciaKM) {
		this.nome = nome;
		this.origem = origem;
		this.destino = destino;
		this.distanciaKM = distanciaKM;
	}
	@Override
	public int compareTo(Mapa rota) {
		// TODO Auto-generated method stub
		 return Double.compare(distanciaKM, rota.distanciaKM);
	}	
}
