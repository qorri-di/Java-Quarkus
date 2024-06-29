package com.qorri.controller;

import com.qorri.dto.KafkaRequest;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.*;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/api/learning/qorri-di/kafka")
public class KafkaController {
    @Inject
    Logger logger;

    @Inject
    @Channel("event-out")
    Emitter<String> eventOut;

    @POST
    @Path("/send-to-kafka")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public void sendKafka(KafkaRequest request) {
        JsonObject jsonData = JsonObject.mapFrom(request);
        long start = System.currentTimeMillis();
        eventOut.send(jsonData.encode());
        long stop=System.currentTimeMillis();
        logger.infof("------eventOut.send [%s ms]--------",(stop-start));

        logger.infof("------------------ Data telah di submit [%s] ------------------", jsonData.encode());
    }
}
