package kitri.reservation.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class gunguService {
	public ArrayList<String> getgunguCode(String inputStr){		
		ArrayList<String> return_Val = new ArrayList<String>();
		StringBuilder urlBuilder = new StringBuilder("http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admSiList.json?authkey=12ccdb60a3a9b461148e5a&admCode="+ inputStr); /*URL*/
		System.out.println(urlBuilder);
		JSONParser parser = new JSONParser();
		URL url;
		try {
			//url로 Json불러오기
			url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();	       
	        
	        //Json 파싱
	        JSONObject rootObj = (JSONObject)parser.parse(sb.toString());
	        
	        JSONObject rootObj_Val = (JSONObject) rootObj.get("admVOList");
	        JSONArray jsonArray = (JSONArray)rootObj_Val.get("admVOList");
	        String glue="";
	        for(int i =0; i < jsonArray.size(); i++) {
				JSONObject jsonArrayObj = (JSONObject) jsonArray.get(i);
				String data = (String)jsonArrayObj.get("admCode");	
				glue = (String)jsonArrayObj.get("admCode")+","+(String)jsonArrayObj.get("lowestAdmCodeNm");
				return_Val.add(glue);
			}	        
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}	
		return return_Val;
	}
	public String getgunguName(String inputStr){		
		String return_Val = "";
		StringBuilder urlBuilder = new StringBuilder("http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admSiList.json?authkey=12ccdb60a3a9b461148e5a&admCode="+ inputStr); /*URL*/
		
		JSONParser parser = new JSONParser();
		URL url;
		try {
			//url로 Json불러오기
			url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();	       
	        
	        //Json 파싱
	        JSONObject rootObj = (JSONObject)parser.parse(sb.toString());
	        JSONObject rootObj_Val = (JSONObject) rootObj.get("admVOList");
	        JSONArray jsonArray = (JSONArray)rootObj_Val.get("admVOList");
	        System.out.println("---" + rootObj);
	        for(int i =0; i < jsonArray.size(); i++) {
				JSONObject jsonArrayObj = (JSONObject) jsonArray.get(i);
				if(inputStr.equals( (String)jsonArrayObj.get("admCode") )) {
					return_Val = (String)jsonArrayObj.get("lowestAdmCodeNm");	
				}
							
			}	        
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}	
		return return_Val;
	}	
}
