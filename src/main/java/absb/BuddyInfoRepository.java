package absb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by supriyagadigone on 2019-01-22.
 */
@RepositoryRestResource(collectionResourceRel = "buddies", path="buddies")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(@Param("name") String name);
    List<BuddyInfo> findById(@Param("id") int id);
}
