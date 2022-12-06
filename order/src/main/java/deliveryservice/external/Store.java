package deliveryservice.external;

import lombok.Data;
import java.util.Date;
@Data
public class Store {

    private Long id;
    private Long orderId;
    private String address;
    private String status;
    private Long qty;
    private Boolean accepte;
    private String payStatus;
}


