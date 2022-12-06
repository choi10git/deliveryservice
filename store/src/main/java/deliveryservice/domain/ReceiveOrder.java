package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReceiveOrder extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String status;
    private Long qty;
    private Boolean accepte;
    private String payStatus;

    public ReceiveOrder(Store aggregate){
        super(aggregate);
    }
    public ReceiveOrder(){
        super();
    }
}
