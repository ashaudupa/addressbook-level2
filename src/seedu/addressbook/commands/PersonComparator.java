package seedu.addressbook.commands;

import java.util.Comparator;

import seedu.addressbook.data.person.Person;

public class PersonComparator implements Comparator<Person>{
    @Override
    public int compare(Person person1,Person person2){
        return (person1.getName().toString()).compareTo(person2.getName().toString());
    }
    

}
