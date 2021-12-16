package apiTest;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiCall {
	
	 static Map<String,Integer> m1 = new HashMap<>();
	public static Map<String,Integer> sortedData= new TreeMap<String,Integer>();
	 //Set<String> data =null;
	////static String[] myArray = new String[data.size()];
	
	public static void main(String[] args) throws IOException, InterruptedException {
		var url="https://data.covid19india.org/v4/min/data.min.json";
		var url2="https://cdn-api.co-vin.in/api/v2/admin/location/states";
		
		var req=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		var req2=HttpRequest.newBuilder().GET().uri(URI.create(url2)).build();
		var client=HttpClient.newBuilder().build();
		var res=client.send(req, HttpResponse.BodyHandlers.ofString());
		var res2=client.send(req2, HttpResponse.BodyHandlers.ofString());
		

		
		System.out.println(res.statusCode());
		System.out.println(res.body());
//		System.out.println(res2.statusCode());
//		System.out.println(res2.body());
		System.out.println("\n\n\n\n");
//		client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
//		.thenApply(HttpResponse::body)
//		.thenApply(ParsedJSON::parse)
//		.join();
		
		
		   HttpClient client1=HttpClient.newHttpClient();

	        //Request Setup
	        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://cdn-api.co-vin.in/api/v2/admin/location/states?state_name=bihar")).build();

	        /*
	            Now sending the request Asynchronously.
	            Here, the first parameter is the request, and the second is the way in which
	            the response is required from the Server, here as String.
	         */
	        /*
	            The sendAsync() method returns CompletableFuture type data.
	            Then thisApply() is used for the received results.
	            Then thisAccept() is used.

	            join() is used to basically display the result.

	         */
	        client1.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(ApiCall::parse).join();
	        
	        System.out.println(m1.size());
	      for(Map.Entry<String,Integer> m:m1.entrySet()) {
	    	  if(m.getKey()=="Bihar") {
	    		  System.out.println(m.getValue());
	    	  }
	      }
	       
	        

	}
	 /*
    Parsing the JSON Data
 */
public static String parse(String responseBody)
{
    JSONObject states=new JSONObject(responseBody);
    
    
    
    //    Iterator<String> keys=states.keys();
//    while(keys.hasNext()) {
//    	String key=keys.next();
//    	System.out.println("key :"+key+"state"+states.get(key));
//    }
    
    JSONArray arr=states.getJSONArray("states");
    
   
    
    
    for(int i=0;i<arr.length();i++)
    {
        JSONObject cdata=arr.getJSONObject(i);
        int state_id=cdata.getInt("state_id");
        String state_name=cdata.getString("state_name");
        
        
        //int avail_doses=cdata.getInt("available_capacity");
        //System.out.println(state_id+" "+state_name);
       sortedData.put(state_name,state_id);
        m1.put(state_name,state_id);
        
        
    }
    System.out.println(sortedData.get(18));;
    sortedData.forEach((k,v)->System.out.println(k+"  "+v));
    return null;

}


}
