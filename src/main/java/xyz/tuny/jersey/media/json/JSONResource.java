package xyz.tuny.jersey.media.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("json-resource")
public class JSONResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String query(String query) {
        //{"query":"name"}
        System.out.println(query.toString());
        JSONObject resp = new JSONObject();
        try {
            resp.put("respCode", 0);
            resp.put("respDesc", "nihao");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resp.toString();
    }
}
