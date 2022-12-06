package deliveryservice.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import deliveryservice.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import deliveryservice.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired RiderRepository riderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookCompleted'")
    public void wheneverCookCompleted_StartDelivery(@Payload CookCompleted cookCompleted){

        CookCompleted event = cookCompleted;
        System.out.println("\n\n##### listener StartDelivery : " + cookCompleted + "\n\n");


        

        // Sample Logic //
        Rider.startDelivery(event);
        

        

    }

}


