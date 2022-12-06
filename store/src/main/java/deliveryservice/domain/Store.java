package deliveryservice.domain;

import deliveryservice.domain.CookStarted;
import deliveryservice.domain.CookCompleted;
import deliveryservice.domain.CookRejected;
import deliveryservice.domain.ReceiveOrder;
import deliveryservice.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Store_table")
@Data

public class Store  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Long qty;
    
    
    
    
    
    private Boolean accepte;
    
    
    
    
    
    private String payStatus;

    @PostPersist
    public void onPostPersist(){


        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        CookCompleted cookCompleted = new CookCompleted(this);
        cookCompleted.publishAfterCommit();



        CookRejected cookRejected = new CookRejected(this);
        cookRejected.publishAfterCommit();



        ReceiveOrder receiveOrder = new ReceiveOrder(this);
        receiveOrder.publishAfterCommit();

    }

    public static StoreRepository repository(){
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(StoreRepository.class);
        return storeRepository;
    }




    public static void receipt(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

        
    }
    public static void cancel(OrderCancelled orderCancelled){

        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

        
    }
    public static void orderUpdate(Paid paid){

        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        ReceiveOrder receiveOrder = new ReceiveOrder(store);
        receiveOrder.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);

            ReceiveOrder receiveOrder = new ReceiveOrder(store);
            receiveOrder.publishAfterCommit();

         });
        */

        
    }


}
