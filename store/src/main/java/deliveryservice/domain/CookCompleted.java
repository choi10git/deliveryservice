package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String status;
    private Long qty;
    private Boolean accepted;

    public CookCompleted(Store aggregate){
        super(aggregate);
    }
    public CookCompleted(){
        super();
    }
}
