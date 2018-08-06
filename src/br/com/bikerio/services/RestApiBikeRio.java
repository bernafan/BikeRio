package br.com.bikerio.services;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;



public class RestApiBikeRio {
	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/estacoesBikeRio");
		String json = webResource.get(String.class);
		
		try {
			JSONObject obj = new JSONObject(json);
			JSONArray jsonArrayCol = obj.getJSONArray("COLUMNS");
			JSONArray jsonArrayData = obj.getJSONArray("DATA");
			System.out.println(jsonArrayCol);
			System.out.println(jsonArrayData);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestApiBikeRio rest = new RestApiBikeRio();
//		rest.search("endereco");
	}
	
	public void search(String endereco) {
//		Client client = Client.create();
//		WebResource webResource = client.resource("https://nominatim.openstreetmap.org/search");
//		webResource.path("q=Avenida+Roberto+Silveira&polygon_geojson=1&viewbox=");
//		String json = webResource.get(String.class);
		System.out.println(endereco);
		
	}
}