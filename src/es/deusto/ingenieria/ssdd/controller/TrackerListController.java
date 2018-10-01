package es.deusto.ingenieria.ssdd.controller;

import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TreeMap;

import es.deusto.ingenieria.ssdd.model.TrackerListModel;
import es.deusto.ingenieria.ssdd.utilities.WindowUtilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TrackerListController  extends Control implements Initializable{

	@FXML
	private TableView<TrackerListModel> tblTrakerList = new TableView<TrackerListModel>();

	private TreeMap<String, String> trackerStatus = new TreeMap<>(); //Add real data here

	private ObservableList<TrackerListModel> trackerInfo = FXCollections.observableArrayList();

	boolean error = false;

	public static boolean checkTrackerList = false;

	@FXML
	private Button btnTrackerInfo;

	@FXML
	private Button btnTrackerList;

	@FXML
	private Button btnSwarm;

	@FXML
	private Button btnTerminate;

	@FXML private TableColumn<TrackerListModel, String> clmIdentifier;
	@FXML private TableColumn<TrackerListModel, String> clmIsMaster;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnSwarm.setOpacity(0.3f);
		btnTrackerInfo.setOpacity(0.3f);
		btnTrackerList.setOpacity(1.0f);

		clmIdentifier.setCellValueFactory(cellData -> cellData.getValue().identifierProperty());
		clmIsMaster.setCellValueFactory(cellData -> cellData.getValue().isMasterProperty());

		clmIdentifier.setText("Tracker ID");
		clmIsMaster.setText("Is master");

		checkTrackerList = true;
			
		refreshInfo();
	} 

	public void btnTrackerNfo(Event event){
		WindowUtilities.windowTransition("DisplayTrackerInfo", event);
		checkTrackerList = false;
	}

	public void btnTrackerLst(Event event){}

	public void btnSwarmLst(Event event){
		WindowUtilities.windowTransition("DisplaySwarmList", event);
		checkTrackerList = false;
	}

	public void btnTerminateApp(Event event){
		WindowUtilities.terminateApp(event);
	}

	private void refreshPanel(){
		try{
			//TODO: retrieve real data
			clearAllData();
			Random random = new Random(); 
			trackerStatus.put(Integer.toString(random.nextInt()), "false");
			trackerStatus.put(Integer.toString(random.nextInt()), "true");
		}catch(Exception a){
			error = true;
			a.printStackTrace();
		}
		if(trackerStatus.isEmpty())tblTrakerList.setPlaceholder(new Label("No data"));
		else{
			for(Map.Entry<String,String> entry : trackerStatus.entrySet()) {
				trackerInfo.add(new TrackerListModel(entry.getKey(), entry.getValue()));
			}
			tblTrakerList.setItems(trackerInfo);
		}
	}

	private void clearAllData() {
		for ( int i = 0; i<tblTrakerList.getItems().size(); i++) {
			tblTrakerList.getItems().clear();
		}
	}

	private void refreshInfo(){
		new Thread(new Runnable() {  
			@Override  
			public void run() {  
				while(checkTrackerList){
					try {
						refreshPanel();
						Thread.sleep(5000);
					} catch (InterruptedException e) {
					}

				}

			}  
		}).start(); 

	}
}
