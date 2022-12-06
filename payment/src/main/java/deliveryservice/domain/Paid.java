package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;
    private Double pay;

    public Paid(Payments aggregate){
        super(aggregate);
    }
    public Paid(){
        super();
    }
}
