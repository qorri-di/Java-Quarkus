package com.qorri.service;

import com.qorri.domain.userEntity;
import com.qorri.dto.ResponseDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class userService {
    public ResponseDTO readAllData(){
        List<userEntity> listUser = userEntity.findAll().list();
        return new ResponseDTO<>().successResponse(listUser);
    }

    public ResponseDTO readById(Integer id){
        if (id == null || id.equals("") || id.toString().isEmpty() && id.toString().isBlank()) {
            return new ResponseDTO<>().errorResponse(204,"Payload is empty");
        }
        userEntity user = userEntity.findById(id);
        if (user == null) {
            return new ResponseDTO<>().noDataFoundResponse();
        }
        return new ResponseDTO<>().successResponse(user);
    }

    public ResponseDTO createUser(userEntity req){
        if (req == null || req.isPersistent() || (req.getUserId() == null && req.getUserName().isEmpty() &&
                req.getUserCountry().isEmpty() && req.getUserGender().isEmpty())) {
            return new ResponseDTO<>().errorResponse(204,"Payload is empty");
        }
        userEntity user = new userEntity();
        user.setUserId(req.getUserId());
        user.setUserName(req.getUserName());
        user.setUserGender(req.getUserGender());
        user.setUserCountry(req.getUserCountry());
        user.persist();
        return new ResponseDTO<>().successResponse(user.getUserId());
    }

    public ResponseDTO updateUser(userEntity req){
        if (req == null) {
            return new ResponseDTO<>().errorResponse(204,"Payload is empty");
        }

        userEntity user = userEntity.findById(req.getUserId());
        if (user == null) {
            return new ResponseDTO<>().noDataFoundResponse();
        }

        user.setUserId(user.getUserId());
        if (req.getUserName() == null || req.getUserName().isBlank() || req.getUserName().isEmpty()) {
            user.setUserName(user.getUserName());
        } else {
            user.setUserName(req.getUserName());
        }
        if (req.getUserGender() == null || req.getUserGender().isEmpty() || req.getUserGender().isBlank()) {
            user.setUserGender(user.getUserGender());
        } else {
            user.setUserGender(req.getUserGender());
        }
        if (req.getUserCountry() == null || req.getUserCountry().isEmpty() || req.getUserCountry().isBlank()) {
            user.setUserCountry(user.getUserCountry());
        } else {
            user.setUserCountry(req.getUserCountry());
        }
        user.persist();

        return new ResponseDTO<>().successResponse(user.getUserId());
    }

    public ResponseDTO deleteById(Integer id){
        if (id == null || id.equals("") || id.toString().isEmpty() && id.toString().isBlank()) {
            return new ResponseDTO<>().errorResponse(204,"Payload is empty");
        }
        userEntity user = userEntity.findById(id);
        if (user == null){
            return new ResponseDTO<>().noDataFoundResponse();
        }
        user.delete();
        return new ResponseDTO<>().successResponse(id);
    }
}
