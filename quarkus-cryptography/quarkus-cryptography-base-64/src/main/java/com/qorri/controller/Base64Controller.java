package com.qorri.controller;

import com.qorri.common.Base64Utils;
import com.qorri.dto.request.Base64Request;
import com.qorri.dto.response.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/learning/qorri-di/base64")
public class Base64Controller {
    @Inject
    Base64Utils base64;

    @POST
    @Path("/encrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO binaryEncode(Base64Request req) {
        if (req == null && req.getInput().isEmpty() && req.getInput().isBlank() && req.getInput().equalsIgnoreCase("")) {
            return new ResponseDTO<>().errorResponse(203,"Please input value");
        }
        Base64Response res = new Base64Response();
        res.setInput(req.getInput());
        res.setOutput(base64.encode(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully encrypted");
    }

    @POST
    @Path("/decrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO binaryDecode(Base64Request req) {
        if (req == null && req.getInput().isEmpty() && req.getInput().isBlank() && req.getInput().equalsIgnoreCase("")) {
            return new ResponseDTO<>().errorResponse(203,"Please input value");
        }
        Base64Response res = new Base64Response();
        res.setInput(req.getInput());
        res.setOutput(base64.decode(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully decrypted");
    }
}
