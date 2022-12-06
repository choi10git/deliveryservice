package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class StoreRejected extends AbstractEvent {

    private Long id;
    private String status;
    private String address;
    private Double pay;
    private Boolean payStatus;
    private Long foodId;
    private Long qty;

    public StoreRejected(Order aggregate){
        super(aggregate);
    }
    public StoreRejected(){
        super();
    }
}
