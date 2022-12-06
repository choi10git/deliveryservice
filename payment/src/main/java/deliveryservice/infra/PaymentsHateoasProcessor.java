package deliveryservice.infra;
import deliveryservice.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class PaymentsHateoasProcessor implements RepresentationModelProcessor<EntityModel<Payments>>  {

    @Override
    public EntityModel<Payments> process(EntityModel<Payments> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/pay").withRel("pay"));

        
        return model;
    }
    
}
