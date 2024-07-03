package com.qorri.controller;

import com.qorri.common.Aes128Utils;
import com.qorri.dto.request.aesRequest;
import com.qorri.dto.response.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/api/learning/qorri-di/aes-128")
public class AES128Controller {

    @Inject
    Aes128Utils aes128;

    @POST
    @Path("/encrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO aesEncrypt(aesRequest req) throws Exception {
        if (req == null && req.getInput().isEmpty() && req.getInput().isBlank() && req.getInput().equalsIgnoreCase("")) {
            return new ResponseDTO<>().errorResponse(203,"Please input value");
        }
        aesResponse res = new aesResponse();
        res.setInput(req.getInput());
        res.setOutput(aes128.encrypt(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully encrypted");
    }

    @POST
    @Path("/decrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO aesDecrypt(aesRequest req) throws Exception {
        if (req == null && req.getInput().isEmpty() && req.getInput().isBlank() && req.getInput().equalsIgnoreCase("")) {
            return new ResponseDTO<>().errorResponse(203,"Please input value");
        }
        aesResponse res = new aesResponse();
        res.setInput(req.getInput());
        res.setOutput(aes128.decrypt(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully decrypted");
    }
}
