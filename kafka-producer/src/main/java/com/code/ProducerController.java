package com.code;

import com.code.vo.Message;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public Message push(@RequestBody Message message){
        // 'topic, data' or topic, key, data
        kafkaTemplate.send(message.getTopic(), message.getKey(), message.getData());
        return message;
    }

}
