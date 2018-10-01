package es.deusto.ingenieria.ssdd.model;

import java.util.ArrayList;
import java.util.TreeMap;

public class SwarmListModel {

	private static TreeMap<String, ArrayList<String>> list = new TreeMap<>();

	public static TreeMap<String, ArrayList<String>> getMap(){
		return list;
	}

	public static void addID(String id) {
		if(!list.containsKey(id)) list.put(id, new ArrayList<>());
	}

	public static void removeCategory(String id) {
		if(list.containsKey(id)) list.remove(id);
	}

	public static void addElements(String id, ArrayList<String> elements) {
		if(!list.containsKey(id)){
			list.put(id, new ArrayList<String>());
		}
		for(int i = 0; i < elements.size(); i++){
			list.get(id).add(elements.get(i));
		}
	}

}