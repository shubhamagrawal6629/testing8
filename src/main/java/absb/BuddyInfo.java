package absb;

import javax.persistence.*;


/**
 * Created by supriyagadigone on 2019-01-08.
 */
@Entity
@Table(name = "buddyinfo")
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "addressbook_id")
    private AddressBook ab;

    private String name;
    private int phoneNumber;


    private String phoneNum;

    public BuddyInfo(String n, int p) {
        this.name = n;
        this.phoneNumber = p;
    }

    public BuddyInfo(String n, String p) {
        this.name = n;
        this.phoneNum = p;
    }

    public BuddyInfo() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddressBook getAb() {
        return ab;
    }

    public void setAb(AddressBook ab) {
        this.ab = ab;
    }


    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%d']",
                id, name, phoneNumber);
    }

}
