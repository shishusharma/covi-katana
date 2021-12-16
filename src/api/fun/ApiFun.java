package api.fun;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

//used in slotbook class
//ApiFun eligible for state and district details

public class ApiFun {
	
	
	public static Map<String,Integer> sortedData= new TreeMap<String,Integer>();
	public static Map<String,Integer> sortedDataDist= new TreeMap<String,Integer>();
//	private static int i;
//	
//	public static String getI() {
//		return ""+i;
//	}
//	public static void setI(int i) {
//		System.out.println("setI "+i);
//		ApiFun.i = i;
//	}
	public ApiFun() {
		HttpClient client=HttpClient.newHttpClient();
		 HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://cdn-api.co-vin.in/api/v2/admin/location/states")).build();
		 client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(ApiFun::parse).join();
		 
		 
//		 HttpClient client1=HttpClient.newHttpClient();
//		 HttpRequest request1=HttpRequest.newBuilder().uri(URI.create("https://cdn-api.co-vin.in/api/v2/admin/location/districts/"+getI()+"")).build();
//		 client1.sendAsync(request1, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(ApiFun::parseDist).join();

	}
	
	public ApiFun(int i) {
		 HttpClient client1=HttpClient.newHttpClient();
		 HttpRequest request1=HttpRequest.newBuilder().uri(URI.create("https://cdn-api.co-vin.in/api/v2/admin/location/districts/"+""+i+"")).build();
		 client1.sendAsync(request1, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(ApiFun::parseDist).join();

	}
	
	public static void main(String[] args) {
		new ApiFun();
	//	new ApiFun(5);
//		 HttpClient client1=HttpClient.newHttpClient();
//		 
//		
//
//	        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://cdn-api.co-vin.in/api/v2/admin/location/states?state_name=bihar")).build();
//
//	        client1.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(ApiFun::parse).join();
//	        System.out.println(sortedData.size());
	        
	}
	 
	
	
	public static String parseDist(String responseBody)
	{
	    JSONObject states=new JSONObject(responseBody);
	    
//	    JSONArray arr=states.getJSONArray("states");
	    JSONArray arr=states.getJSONArray("districts");
  
	   
	    for(int i=0;i<arr.length();i++)
	    {
	        JSONObject cdata=arr.getJSONObject(i);
	        int district_id=cdata.getInt("district_id");
	        //String state_name=cdata.getString("state_name");
	        String district_name=cdata.getString("district_name");
	        sortedDataDist.put(district_name,district_id);
	       
	    }
	    
	   // System.out.println(sortedData.get("Bihar"));;
	    sortedDataDist.forEach((k,v)->System.out.println(k+"  "+v));
	   
	    return null;
	
	}
	
	public static String parse(String responseBody)
	{
	    JSONObject states=new JSONObject(responseBody);
	    
	    JSONArray arr=states.getJSONArray("states");
	 
	   
	    for(int i=0;i<arr.length();i++)
	    {
	        JSONObject cdata=arr.getJSONObject(i);
	        int state_id=cdata.getInt("state_id");
	        String state_name=cdata.getString("state_name");
	       
	        sortedData.put(state_name,state_id);
	       
	    }
	    
	   System.out.println(sortedData.get("Bihar"));;
	    sortedData.forEach((k,v)->System.out.println(k+"  "+v));
	   
	    return null;
	
	}
	
	
	
	
	}
