package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String status;

    public DeliveryStarted(Rider aggregate){
        super(aggregate);
    }
    public DeliveryStarted(){
        super();
    }
}
