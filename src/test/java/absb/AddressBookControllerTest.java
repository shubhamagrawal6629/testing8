package absb;

import absb.AddressBook;
import absb.AddressBookController;
import absb.Application;
import absb.BuddyInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by supriyagadigone on 2019-02-06.
 */
@RunWith(SpringRunner.class)
@SpringBootTest (classes = Application.class)
public class AddressBookControllerTest {

    @Autowired
    private AddressBookController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void addBuddyTest(){
        AddressBook a  = new AddressBook();
        BuddyInfo b = new BuddyInfo("Sam", "123");
        a.addBuddy(b);
        assertEquals(1, a.size());
    }
}
