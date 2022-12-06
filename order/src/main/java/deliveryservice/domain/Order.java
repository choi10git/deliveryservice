package deliveryservice.domain;

import deliveryservice.domain.OrderPlaced;
import deliveryservice.domain.OrderCompleted;
import deliveryservice.domain.OrderCancelled;
import deliveryservice.domain.StoreRejected;
import deliveryservice.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private Double pay;
    
    
    
    
    
    private Boolean payStatus;
    
    
    
    
    
    private Long foodId;
    
    
    
    
    
    private Long qty;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        deliveryservice.external.PayCommand payCommand = new deliveryservice.external.PayCommand();
        // mappings goes here
        OrderApplication.applicationContext.getBean(deliveryservice.external.PaymentsService.class)
            .pay(/* get???(), */ payCommand);



        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        OrderCompleted orderCompleted = new OrderCompleted(this);
        orderCompleted.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){


        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();



        StoreRejected storeRejected = new StoreRejected(this);
        storeRejected.publishAfterCommit();

    }
    @PreRemove
    public void onPreRemove(){
        // Get request from Store
        //deliveryservice.external.Store store =
        //    Application.applicationContext.getBean(deliveryservice.external.StoreService.class)
        //    .getStore(/** mapping value needed */);

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void storeReject(CookRejected cookRejected){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        StoreRejected storeRejected = new StoreRejected(order);
        storeRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookRejected.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            StoreRejected storeRejected = new StoreRejected(order);
            storeRejected.publishAfterCommit();

         });
        */

        
    }


}
