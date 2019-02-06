package absb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by supriyagadigone on 2019-01-29.
 */
@RestController
public class AddressBookController {

    @Autowired
    BuddyInfoRepository repository;


    private AddressBook a;
    private final AtomicInteger counter = new AtomicInteger();
    public AddressBookController(){
        a = new AddressBook();
    }


    @RequestMapping(value = "/addressbook", method = RequestMethod.GET)
    public AddressBook addressbook() {
        return a;
    }

    //@RequestMapping(value = "/addressbook", method = RequestMethod.PUT)
   // public AddressBook addressbookput(@RequestParam(value="name") String name, @RequestParam(value="phoneNum") String phoneNum, @RequestBody BuddyInfo b) {

    @RequestMapping(value = "/addressbook", method = RequestMethod.POST)
    public AddressBook addressbookput(@RequestBody BuddyInfo b) {
        b.setId(counter.incrementAndGet());
        a.addBuddy(b);
        repository.save(b);
        return a;
    }

    @RequestMapping(value = "/addressbook{index}", method = RequestMethod.DELETE)
   public AddressBook addressbookdelete(@PathVariable("index") int index) {
        a.removeBuddy(index);
        return a;
    }

    @RequestMapping(value = "/addressbook", method = RequestMethod.DELETE)
    public AddressBook addressbookdelete(@RequestParam("name") String name) {
        BuddyInfo b = repository.findByName(name).get(0);
        repository.delete(b);
        a.removeBuddy(b.getId()-1);
        return a;
    }


}
