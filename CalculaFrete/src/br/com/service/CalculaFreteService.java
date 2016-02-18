package br.com.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.model.DadosFrete;
import br.com.model.DadosRetorno;
import br.com.model.MapaBO;

@Path("/calcular")
public class CalculaFreteService {
	
		@POST
		@Produces("application/json")
		public Response calcular(@FormParam("x") Double x, @FormParam("y") Double y) throws JSONException {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Total: ", (x+y));
			jsonObject.put("This Sum Value", x); 
			jsonObject.put("and", y);
			String result =  ""+ jsonObject;
			return Response.status(200).entity(result).build();
		}
		
		public static List<MapaBO> mapas = new ArrayList<MapaBO>();
		static {
			
			MapaBO mapa1 = new MapaBO("São Paulo 1","A","B",10.0);
			MapaBO mapa2 = new MapaBO("São Paulo 2","B","D",15.0);
			MapaBO mapa3 = new MapaBO("São Paulo 3","A","C",20.0);
			MapaBO mapa4 = new MapaBO("São Paulo 4","C","D",30.0);
			MapaBO mapa5 = new MapaBO("São Paulo 5","B","E",50.0);
			MapaBO mapa6 = new MapaBO("São Paulo 6","D","E",30.0);
			mapas.add(mapa1);
			mapas.add(mapa2);
			mapas.add(mapa3);
			mapas.add(mapa4);
			mapas.add(mapa5);
			mapas.add(mapa6);
		}
		public static void main(String[] args) {
			new CalculaFreteService();
			DadosFrete frete = new DadosFrete();
			frete.setAutomonia(10.0);
			frete.setOrigem("A");
			frete.setDestino("D");
			frete.setValorCombustivel(new BigDecimal(2.5));
			DadosRetorno retorno  = calcularMenorValorFrete(frete);
			System.out.println(retorno.getValorFrete());
			System.out.println(retorno.getRotas());
		}
		public static DadosRetorno calcularMenorValorFrete(DadosFrete dadosFrete){
			DadosRetorno retorno = new DadosRetorno();
			List<MapaBO>tempMapas = new ArrayList<MapaBO>();
			List<MapaBO>tempMapasOrigem = new ArrayList<MapaBO>();
			List<MapaBO>tempMapasDestino = new ArrayList<MapaBO>();
			List<String> rotas = new ArrayList<String>();
			List<Double> valoresFrete = new ArrayList<Double>();
			rotas.add(dadosFrete.getOrigem());
			Double distancia = new Double(dadosFrete.getAutomonia());
			Double valor = 0.0;
			
			
			for(MapaBO mapa: mapas){
				if(dadosFrete.getOrigem().equalsIgnoreCase(mapa.getOrigem())){
					if(dadosFrete.getDestino().equalsIgnoreCase(mapa.getDestino())){
						rotas.add(mapa.getDestino());
						break;
					}else {
						tempMapasOrigem.add(mapa);
						mapa.getDestino();
					}
				}
				if(dadosFrete.getDestino().equalsIgnoreCase(mapa.getDestino())){
					tempMapasDestino.add(mapa);
				}
			}
			int index1 = tempMapasOrigem.size();
			int index2 = tempMapasDestino.size();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			for(MapaBO mapa: mapas){
				if(dadosFrete.getOrigem().equalsIgnoreCase(mapa.getOrigem())){
					if(dadosFrete.getDestino().equalsIgnoreCase(mapa.getDestino())){
						rotas.add(mapa.getDestino());
						break;
					}else{
						tempMapas.add(mapa);
					}
				}
			}
			if(rotas.size() <= 1){
				boolean temp = false;
				for(MapaBO mapaTemp : tempMapas){
					if(temp)
						break;
					for(MapaBO mapa : mapas){
						if(mapaTemp.getDestino().equalsIgnoreCase(mapa.getOrigem())){
							if(dadosFrete.getDestino().equalsIgnoreCase(mapa.getDestino())){
								rotas.add(mapa.getOrigem());
								rotas.add(mapa.getDestino());
								distancia += mapa.getDistanciaKM();
								temp = true;
								break;
							}
							else{
								rotas.add(mapaTemp.getDestino());
								distancia += mapaTemp.getDistanciaKM();
							}
						}
					}
				}
			}
			retorno.setRotas(rotas);
			BigDecimal frete = new BigDecimal(distancia); 
			BigDecimal frete2 = frete.divide(new BigDecimal(dadosFrete.getAutomonia()), 2, RoundingMode.CEILING );
			retorno.setValorFrete(frete2.multiply(dadosFrete.getValorCombustivel()));
			return retorno;
		}

}
