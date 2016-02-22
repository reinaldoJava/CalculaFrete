package br.com.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bo.MapaBO;
import br.com.bo.RotaBO;
import br.com.dao.ClienteDAO;
import br.com.model.DadosFrete;

public class FreteController {

	@Autowired
	private ClienteDAO dao;
	
	public static void main(String[] args) {
		List<MapaBO> mapas = new ArrayList<MapaBO>();
		MapaBO mapaBOA = new MapaBO("A");
		MapaBO mapaBOB = new MapaBO("B");
		MapaBO mapaBOC = new MapaBO("C");
		MapaBO mapaBOD = new MapaBO("D");
		MapaBO mapaBOE = new MapaBO("E");
		
//		mapaBOA.setRotas(new RotaBO[]{new RotaBO(mapaBOB, 10.0),new RotaBO(mapaBOC, 20.0)});
//		mapaBOB.setRotas(new RotaBO[]{new RotaBO(mapaBOD, 15.0),new RotaBO(mapaBOE, 50.0)});
//		mapaBOC.setRotas(new RotaBO[]{new RotaBO(mapaBOD, 30.0)});
//		mapaBOD.setRotas(new RotaBO[]{new RotaBO(mapaBOE, 30.0)});
//		mapaBOE.setRotas(new RotaBO[]{new RotaBO(mapaBOA, 15.0)});
		//calcularMenorValor(mapaBOA);
		
		
		//System.out.println("Distancia entre A e "+mapaBOD.getNome() + ": "+valorFrete);
		
		//mapas = montarRotaMenorValor(mapaBOD);
		
		for (MapaBO mapaBO : mapas) {
			System.out.print(" "+mapaBO.getNome());	
		}	
	}
	public BigDecimal calcularMenorValorFrete(MapaBO mapaBO, DadosFrete frete){
		BigDecimal valorFrete = new BigDecimal( ( mapaBO.getMenorValor()/frete.getAutomonia()));
		valorFrete.multiply(frete.getValorCombustivel());
		return valorFrete;
	}
	//Esse Metodo já calcula todas as rota Entrelaçadas com o menor valor para todas.
	public void calcularMenorDistancia(MapaBO mapaBO) {
		mapaBO.setMenorValor(0.0);
		PriorityQueue<MapaBO> MapaBOQueue = new PriorityQueue<MapaBO>();
		MapaBOQueue.add(mapaBO);

		while (!MapaBOQueue.isEmpty()) {
			MapaBO tempMapaBO = MapaBOQueue.poll();
			for (RotaBO rotaBO : tempMapaBO.getRotas()) {
				MapaBO tempMapa = rotaBO.getMapaBO();
				Double valor = rotaBO.getValor();
				Double distanceThroughU = tempMapaBO.getMenorValor() + valor;
				if (distanceThroughU < tempMapa.getMenorValor()) {
					MapaBOQueue.remove(tempMapa);
					tempMapa.setMenorValor(distanceThroughU);
					tempMapa.setMapaBOAnterior(tempMapaBO);
					MapaBOQueue.add(tempMapa);
				}
			}
		}
	}
	public MapaBO getMapa(List<MapaBO> list, String origemDestino){
		MapaBO bo = null;
		for (MapaBO mapaBO : list) {
			if(mapaBO.getNome().equalsIgnoreCase(origemDestino)){
				bo = mapaBO;
				break;
			}
		}
		return bo;
	}
	
	public List<MapaBO> mostarMenorRota(MapaBO mapaBO)
    {
        List<MapaBO> listaMapaBO = new ArrayList<MapaBO>();
        for (MapaBO mapaBOTemp = mapaBO; mapaBOTemp != null; mapaBOTemp = mapaBOTemp.getMapaBOAnterior()){
        	listaMapaBO.add(mapaBOTemp);
        }
        Collections.reverse(listaMapaBO);
        return listaMapaBO;
    }

}
