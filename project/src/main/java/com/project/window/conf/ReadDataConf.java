package com.project.window.conf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadDataConf {

	private String[] dataTab;

	public void readConf() {
		Path path = Paths.get("../conf.ini");
		List<String> list = null;

		try {
			list = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataTab = list.stream().flatMap(word -> Stream.of(word.split("=|;"))).toArray(String[]::new);
	}

	public String getPathToDatabse() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
		.append(dataTab[1])
		.append(":")
		.append(dataTab[3])
		.append("://")
		.append(dataTab[5])
		.append(":")				
		.append(dataTab[7])
		.append(";databaseName=")
		.append(dataTab[9])
		.append(";user=")
		.append(dataTab[11])		
		.append(";password=").append(dataTab[13]);

		return stringBuilder.toString();
	}
}
