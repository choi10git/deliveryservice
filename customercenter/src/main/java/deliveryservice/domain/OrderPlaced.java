package deliveryservice.domain;

import deliveryservice.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String status;
    private String address;
    private Double pay;
    private Boolean payStatus;
    private Long foodId;
    private Long qty;
}
