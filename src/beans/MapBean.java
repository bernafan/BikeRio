package beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.bikerio.services.RestApiBikeRio;

@ManagedBean
// bean presente no escopo de sessão enquanto houver uma sessão entre o navegador e a aplicação
@SessionScoped

public class MapBean {
	private String endereco;
	private RestApiBikeRio restApi = new RestApiBikeRio();
	@PostConstruct
	public void init() {
		
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void search(String endereco) {
	
		 restApi.search(endereco);;
	}
}
