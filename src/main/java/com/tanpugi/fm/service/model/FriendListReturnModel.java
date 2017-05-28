package com.tanpugi.fm.service.model;

import java.util.ArrayList;
import java.util.List;

public class FriendListReturnModel extends DefaultReturnModel {

	private List<String> connections = new ArrayList<>();
	
	public List<String> getConnections() {
		return connections;
	}
	
	public void addConnections(List<String> connections) {
		this.connections.addAll(connections);
	}
	
	public void addConnection(String connection) {
		this.connections.add(connection);
	}
}
