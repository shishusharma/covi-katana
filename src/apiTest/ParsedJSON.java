package apiTest;


import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ParsedJSON
{
    public static void main(String[] args) {
        //Creating the client object
        HttpClient client=HttpClient.newHttpClient();

        //Request Setup
        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=111&date=31-03-2021")).build();

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
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(ParsedJSON::parse)
                .join();
    }

    /*
        Parsing the JSON Data
     */
    public static String parse(String responseBody)
    {
        JSONObject session=new JSONObject(responseBody);


        JSONArray arr=session.getJSONArray("sessions");

        for(int i=0;i<arr.length();i++)
        {
            JSONObject cdata=arr.getJSONObject(i);
            int center_id=cdata.getInt("center_id");
            String center_name=cdata.getString("name");
            String center_addr=cdata.getString("address");
            String dist_name=cdata.getString("district_name");
            String state_name=cdata.getString("state_name");
            int pincode=cdata.getInt("pincode");
            String date=cdata.getString("date");
            int avail_doses=cdata.getInt("available_capacity");

            //Printing the Parsed Data
            System.out.println(center_id+"  "+center_name+"  "+dist_name+"  "+state_name+"  "+pincode+"  "+date+"  "+avail_doses);
        }
        return null;

    }


}
