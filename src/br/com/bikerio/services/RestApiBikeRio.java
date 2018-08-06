package br.com.bikerio.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RestApiBikeRio {
	public static void main(String[] args) {
//		Client client = Client.create();
//		WebResource webResource = client.resource("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/estacoesBikeRio");
//		String json = webResource.get(String.class);
		
		Client client = Client.create();
		WebResource webResource =
			client.resource("https://nominatim.openstreetmap.org/search?street=Avenida%20Bartolomeu%20Mitre&city=Rio%20de%20Janeiro&format=json&polygon=1&addressdetails=1");
		String json = webResource.get(String.class);
		
		System.out.println(json);
//		try {
//			JSONObject obj = new JSONObject(json);
//			JSONArray jsonArrayCol = obj.getJSONArray("COLUMNS");
//			JSONArray jsonArrayData = obj.getJSONArray("DATA");
//			System.out.println(jsonArrayCol);
//			System.out.println(jsonArrayData);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		RestApiBikeRio rest = new RestApiBikeRio();
//		rest.search("endereco");
	}
	
	public void search(String endereco, String cidade) {
		String cidadeFormat = cidade.trim().replace(" ", "%20");
		String endFormat = cidade.trim().replace(" ", "%20");
		System.out.println(cidadeFormat + " " + endFormat);
		Client client = Client.create();
		WebResource webResource = client.resource("https://nominatim.openstreetmap.org/search?street="+ endFormat+ "&city="+ cidadeFormat + "&format=json&polygon=1&addressdetails=1");
		String json = webResource.get(String.class);
		
		
	}
}
