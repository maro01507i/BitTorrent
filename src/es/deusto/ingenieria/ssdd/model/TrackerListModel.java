package es.deusto.ingenieria.ssdd.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TrackerListModel {
	private StringProperty id;
	private StringProperty isMaster;
	
	public TrackerListModel(String identifier, String isMaster) {
		this.id = new SimpleStringProperty(identifier);
		this.isMaster = new SimpleStringProperty(isMaster);
	}

	public StringProperty getId() {
		return id;
	}

	public void setId(StringProperty id) {
		this.id = id;
	}

	public StringProperty getIsMaster() {
		return isMaster;
	}

	public void setIsMaster(StringProperty isMaster) {
		this.isMaster = isMaster;
	}
	
	public StringProperty identifierProperty() {
		return id;
	}
	
	public StringProperty isMasterProperty() {
		return isMaster;
	}
	
	
}
