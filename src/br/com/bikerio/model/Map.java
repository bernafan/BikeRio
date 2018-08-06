package br.com.bikerio.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Map {
	@JsonProperty("COLUMNS")
	private String column;
	@JsonProperty("DATA")
	private String data;
	
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
}
