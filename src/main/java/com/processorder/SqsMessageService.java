package com.processorder;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.processorder.controller.OrderProcessController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageService {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;
    private static final Logger logger = LoggerFactory.getLogger(SqsMessageService.class);
    @Value("${cloud.aws.fila.order_process}")
    private String queueName;

    public void sendMessage(String message){

        logger.info("SQS Queue - name {}",queueName);
        logger.info("SQS Queue - message {}",message);

        queueMessagingTemplate.send(queueName, MessageBuilder.withPayload(message).build());

    }

}
