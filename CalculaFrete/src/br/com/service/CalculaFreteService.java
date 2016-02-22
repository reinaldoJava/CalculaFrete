package br.com.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bo.MapaBO;
import br.com.bo.RotaBO;
import br.com.controller.FreteController;
import br.com.dao.ClienteDAO;
import br.com.model.DadosFrete;
import br.com.model.Mapa;

@Path("/calcular")
public class CalculaFreteService {

	@Autowired
	private ClienteDAO dao;

	@POST
	@Produces("application/json")
	public Response calcular(@FormParam("nome") String nome,
			@FormParam("origem") String origem,
			@FormParam("destino") String destino,
			@FormParam("autonomia") Double autonomia,
			@FormParam("valorCombustivel") Double valorCombustivel)
			throws JSONException {
		
//		DadosFrete frete = new DadosFrete();
//		frete.setOrigem(origem);
//		frete.setDestino(destino);
//		frete.setAutomonia(autonomia);
//		frete.setValorCombustivel(new BigDecimal(valorCombustivel));
//		
//		FreteController controller = new FreteController();
//		List<Mapa> mapas = dao.list();
//		List<MapaBO> listMapaBO = montarObjetoBO(mapas);
//		MapaBO mapaOrigem = controller.getMapa(listMapaBO, frete.getOrigem());
//		MapaBO mapaDestino = controller.getMapa(listMapaBO, frete.getDestino());
//		controller.calcularMenorDistancia(mapaOrigem);
//		List<MapaBO> rotaMenorValor = controller.mostarMenorRota(mapaDestino);
//		String rotaString = "";
//		for (MapaBO mapaBO : rotaMenorValor) {
//			rotaString.concat(" "+mapaBO.getNome()+" ");
//		}
//		BigDecimal valorFrete = controller.calcularMenorValorFrete(mapaDestino, frete);
//		
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("Custo Total: ", valorFrete.toString());
//		jsonObject.put("Rota:", rotaString);
//		String result = "" + jsonObject;
		Mapa mapa = new Mapa("São Paulo 1","A","B",10.0);
		dao.adicionar(mapa);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Banco está funcionando ", "");

		String result = "" + jsonObject;
		return Response.status(200).entity(result).build();
	}

	private List<MapaBO> montarObjetoBO(List<Mapa> mapas) {

		List<MapaBO> listaMapaBO = new ArrayList<MapaBO>();
		for (Mapa mapa : mapas) {
			String origemAtual = mapa.getOrigem();
			MapaBO mapaBO = new MapaBO(origemAtual);
			MapaBO tempBO = new MapaBO(mapa.getDestino());
			RotaBO rota = new RotaBO(tempBO, mapa.getDistanciaKM());
			List<RotaBO> listRotas = new ArrayList<RotaBO>();
			listRotas.add(rota);
			mapaBO.setRotas(listRotas);
			//Comaparando a partir do segundo item para adição das rotas
			for (int i = 1; i < mapas.size(); i++) {
				if (origemAtual.equalsIgnoreCase(mapas.get(i).getOrigem())) {
					MapaBO tempBO2 = new MapaBO(mapas.get(i).getDestino());
					RotaBO rota2 = new RotaBO(tempBO2, mapas.get(i).getDistanciaKM());
					listRotas.add(rota2);
				}
			}
			mapaBO.setRotas(listRotas);
			listaMapaBO.add(mapaBO);
		}

		return listaMapaBO;
	}

}
