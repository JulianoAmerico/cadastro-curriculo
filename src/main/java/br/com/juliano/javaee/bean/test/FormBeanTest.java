package br.com.juliano.javaee.bean.test;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("form")
@RequestScoped
public class FormBeanTest implements Serializable {

	private String inputCep;
	
	
	public String processar() {
		return null;
	}
	
	public String getInputCep() {
		return inputCep;
	}

	public void setInputCep(String inputCep) {
		this.inputCep = inputCep;
	}

}
