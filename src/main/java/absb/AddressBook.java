package absb;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by supriyagadigone on 2019-01-08.
 */
@Entity
@Table(name="addressbook")
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String content;

    @OneToMany(mappedBy = "ab", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<BuddyInfo> buddyInfoObjects = new ArrayList<BuddyInfo>();


    public AddressBook(){}
    public AddressBook(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    /**
     * Add Buddy
     *
     * @param b
     */
    public void addBuddy(BuddyInfo b) {
        if (b != null) {
            buddyInfoObjects.add(b);
        }
    }

    /**
     * Remove Buddy
     *
     * @param index
     */
    public void removeBuddy(int index) {
        if (index >= 0 && index < buddyInfoObjects.size()) {
            buddyInfoObjects.remove(index);
        }
    }

    public int size() {
        return buddyInfoObjects.size();
    }

    public void clear() {
        buddyInfoObjects.clear();
    }

    public void printAddressBook() {
        for (int i = 0; i < buddyInfoObjects.size(); i++) {
            System.out.print(i + 1 + " Name: " + buddyInfoObjects.get(i).getName() + ", Number: " + buddyInfoObjects.get(i).getPhoneNumber() + "\n");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "AddressBook[id=%d]",
                id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BuddyInfo> getBuddyInfoObjects() {
        return buddyInfoObjects;
    }

    public void setBuddyInfoObjects(List<BuddyInfo> buddyInfoObjects) {
        this.buddyInfoObjects = buddyInfoObjects;
    }
//
//    public static void main(String[] args) {
//        AddressBook ab = new AddressBook();
//
//        BuddyInfo b1 = new BuddyInfo("Sam", 123);
//
//        BuddyInfo b2 = new BuddyInfo("Bob", 456);
//
//        BuddyInfo b3 = new BuddyInfo("John", 789);
//
//        ab.addBuddy(b1);
//        ab.addBuddy(b2);
//        ab.addBuddy(b3);
//
//        ab.printAddressBook();
//    }


}
