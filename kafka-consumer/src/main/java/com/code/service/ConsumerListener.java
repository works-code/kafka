package com.code.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerListener {

    @KafkaListener(topics = "topic-A", groupId = "group-01")
    public void consumerA(String data){
        log.info("## topic-A PULL => {}", data);
    }

    @KafkaListener(topics = "topic-B", groupId = "group-01")
    public void consumerB(String data){
        log.info("## topic-B PULL => {}", data);
    }

}
