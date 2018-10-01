package es.deusto.ingenieria.ssdd.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class TrackerInfoModel {

	private int pID;
	private int port;
	private String IP;

	public TrackerInfoModel() {
		super();
		this.pID = getCurrentPID();
		this.port = getCurretPort();
		this.IP = getCurrentIP();
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getCurrentPID(){
		String[] parts = ManagementFactory.getRuntimeMXBean().getName().split("@");
		return Integer.parseInt(parts[0]);
	}

	public int getCurretPort(){
		Random rand = new Random();

		int  port = rand.nextInt(1000) + 1;

		return port;
	}

	private String getCurrentIP() {
		URL whatismyip;
		try {
			whatismyip = new URL("http://checkip.amazonaws.com");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			return "0";
		}
		BufferedReader in;
		
		String ip = "";

		try {
			in = new BufferedReader(new InputStreamReader(
					whatismyip.openStream()));
			ip = in.readLine();
		} catch (IOException e) {
			return "0";
		}
		 
		return ip;

	}
}
