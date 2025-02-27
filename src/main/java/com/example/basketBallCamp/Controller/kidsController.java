package com.example.basketBallCamp.Controller;

import com.example.basketBallCamp.Entity.kids;
import com.example.basketBallCamp.Model.ResponseModel;
import com.example.basketBallCamp.Model.kidsModel;
import com.example.basketBallCamp.Service.kidsService;
import com.example.basketBallCamp.Utils.kidsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/kids")
public class kidsController {

    @Autowired
    private kidsService kidsService;

    @GetMapping("/get-all-kids")
    public ResponseEntity<ResponseModel> getAllKids() {
        List<kids> kidsList = kidsService.getAllKids();

        ResponseModel responseModel = ResponseModel.builder()
                .status(HttpStatus.OK)
                .message("Kids retrieved successfully")
                .data(kidsList)
                .build();

        return ResponseEntity.ok(responseModel);
    }

    @PostMapping("/add-kid")
    public ResponseEntity<ResponseModel> addKid(@RequestBody kids kid) {
        ResponseModel responseModel = ResponseModel.builder()
                .status(HttpStatus.OK)
                .message("Kid added successfully")
                .data(new Object())
                .build();

        if (kidsService.existsBykidEmail(kid.getKidEmail())) {
            responseModel.setStatus(HttpStatus.BAD_REQUEST);
            responseModel.setMessage("Email already in use");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
        }
        Long id = kidsService.addKid(kid);
        responseModel.setData(id);
        return ResponseEntity.ok(responseModel);
    }

    @GetMapping("/get-kid/{id}")
    public ResponseEntity<ResponseModel> getKidsById(@PathVariable Long id) {
        kids kid = kidsService.getKid(id);

        if (kid == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseModel.builder()
                            .status(HttpStatus.NOT_FOUND)
                            .message("Kid not found")
                            .data(null)
                            .build());
        }

        kidsModel kidModel = kidsConverter.convertKidTokidsModel(kid);

        ResponseModel responseModel = ResponseModel.builder()
                .status(HttpStatus.OK)
                .message("Kid retrieved successfully")
                .data(kidModel)
                .build();

        return ResponseEntity.ok(responseModel);
    }
}
