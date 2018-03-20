package com.wheebox.util.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.json.JSONObject;

public class ReadFile {

	public File getFile(String fileName) {

		File file = null;
		try {
			
			ClassLoader classLoader = this.getClass().getClassLoader();
			file = new File(classLoader.getResource(fileName).getFile());
			System.out.println(file.getName());
			
		}
		catch(Exception i) {
			i.printStackTrace();
		}
		
		return file;

	}
	
	public String readFile(File file) {
		
		String line = "";
		FileInputStream inputStream = null;
		try {
			
			inputStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			while(reader.readLine() != null) {
				line = reader.readLine();
			}
			reader.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return line;
	}

	
	
	public JSONObject converToJSONObject(String line) {
		StringTokenizer token = new StringTokenizer(line, "=");
		String key = "";
		String value = "";

		JSONObject jsonObj = new JSONObject();

		while (token.hasMoreElements()) {

			key = token.nextToken();
			value = token.nextToken();

			// System.out.println(key + "--" + value);

			jsonObj.put(key, value);

		}

		return jsonObj;
	}

	public static void main(String[] args) {

		ReadFile rf = new ReadFile();
		// List list = file.getFile("Resource_menu.properties");
		JSONObject jsonObj = new JSONObject();
		/*List<JSONObject> jsonList = new ArrayList<JSONObject>();
		String str = null;
		// Adding json object into list

		// printing json list one by one
		System.out.println();
		for (JSONObject obj : jsonList) {
			System.out.println(obj);
		}*/
		File file = rf.getFile("Resource_menu.properties");
		 System.out.println(rf.readFile(file));
	}

}
