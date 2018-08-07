package br.com.bikerio.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.context.ExternalContext;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RestApiBikeRio {
	
	public JSONArray userArray =null;
	public JSONArray bikesArray = null; 	
	
	
	
	public void bikesRio() {
		String url = "http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/estacoesBikeRio";
		
		JSONParser parser = new JSONParser();
		
		JSONObject jsonObj = null;
		JSONArray 	jsonArray = null;
        try {         
		
		 URL oracle = new URL(url); // URL to Parse
         URLConnection	 yc = oracle.openConnection();
         BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
         
         String inputLine;
         while ((inputLine = in.readLine()) != null) {               
        	 
        	  try {
        		  jsonObj = (JSONObject) parser.parse(inputLine);
        		  jsonArray = (JSONArray) jsonObj.get("DATA");
  			} catch (ParseException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
         }
         in.close();
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }   
		this.bikesArray = jsonArray;   
 }   
		
		
	
	
	public void search(String endereco, String cidade) throws org.json.simple.parser.ParseException {
		
		String cidadeFormat = cidade.trim().replace(" ", "%20");
		String endFormat = endereco.trim().replace(" ", "%20");
		String url ="https://nominatim.openstreetmap.org/search/"+ endFormat+ "%201%20"+ cidadeFormat + "?format=json&addressdetails=1&limit=1&polygon_svg=1";
		
		JSONParser parser = new JSONParser();
		
		JSONArray jsonArray = null;
        try {         
		
		 URL oracle = new URL(url); // URL to Parse
         URLConnection	 yc = oracle.openConnection();
         BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
         
         String inputLine;
         while ((inputLine = in.readLine()) != null) {               
        	 
        	  try {
  				jsonArray = (JSONArray) parser.parse(inputLine);
  			} catch (ParseException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
         }
         in.close();
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }   
        
       this.userArray = jsonArray;
       
       bikesRio();
       calculateDistance();
 }   


	private HashMap<String[],Integer> calculateDistance() {
		HashMap<String[], Integer> listaDistancias = new HashMap<>();
			JSONObject userObj = new JSONObject();	
			String userLat = null;
			String userLong = null;
			
			for (Object object : userArray) {
				
				userObj = (JSONObject) object;
				userLat = (String) userObj.get("lat");
				userLong  = (String) userObj.get("lon");
			}
				
			for (Object	bikeObj : bikesArray) {
	            int longi = 6;
	            int lat = 5;
	            JSONArray bikeArray = (JSONArray) bikeObj;
	             
	            String bikeLat = bikeArray.get(lat).toString();
	            String bikeLong = bikeArray.get(longi).toString();
	           
	
	            System.out.println("\n");
	            
	            Double userLatDouble = Double.valueOf(userLat);
	            Double userLongDouble = Double.valueOf(userLong);
	            Double bikeLatDouble = Double.valueOf(bikeLat);
	            Double bikeLongDouble = Double.valueOf(bikeLong);
	        
	            final int R = 6371; // Radius of the earth

	            Double latDistance = deg2rad(bikeLatDouble - userLatDouble);
	            Double lonDistance = deg2rad(bikeLongDouble - userLongDouble);
	            Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	                    + Math.cos(deg2rad(userLatDouble)) * Math.cos(deg2rad(bikeLatDouble))
	                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	            Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	            double distance = R * c * 1000; // convert to meters

	            double height = 0.0;
	            distance = Math.pow(distance, 2) + Math.pow(height, 2);
	            String[] bikeCoord = new String[2];
	            bikeCoord[0] = bikeLat;
	            bikeCoord[1] = bikeLong;
	            int distanceRouded =(int) round(distance, 2);
	            listaDistancias.put(bikeCoord, distanceRouded );
	             
	        }
			return listaDistancias;
			
}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	public static HashMap<String[], Integer> sortHashMap(HashMap<String[], Integer> lista) {
		
	      Map<String[], Integer> map = sortByValues(lista); 
	      System.out.println("After Sorting:");
	      Set<?> set2 = map.entrySet();
	      Iterator<?> iterator2 = set2.iterator();
	      while(iterator2.hasNext()) {
	           Map.Entry me2 = (Map.Entry)iterator2.next();
	           System.out.print(me2.getKey() + ": ");
	           System.out.println(me2.getValue());
	      }
	      return (HashMap<String[], Integer>) map;
	  }

	  private static HashMap<String[], Integer> sortByValues(HashMap<String[], Integer> map) { 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

		       // Here I am copying the sorted list in HashMap
		       // using LinkedHashMap to preserve the insertion order
		       HashMap sortedHashMap = new LinkedHashMap();
		       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
		
			
	  }
	




	public Set<String[]> listaBikes() {
		Set<String[]> bikesCoords = null;
		bikesRio();
		if (this.userArray != null) {
			HashMap<String[], Integer> bikes = sortHashMap(calculateDistance());
			bikesCoords = bikes.keySet();
		}
		return bikesCoords;
	}




	public String[] userCoord() {
		String[] userCoord = null;
		JSONObject userObj = new JSONObject();
		String userLat = null;
		String userLong = null;
		
		for (Object object : userArray) {
			
			userObj = (JSONObject) object;
			userLat = (String) userObj.get("lat");
			userLong  = (String) userObj.get("lon");
			userCoord[0] = userLat;
			userCoord[1] =userLong;
		}
		return userCoord;
	}

}
	
