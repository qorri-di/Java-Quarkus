package com.qorri;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/learning/qorri-di")
public class GreetingResource {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println("latihan euy");
        return "Hello from RESTEasy Reactive";
    }
}
