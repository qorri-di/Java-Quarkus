package com.qorri;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Path("/learning")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println("latihan euy");
        return "Hello from RESTEasy Reactive";
    }
}
