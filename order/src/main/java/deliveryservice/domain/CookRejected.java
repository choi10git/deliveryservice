package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CookRejected extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String status;
    private Long qty;
    private Boolean accepted;
}


