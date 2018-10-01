package es.deusto.ingenieria.ssdd.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import es.deusto.ingenieria.ssdd.model.SwarmListModel;
import es.deusto.ingenieria.ssdd.utilities.WindowUtilities;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class SwarmListController  extends Control implements Initializable{

	@FXML
	private Button btnTrackerInfo;

	@FXML
	private Button btnTrackerList;

	@FXML
	private Button btnSwarm;

	@FXML
	private Button btnTerminate;

	@FXML
	private TreeView<String> treeSwarmList;

	private static TreeMap<String, ArrayList<String>> list = new TreeMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnTrackerInfo.setOpacity(0.3f);
		btnTrackerList.setOpacity(0.3f);
		btnSwarm.setOpacity(1.0f);
		//TODO: get real info
		ArrayList<String> Swarm1 = new ArrayList<>();
		Swarm1.add("Peer 1");
		Swarm1.add("Peer 2");
		Swarm1.add("Peer 3");
		SwarmListModel.addElements("Swarm 1", Swarm1);

		ArrayList<String> Swarm2 = new ArrayList<>();
		Swarm2.add("Peer 4");
		Swarm2.add("Peer 5");
		Swarm2.add("Peer 6");
		SwarmListModel.addElements("Swarm 2", Swarm2);

		list = SwarmListModel.getMap();
		loadTree();
	} 

	private void loadTree() {
		TreeItem<String> rootItem = new TreeItem<String> ("List of Swarms");
		rootItem.setExpanded(true);
		for(Map.Entry<String,ArrayList<String>> entry : list.entrySet()) {
			TreeItem<String> nodes = new TreeItem<String> (entry.getKey());   
			ArrayList<String> elements = entry.getValue();
			for (String string : elements) {
				TreeItem<String> values = new TreeItem<String> (string);
				nodes.getChildren().add(values);
			}
			rootItem.getChildren().add(nodes);
		}

		treeSwarmList.setRoot(rootItem);

	}

	public void btnTrackerNfo(Event event){
		WindowUtilities.windowTransition("DisplayTrackerInfo", event);
	}

	public void btnTrackerLst(Event event){
		WindowUtilities.windowTransition("DisplayTrackerList", event);
	}

	public void btnSwarmLst(Event event){}

	public void btnTerminateApp(Event event){
		WindowUtilities.terminateApp(event);
	}
}
