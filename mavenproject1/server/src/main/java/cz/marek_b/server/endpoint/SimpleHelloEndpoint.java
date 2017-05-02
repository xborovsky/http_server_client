package cz.marek_b.server.endpoint;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/hello")
public class SimpleHelloEndpoint {
    
    @GET
    @Path("/simple")
    public Response hello() {
        return Response.status(Status.OK)
            .entity("test output").build();
    }
    
    @POST
    @Path("/simple")
    public Response helloPost(
        @FormParam("param1") String param1,
        @FormParam("param2") String param2) {
        return Response.status(Status.OK)
            .entity("param1=" + param1 + ", param2=" + param2)
            .build();
    }

}
