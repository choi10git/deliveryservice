package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryFinished extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String status;

    public DeliveryFinished(Rider aggregate){
        super(aggregate);
    }
    public DeliveryFinished(){
        super();
    }
}
