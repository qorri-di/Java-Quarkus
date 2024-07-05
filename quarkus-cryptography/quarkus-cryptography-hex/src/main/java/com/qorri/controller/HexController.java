package com.qorri.controller;

import com.qorri.common.HexUtils;
import com.qorri.dto.request.HexRequest;
import com.qorri.dto.response.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/learning/qorri-di/hex")
public class HexController {
    @Inject
    HexUtils bu;

    @POST
    @Path("/encrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO binaryEncode(HexRequest req) {
        if (req == null && req.getInput().isEmpty() && req.getInput().isBlank() && req.getInput().equalsIgnoreCase("")) {
            return new ResponseDTO<>().errorResponse(203,"Please input value");
        }
        HexResponse res = new HexResponse();
        res.setInput(req.getInput());
        res.setOutput(bu.encode(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully encrypted");
    }

    @POST
    @Path("/decrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO binaryDecode(HexRequest req) {
        if (req == null && req.getInput().isEmpty() && req.getInput().isBlank() && req.getInput().equalsIgnoreCase("")) {
            return new ResponseDTO<>().errorResponse(203,"Please input value");
        }
        HexResponse res = new HexResponse();
        res.setInput(req.getInput());
        res.setOutput(bu.decode(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully decrypted");
    }
}
