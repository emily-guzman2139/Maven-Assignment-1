package jsonparser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonParser {

    public static List<Student> parseJSOn(String url) throws ParseException {
        List<Student> studentList = new ArrayList();
        Client client = Client.create();
        WebResource webResource = client.resource(url);

        ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
        if (clientResponse.getStatus() != 200) {
            throw new RuntimeException("Failed"+ clientResponse.toString());
        }

        JSONArray jsonArray = (JSONArray) new  JSONParser().parse(clientResponse.getEntity(String.class));

        Iterator<Object> it = jsonArray.iterator();

        String firstName;
        String gender;
        String email;
        double gpa;
        while (it.hasNext()){
            JSONObject jsonObject = (JSONObject)it.next();
            firstName = (String)jsonObject.get("first_name");
            gender = (String)jsonObject.get("gender");
            email = (String)jsonObject.get("email");
            gpa = Double.parseDouble((String)jsonObject.get("gpa"));
            studentList.add(new Student(firstName,gender,email,gpa));
        }

        return studentList;
    }
}
