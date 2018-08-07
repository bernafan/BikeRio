package beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.json.simple.parser.ParseException;

import br.com.bikerio.services.RestApiBikeRio;

@ManagedBean
// bean presente no escopo de sessão enquanto houver uma sessão entre o navegador e a aplicação
@SessionScoped

public class MapBean {
	private String endereco;
	private String cidade;
	private RestApiBikeRio restApi = new RestApiBikeRio();
	@PostConstruct
	public void init() {
		
	}
	
	public void search() {
		
		 try {
			restApi.search(this.getEndereco(), this.cidade);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
