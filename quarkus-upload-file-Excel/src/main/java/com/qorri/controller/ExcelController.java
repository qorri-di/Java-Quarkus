package com.qorri.controller;

import com.qorri.dto.*;
import com.qorri.service.ExcelService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/api/learning/qorri-di/file")
public class ExcelController {
    @Inject
    ExcelService es;

    @POST
    @Path("/upload-excel")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO uploadFile(@MultipartForm FileUploadForm form) {
        if (form.file == null){
            return new ResponseDTO<>().errorResponse(203,"Please input file");
        }
        return es.uploadExcel(form.file);
    }
}