package deliveryservice.domain;

import deliveryservice.domain.Paid;
import deliveryservice.PaymentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Payments_table")
@Data

public class Payments  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Double pay;

    @PostPersist
    public void onPostPersist(){


        Paid paid = new Paid(this);
        paid.publishAfterCommit();

    }

    public static PaymentsRepository repository(){
        PaymentsRepository paymentsRepository = PaymentApplication.applicationContext.getBean(PaymentsRepository.class);
        return paymentsRepository;
    }



    public void pay(PayCommand payCommand){
    }



}
