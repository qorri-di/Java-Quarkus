package com.qorri.controller;

import com.qorri.common.BinaryUtils;
import com.qorri.dto.request.BinaryRequest;
import com.qorri.dto.response.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/learning/qorri-di/binary")
public class BinaryController {
    @Inject
    BinaryUtils bu;

    @POST
    @Path("/encrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO binaryEncode(BinaryRequest req) {
        if (req == null && req.getInput().isEmpty() && req.getInput().isBlank() && req.getInput().equalsIgnoreCase("")) {
            return new ResponseDTO<>().errorResponse(203,"Please input value");
        }
        BinaryResponse res = new BinaryResponse();
        res.setInput(req.getInput());
        res.setOutput(bu.encode(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully encrypted");
    }

    @POST
    @Path("/decrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO binaryDecode(BinaryRequest req) {
        if (req == null && req.getInput().isEmpty() && req.getInput().isBlank() && req.getInput().equalsIgnoreCase("")) {
            return new ResponseDTO<>().errorResponse(203,"Please input value");
        }
        BinaryResponse res = new BinaryResponse();
        res.setInput(req.getInput());
        res.setOutput(bu.decode(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully decrypted");
    }
}
