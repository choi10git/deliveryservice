package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String status;
    private Long qty;
    private Boolean accepted;

    public CookStarted(Store aggregate){
        super(aggregate);
    }
    public CookStarted(){
        super();
    }
}
