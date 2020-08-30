package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

   // @Value("${kafka.topic.name")
    private String topicName="harshal";


    //synchronous publishing (i.e waits for acknowledgement before pushing next message.
    public void sendMessage(String msg) {

        kafkaTemplate.send(topicName, msg);
    }
}
