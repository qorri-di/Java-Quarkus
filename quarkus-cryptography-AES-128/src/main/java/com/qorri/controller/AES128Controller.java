package com.qorri.controller;

import com.qorri.common.AESUtils;
import com.qorri.dto.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/api/learning/qorri-di/aes-128")
public class AES128Controller {

    @Inject
    AESUtils aesUtil;

    @POST
    @Path("/encrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO aesEncrypt(aesRequest req) throws Exception {
        aesResponse res = new aesResponse();
        res.setInput(req.getInput());
        res.setOutput(aesUtil.encrypt(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully encrypted");
    }

    @POST
    @Path("/decrypt")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO aesDecrypt(aesRequest req) throws Exception {
        aesResponse res = new aesResponse();
        res.setInput(req.getInput());
        res.setOutput(aesUtil.decrypt(req.getInput()));
        return new ResponseDTO<>().successResponse(res,"Data has been successfully decrypted");
    }
}
