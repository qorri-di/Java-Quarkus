package com.qorri.dto;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import java.io.InputStream;

public class FileUploadForm {
    @FormParam("file")
    @PartType("application/octet-stream")
    public InputStream file;
}
