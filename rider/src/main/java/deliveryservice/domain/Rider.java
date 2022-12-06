package deliveryservice.domain;

import deliveryservice.domain.DeliveryStarted;
import deliveryservice.domain.DeliveryFinished;
import deliveryservice.RiderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Rider_table")
@Data

public class Rider  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();



        DeliveryFinished deliveryFinished = new DeliveryFinished(this);
        deliveryFinished.publishAfterCommit();

    }

    public static RiderRepository repository(){
        RiderRepository riderRepository = RiderApplication.applicationContext.getBean(RiderRepository.class);
        return riderRepository;
    }




    public static void startDelivery(CookCompleted cookCompleted){

        /** Example 1:  new item 
        Rider rider = new Rider();
        repository().save(rider);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookCompleted.get???()).ifPresent(rider->{
            
            rider // do something
            repository().save(rider);


         });
        */

        
    }


}
