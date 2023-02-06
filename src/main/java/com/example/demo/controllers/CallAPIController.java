package com.example.demo.controllers;

import com.example.demo.external.ResponseAPI;
import com.example.demo.services.CallAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callapi")
public class CallAPIController {
    private CallAPIService callAPI;

    @Autowired
    public CallAPIController(CallAPIService callAPI) {
        this.callAPI = callAPI;
    }

    @PostMapping("{param}")
    @ResponseBody
    public ResponseAPI reviewAPI(@PathVariable String param) {
        return this.callAPI.reviewAPI(param).orElse(
                ResponseAPI.builder()
                        .responseCode(400)
                        .description("Error al llamar el servicio. Revise la URL y los parámetros")
                        .elapsedTime(0L)
                        .result(null)
                        .build()
        );
    }
}
