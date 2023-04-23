package com.processorder.controller;


import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.processorder.SqsMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-process")
public class OrderProcessController {

    @Autowired
    private SqsMessageService service;

    @PostMapping
    public ResponseEntity<String> consultaCartaoCredito(@RequestBody String message){

        service.sendMessage(message);

        return ResponseEntity.ok("Order send with success");
    }


}
