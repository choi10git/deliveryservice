package deliveryservice.domain;

import deliveryservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="riders", path="riders")
public interface RiderRepository extends PagingAndSortingRepository<Rider, Long>{

}
