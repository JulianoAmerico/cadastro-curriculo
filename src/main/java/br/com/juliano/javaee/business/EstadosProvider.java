package br.com.juliano.javaee.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Fornece todos os estados brasileiros com as siglas correspondentes. O atributo Map é utilizado
 * para exibir os estados na página para o usuário.
 * @author Juliano
 *
 */
public abstract class EstadosProvider {

	private static Map<String, String> estados;
	
	static {
		estados = new TreeMap<>();
		estados.put("AC", "Acre");
		estados.put("AL", "Alagoas");
		estados.put("AP", "Amapá");
		estados.put("AM", "Amazonas");
		estados.put("BA", "Bahia");
		estados.put("CE", "Ceará");
		estados.put("DF", "Distrito Federal");
		estados.put("ES", "Espírito Santo");
		estados.put("GO", "Goiás");
		estados.put("MA", "Maranhão");
		estados.put("MT", "Mato Grosso");
		estados.put("MS", "Mato Grosso do Sul");
		estados.put("MG", "Minas Gerais");
		estados.put("PA", "Pará");
		estados.put("PB", "Paraíba");
		estados.put("PE", "Pernambuco");
		estados.put("PI", "Piauí");
		estados.put("RJ", "Rio de Janeiro");
		estados.put("RN", "Rio Grande do Norte");
		estados.put("RS", "Rio Grande do Sul");
		estados.put("RO", "Rondônia");
		estados.put("RR", "Roraima");
		estados.put("SC", "Santa Catarina");
		estados.put("SP", "São Paulo");
		estados.put("SE", "Sergipe");
		estados.put("TO", "Tocantins");
	}
	
	public static Map<String, String> getEstados() {
		return estados;
	}
	
	public static Collection<String> getEstadosCollection(){
		Set<Map.Entry<String, String>> set = estados.entrySet();
		Collection<String> collection = new ArrayList<>(); 
		set.forEach(e -> collection.add(e.getValue()));
		return collection;
	}
	
	public static Collection<String> getSiglaCollection(){
		Set<Map.Entry<String, String>> set = estados.entrySet();
		Collection<String> collection = new ArrayList<>(); 
		set.forEach(e -> collection.add(e.getKey()));
		return collection;
	}
}
