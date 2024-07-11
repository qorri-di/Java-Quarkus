package com.qorri.controller;

import com.qorri.dto.*;
import io.quarkus.redis.client.*;
import io.vertx.core.json.JsonObject;
import io.vertx.redis.client.Response;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Path("/api/learning/qorri-di/redis")
public class redisController {

    @Inject
    RedisClient redisClient;

    @POST
    @Path("/send-to-redis")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO sendToRedis(RedisDTO req) {
        if (req == null && req.getId() == null && req.getName().isBlank() && req.getName().isEmpty()
                && req.getGender().isBlank() && req.getGender().isEmpty() && req.getCountry().isBlank() && req.getCountry().isEmpty()) {
            return new ResponseDTO<>().errorResponse(204, "Payload not null");
        }
        JsonObject data = new JsonObject();
        data.put("key", req.getName() + req.getId());
        data.put("value", JsonObject.mapFrom(req).encode());
        redisClient.set(Arrays.asList(data.getString("key"), data.getString("value")));
        return new ResponseDTO<>().successResponse("Success send to redis");
    }

    @GET
    @Path("/get/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO sendToRedis(@PathParam("key") String key) {
        Response dataRedis = redisClient.get(key);
        if (dataRedis == null) {
            return new ResponseDTO<>().errorResponse(204, "Data null");
        }
        JsonObject value = new JsonObject(dataRedis.toString());
        RedisDTO data = value.mapTo(RedisDTO.class);

        return new ResponseDTO<>().successResponse(data,"Success get data redis");
    }
}
