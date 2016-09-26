package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.tag.UniqueTagList;

public class UtilsTest {
    private Person person1;
    private Person person2;
    private Name person1Name;
    private Name person2Name;
    private Email person1Email;
    private Email person2Email;
    private Phone person1Phone;
    private Phone person2Phone;
    private Address person1Address;
    private Address person2Address;
    private Name nullName;
    private Email nullEmail;
    private Phone nullPhone;
    private Address nullAddress;
    
    @Before
    public void setup() throws IllegalValueException {
        person1Name = new Name("Test person one");
        person2Name = new Name("Test person two");
        person1Phone = new Phone("34568732",false);
        person2Phone = new Phone("22334455",true);
        person1Email = new Email("abc@gmail.com",false);
        person2Email = new Email("cbd@gmail.com",true);
        person1Address = new Address("1 clementi,#02-43,223344",false);
        person2Address = new Address("2 bukit,#09-345,554477",true);
        person1 = new Person(person1Name,person1Phone,person1Email,person1Address,new UniqueTagList());
        person2 = new Person(person2Name, person2Phone, person2Email, person2Address, new UniqueTagList());
        
    }
    
    @Test
    public void isAnyNull_AllNull_Returns_True() {
        assertTrue(Utils.isAnyNull(nullName,nullPhone,nullEmail,nullAddress));
        
    }
    
    @Test
    public void isAnyNull_NoNull_Returns_False() {
        assertFalse(Utils.isAnyNull(person1, person2Email));
        
    }
    
    @Test
    public void isAnyNull_oneNull_Returns_True() {
        assertTrue(Utils.isAnyNull(person1,person2,nullName));
        
    }
    
    @Test 
    public void isAnyNull_noObject_false_Returned() {
        assertFalse(Utils.isAnyNull());
    }
    
    @Test
    public void elementsAreUnique_duplicateValues_falseReturned() {
        ArrayList <Person> personList = new ArrayList<Person>();
        personList.add(person1);
        personList.add(person1);
        assertFalse(Utils.elementsAreUnique(personList));
        personList.add(person2);
        assertFalse(Utils.elementsAreUnique(personList));
    }
    
    @Test
    public void elementsAreUnique_nonRepeatedValues_TrueReturned() {
        ArrayList <Person> personList = new ArrayList<Person>();
        personList.add(person1);
        personList.add(person2);
        assertTrue(Utils.elementsAreUnique(personList));
    }
    
    @Test
    public void elementsAreUnique_EmptyList_TrueReturned() {
        ArrayList <Person> personList = new ArrayList<Person>();
        assertTrue(Utils.elementsAreUnique(personList));
    }

}
