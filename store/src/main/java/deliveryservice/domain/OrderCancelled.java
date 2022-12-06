package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private String status;
    private String address;
    private Double pay;
    private Boolean payStatus;
    private Long foodId;
    private Long qty;
}


