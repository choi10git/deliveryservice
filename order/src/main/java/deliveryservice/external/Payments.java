package deliveryservice.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payments {

    private Long orderId;
    private String status;
    private Double pay;
}


