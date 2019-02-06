package absb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




/**
 * Created by supriyagadigone on 2019-01-29.
 */
@Controller
public class AddressBookControllerUI {

    private AddressBook a;
    public AddressBookControllerUI(){
        a = new AddressBook();
        BuddyInfo b1 = new BuddyInfo("Chloe", "456");
        BuddyInfo b2 = new BuddyInfo("Kim", "789");
        BuddyInfo b3 = new BuddyInfo("Kim", "789");
        a.addBuddy(b1);
        a.addBuddy(b2);
        a.addBuddy(b3);
    }


    @GetMapping("/addressbookui")
    public String greetingForm(Model model) {
        model.addAttribute("addressbookui", a);
        return "addressbookui";
    }
}
