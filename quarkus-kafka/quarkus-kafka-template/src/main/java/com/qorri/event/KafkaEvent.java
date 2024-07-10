package com.qorri.event;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import io.vertx.core.json.JsonObject;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class KafkaEvent {
    @Inject
    Logger logger;

    @Incoming("event-in")
    public void sendToKafka(String request){
        logger.infof("------------------ Incoming Data [%s] ------------------", request);

        // create logic save

        logger.infof("------------------ Data has been successfully ------------------");
    }
}
