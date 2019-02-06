package absb;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by supriyagadigone on 2019-01-22.
 */
public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {
    List<AddressBook> findById(int id);
}
