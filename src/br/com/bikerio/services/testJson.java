package br.com.bikerio.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class testJson {
	public static void main(String[] args) {
		
		Client client = Client.create();
		WebResource webResource = client.resource("https://nominatim.openstreetmap.org/search?street=Avenida%20Bartolomeu%20Mitre&city=Rio%20de%20Janeiro&format=json&polygon=1&addressdetails=1");
		String json = webResource.get(String.class);
		System.setProperty("javax.net.ssl.trustStore","NFeCacerts"); 
		
//		String jsonDaUrl = "[{\"place_id\":\"158127959\",\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https:\\/\\/osm.org\\/copyright\",\"osm_type\":\"way\",\"osm_id\":\"388808407\",\"boundingbox\":[\"-22.9751658\",\"-22.9744928\",\"-43.2261139\",\"-43.2257945\"],\"polygonpoints\":[[\"-43.2257945\",\"-22.9751658\"],[\"-43.2258513\",\"-22.9750285\"],[\"-43.2259744\",\"-22.9748021\"],[\"-43.2259967\",\"-22.9747612\"],[\"-43.2260977\",\"-22.9745753\"],[\"-43.2261139\",\"-22.9744928\"]],\"lat\":\"-22.9748021\",\"lon\":\"-43.2259744\",\"display_name\":\"Avenida Bartolomeu Mitre, Gávea, Zona Sul do Rio de Janeiro, Rio de Janeiro, Região Metropolitana do Rio de Janeiro, Rio de Janeiro, Southeast Region, 22470-060, Brazil\",\"class\":\"highway\",\"type\":\"secondary\",\"importance\":0.7,\"address\":{\"road\":\"Avenida Bartolomeu Mitre\",\"suburb\":\"Gávea\",\"city_district\":\"Zona Sul do Rio de Janeiro\",\"city\":\"Rio de Janeiro\",\"county\":\"Rio de Janeiro\",\"state_district\":\"Região Metropolitana do Rio de Janeiro\",\"state\":\"Rio de Janeiro\",\"postcode\":\"22470-060\",\"country\":\"Brazil\",\"country_code\":\"br\"}},{\"place_id\":\"151766540\",\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https:\\/\\/osm.org\\/copyright\",\"osm_type\":\"way\",\"osm_id\":\"371512814\",\"boundingbox\":[\"-22.9766209\",\"-22.9751658\",\"-43.2257945\",\"-43.2250927\"],\"polygonpoints\":[[\"-43.2250927\",\"-22.9766209\"],[\"-43.2251322\",\"-22.9764369\"],[\"-43.2252152\",\"-22.9762484\"],[\"-43.2257945\",\"-22.9751658\"]],\"lat\":\"-22.9762484\",\"lon\":\"-43.2252152\",\"display_name\":\"Avenida Bartolomeu Mitre, Leblon, Zona Sul do Rio de Janeiro, Rio de Janeiro, Região Metropolitana do Rio de Janeiro, Rio de Janeiro, Southeast Region, 22450-001, Brazil\",\"class\":\"highway\",\"type\":\"secondary\",\"importance\":0.7,\"address\":{\"road\":\"Avenida Bartolomeu Mitre\",\"suburb\":\"Leblon\",\"city_district\":\"Zona Sul do Rio de Janeiro\",\"city\":\"Rio de Janeiro\",\"county\":\"Rio de Janeiro\",\"state_district\":\"Região Metropolitana do Rio de Janeiro\",\"state\":\"Rio de Janeiro\",\"postcode\":\"22450-001\",\"country\":\"Brazil\",\"country_code\":\"br\"}},{\"place_id\":\"156936828\",\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https:\\/\\/osm.org\\/copyright\",\"osm_type\":\"way\",\"osm_id\":\"374895829\",\"boundingbox\":[\"-22.987021\",\"-22.9854283\",\"-43.2229035\",\"-43.2224766\"],\"polygonpoints\":[[\"-43.2224766\",\"-22.987021\"],[\"-43.2225028\",\"-22.9869083\"],[\"-43.2229035\",\"-22.9854283\"]],\"lat\":\"-22.9869083\",\"lon\":\"-43.2225028\",\"display_name\":\"Avenida Bartolomeu Mitre, Leblon, Zona Sul do Rio de Janeiro, Rio de Janeiro, Região Metropolitana do Rio de Janeiro, Rio de Janeiro, Southeast Region, 22441-012, Brazil\",\"class\":\"highway\",\"type\":\"secondary\",\"importance\":0.7,\"address\":{\"road\":\"Avenida Bartolomeu Mitre\",\"suburb\":\"Leblon\",\"city_district\":\"Zona Sul do Rio de Janeiro\",\"city\":\"Rio de Janeiro\",\"county\":\"Rio de Janeiro\",\"state_district\":\"Região Metropolitana do Rio de Janeiro\",\"state\":\"Rio de Janeiro\",\"postcode\":\"22441-012\",\"country\":\"Brazil\",\"country_code\":\"br\"}},{\"place_id\":\"79586937\",\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https:\\/\\/osm.org\\/copyright\",\"osm_type\":\"way\",\"osm_id\":\"37319458\",\"boundingbox\":[\"-22.9843627\",\"-22.9813797\",\"-43.2239276\",\"-43.2231865\"],\"polygonpoints\":[[\"-43.2231865\",\"-22.9843627\"],[\"-43.2233455\",\"-22.9836873\"],[\"-43.2235119\",\"-22.9830605\"],[\"-43.2236822\",\"-22.9824352\"],[\"-43.2238185\",\"-22.9818284\"],[\"-43.2239276\",\"-22.9813797\"]],\"lat\":\"-22.9830605\",\"lon\":\"-43.2235119\",\"display_name\":\"Avenida Bartolomeu Mitre, Leblon, Zona Sul do Rio de Janeiro, Rio de Janeiro, Região Metropolitana do Rio de Janeiro, Rio de Janeiro, Southeast Region, 22431-040, Brazil\",\"class\":\"highway\",\"type\":\"secondary\",\"importance\":0.7,\"address\":{\"road\":\"Avenida Bartolomeu Mitre\",\"suburb\":\"Leblon\",\"city_district\":\"Zona Sul do Rio de Janeiro\",\"city\":\"Rio de Janeiro\",\"county\":\"Rio de Janeiro\",\"state_district\":\"Região Metropolitana do Rio de Janeiro\",\"state\":\"Rio de Janeiro\",\"postcode\":\"22431-040\",\"country\":\"Brazil\",\"country_code\":\"br\"}},{\"place_id\":\"78110121\",\"licence\":\"Data © OpenStreetMap contributors, ODbL 1.0. https:\\/\\/osm.org\\/copyright\",\"osm_type\":\"way\",\"osm_id\":\"33300507\",\"boundingbox\":[\"-22.9813797\",\"-22.9789729\",\"-43.2242251\",\"-43.2237835\"],\"polygonpoints\":[[\"-43.2239276\",\"-22.9813797\"],[\"-43.2238988\",\"-22.9811874\"],[\"-43.223806\",\"-22.9807477\"],[\"-43.2237972\",\"-22.9806796\"],[\"-43.2237835\",\"-22.9805572\"],[\"-43.2238207\",\"-22.979974\"],[\"-43.2238511\",\"-22.979836\"],[\"-43.2239738\",\"-22.9795153\"],[\"-43.2240743\",\"-22.9792878\"],[\"-43.2240925\",\"-22.9792449\"],[\"-43.2241688\",\"-22.9790657\"],[\"-43.2242251\",\"-22.9789729\"]],\"lat\":\"-22.979974\",\"lon\":\"-43.2238207\",\"display_name\":\"Avenida Bartolomeu Mitre, Leblon, Zona Sul do Rio de Janeiro, Rio de Janeiro, Região Metropolitana do Rio de Janeiro, Rio de Janeiro, Southeast Region, 22431-050, Brazil\",\"class\":\"highway\",\"type\":\"secondary\",\"importance\":0.7,\"address\":{\"road\":\"Avenida Bartolomeu Mitre\",\"suburb\":\"Leblon\",\"city_district\":\"Zona Sul do Rio de Janeiro\",\"city\":\"Rio de Janeiro\",\"county\":\"Rio de Janeiro\",\"state_district\":\"Região Metropolitana do Rio de Janeiro\",\"state\":\"Rio de Janeiro\",\"postcode\":\"22431-050\",\"country\":\"Brazil\",\"country_code\":\"br\"}}]"
		
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
//		
		
	}
	
	public void search(String end, String cidade) {
		Client client = Client.create();
		WebResource webResource = client.resource("https://nominatim.openstreetmap.org/search");
		webResource.path("q=Avenida+Roberto+Silveira&polygon_geojson=1&viewbox=");
		String json = webResource.get(String.class);
		System.out.println(json);
		
	}
}
