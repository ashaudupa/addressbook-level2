package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class SortCommand extends Command {
    private PersonComparator comparator = new PersonComparator();
    
    public static final String COMMAND_WORD = "sort";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays Sorted AddressBook\n"
            + "Example: " + COMMAND_WORD;
    public ArrayList<Person> sortingPersonList(ArrayList<Person> personList) {
        Collections.sort(personList,comparator);
        return personList;
    }
    
    @Override
    public CommandResult execute() {
        ArrayList<Person> personList = new ArrayList<Person>();
        List<ReadOnlyPerson> allPerson = addressBook.getAllPersons().immutableListView();
        for (ReadOnlyPerson p: allPerson){
            personList.add((Person)p);
        }
        ArrayList<Person> sortedList = sortingPersonList(personList);
        return new CommandResult(getMessageForPersonListShownSummary(sortedList),sortedList);
    }
    


}
