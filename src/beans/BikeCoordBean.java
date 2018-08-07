package beans;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.bikerio.model.BikeBean;
import br.com.bikerio.services.RestApiBikeRio;

@ManagedBean
// bean presente no escopo de sessão enquanto houver uma sessão entre o navegador e a aplicação
@SessionScoped

public class BikeCoordBean {
	private Set<String[]> bikesCoords = null;
	List<BikeBean> bikeBeanList = null;
	private RestApiBikeRio restApi = new RestApiBikeRio();
	@PostConstruct
	
	public void init() {
		
	
	     
	}
	
	public List<BikeBean> getBikes() {
		bikesCoords =restApi.listaBikes();
		
		if (bikesCoords != null) {
		BikeBean bike = new BikeBean();
		for (String[] strings : bikesCoords) {
			bike.setBikeCoordLat( strings[0]);
			bike.setBikeCoordLong( strings[1]);
			bikeBeanList.add(bike);
		}
	}
		return bikeBeanList;
	}
}
