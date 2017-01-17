package kitri.reservation.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
@Service("sidoservice")
public class sidoService {
	//시도 네임 -> 시도 코드
	public String getsidoCode(String inputSidoName) {
		String return_Val = "";
		StringBuilder urlBuilder = new StringBuilder("http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admCodeList.json?authkey=a21a6e7762d77e69209c54"); /*URL*/
		JSONParser parser = new JSONParser();
		
		try {			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        
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
			//json parse, 시도코드반환
			JSONObject rootObj = (JSONObject)parser.parse(sb.toString());
			JSONObject rootObj_Val = (JSONObject) rootObj.get("admVOList");
			JSONArray jsonArray = (JSONArray)rootObj_Val.get("admVOList");
			for(int i =0; i < jsonArray.size(); i++) {
				JSONObject jsonArrayObj = (JSONObject) jsonArray.get(i);
				String data = (String)jsonArrayObj.get("admCode");							
				if(data.equals(inputSidoName)) {
					return_Val =  (String)jsonArrayObj.get("admCode");
					System.out.println("return_Val : " + return_Val);
				}			
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {				
			e.printStackTrace();
		} catch (ParseException e) {				
			e.printStackTrace();
		}
		return return_Val;
	}		
	//시도 코드 -> 시도 이름
	public String getsidoName(String inputSidoCode) {
		String return_Val = "";
		StringBuilder urlBuilder = new StringBuilder("http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admCodeList.json?authkey=a21a6e7762d77e69209c54"); /*URL*/
		JSONParser parser = new JSONParser();
		
		try {			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        
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
			//json parse, 시도코드반환
			JSONObject rootObj = (JSONObject)parser.parse(sb.toString());
			JSONObject rootObj_Val = (JSONObject) rootObj.get("admVOList");
			JSONArray jsonArray = (JSONArray)rootObj_Val.get("admVOList");
			for(int i =0; i < jsonArray.size(); i++) {
				JSONObject jsonArrayObj = (JSONObject) jsonArray.get(i);
				String data = (String)jsonArrayObj.get("admCode");					
				if(data.equals(inputSidoCode)) {
					return_Val =  (String)jsonArrayObj.get("admCodeNm");
				}			
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {				
			e.printStackTrace();
		} catch (ParseException e) {				
			e.printStackTrace();
		}
		return return_Val;
	}		
}
