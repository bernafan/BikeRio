package beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.bikerio.model.UserBean;
import br.com.bikerio.services.RestApiBikeRio;

@ManagedBean
// bean presente no escopo de sessão enquanto houver uma sessão entre o navegador e a aplicação
@SessionScoped

public class UserCoordBean {
	UserBean user = null;
	private RestApiBikeRio restApi = new RestApiBikeRio();
	@PostConstruct
	
	public void init() {
		if( user != null) {
			String[] coords =restApi.userCoord();
			user.setLat(coords[0]);
			user.setLon(coords[1]);
		}
	     
	}
	
	public UserBean getUser() {
		return user;
	}
}
