package deliveryservice.infra;
import deliveryservice.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/payments")
@Transactional
public class PaymentsController {
    @Autowired
    PaymentsRepository paymentsRepository;



    @RequestMapping(value = "payments/{id}/pay",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Payments pay(@PathVariable(value = "id") Long id, @RequestBody PayCommand payCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /payments/pay  called #####");
            Optional<Payments> optionalPayments = paymentsRepository.findById(id);
            
            optionalPayments.orElseThrow(()-> new Exception("No Entity Found"));
            Payments payments = optionalPayments.get();
            payments.pay(payCommand);
            
            paymentsRepository.save(payments);
            return payments;
            
    }
    



}
