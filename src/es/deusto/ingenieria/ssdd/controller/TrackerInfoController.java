package es.deusto.ingenieria.ssdd.controller;

import java.net.URL;
import java.util.ResourceBundle;

import es.deusto.ingenieria.ssdd.model.TrackerInfoModel;
import es.deusto.ingenieria.ssdd.utilities.WindowUtilities;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.text.Text;

public class TrackerInfoController  extends Control implements Initializable{

	private TrackerInfoModel model;

	@FXML
	private Text txtpID;

	@FXML
	private Text txtPort;
	
	@FXML
	private Text txtIp;

	@FXML
	private Button btnTrackerInfo;

	@FXML
	private Button btnTrackerList;
	
	@FXML
	private Button btnSwarm;

	@FXML
	private Button btnTerminate;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnTrackerInfo.setOpacity(1f);
		btnSwarm.setOpacity(0.3f);
		btnTrackerList.setOpacity(0.3f);
		model = new TrackerInfoModel();
		txtPort.setText(Integer.toString(model.getPort()));
		txtpID.setText(Integer.toString(model.getpID()));
		txtIp.setText(model.getIP());
	} 

	public void btnTrackerNfo(Event event){}

	public void btnTrackerLst(Event event){
		WindowUtilities.windowTransition("DisplayTrackerList", event);
	}

	public void btnSwarmLst(Event event){
		WindowUtilities.windowTransition("DisplaySwarmList", event);
	}

	public void btnTerminateApp(Event event){
		WindowUtilities.terminateApp(event);
	}
}
