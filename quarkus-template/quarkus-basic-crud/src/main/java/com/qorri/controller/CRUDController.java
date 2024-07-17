package com.qorri.controller;

import com.qorri.domain.userEntity;
import com.qorri.dto.ResponseDTO;
import com.qorri.service.userService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/learning/qorri-di/crud")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CRUDController {
    @Inject
    userService userService;

    @GET
    @Path("/read-all")
    public ResponseDTO readAll() {
        return userService.readAllData();
    }

    @GET
    @Path("/read-by-id/{id}")
    public ResponseDTO readById(@PathParam("id") Integer id) {
        return userService.readById(id);
    }

    @POST
    @Path("/create")
    public ResponseDTO create(userEntity req) {
        return userService.createUser(req);

    }

    @PUT
    @Path("/update")
    public ResponseDTO update(userEntity req) {
        return userService.updateUser(req);

    }

    @DELETE
    @Path("/delete/{id}")
    public ResponseDTO delete(@PathParam("id") Integer id) {
        return userService.deleteById(id);

    }

}
