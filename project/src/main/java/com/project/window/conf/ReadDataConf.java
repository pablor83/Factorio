package com.project.window.conf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadDataConf {

	private Map<String, String> mapPath;
	private int readStatus = 0;

	public void readConf() {
		Path path = Paths.get("../conf.ini");
		List<String> list = null;

		try {
			list = Files.readAllLines(path);
			
			mapPath = list
					.stream()
					.map(this::getSplitDataTab)
					.collect(Collectors.toMap(key -> key[0], value -> value[1], (duplicateKey1, duplicateKey2) -> {
						return duplicateKey1;
					}));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			readStatus = 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			readStatus = 2;
		}
	}

	private String[] getSplitDataTab(String dataToSplit) {
		String[] splitTable = dataToSplit.split("=|;");
		splitTable[0] = splitTable[0].toLowerCase();
		return splitTable;
	}

	public String getPathToDatabase() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
		.append(mapPath.get("driver"))
		.append("://")
		.append(mapPath.get("host"))
		.append(":")				
		.append(mapPath.get("port"))
		.append(";databaseName=")
		.append(mapPath.get("databasename"))
		.append(";user=")
		.append(mapPath.get("user"))		
		.append(";password=")
		.append(mapPath.get("password"));

		return stringBuilder.toString();
	}
	
	public int getReadStatus() {
		return readStatus;
	}
}
