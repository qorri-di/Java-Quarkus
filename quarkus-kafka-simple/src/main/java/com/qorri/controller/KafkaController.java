package com.qorri.controller;

import com.qorri.dto.KafkaRequest;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.*;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/learning/qorri-di/kafka")
public class KafkaController {
    @Inject
    Logger logger;

    @Inject
    @Channel("event-out")
    Emitter<String> eventOut;

    @POST
    @Path("/send-to-kafka")
    @Consumes(MediaType.TEXT_PLAIN)
    public void sendKafka(String request) {
        JsonObject req = new JsonObject(request);
        long start = System.currentTimeMillis();
        eventOut.send(req.encodePrettily());
        long stop=System.currentTimeMillis();
        logger.infof("------eventOut.send [%s ms]--------",(stop-start));

        logger.infof("------------------ Data telah di submit [%s] ------------------", req.encodePrettily());
    }
}
