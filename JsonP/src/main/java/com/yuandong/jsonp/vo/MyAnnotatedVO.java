package com.yuandong.jsonp.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyAnnotatedVO {

	private String _name;

	@JsonProperty("name")
	public String getTheName() {
		return _name;
	}

	public void setTheName(String _name) {
		this._name = _name;
	}
	
}
