package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "ADDRESS should be in the format a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = address;
    }
    public String[] splitAddress() {
        String[] addressSplit = value.split(",");
        return addressSplit;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        //return value;
        return joinAddress();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    public class Block {
        private String blockNumber;
        public void setBlockNumber() {
           blockNumber = splitAddress()[0]; 
        }
        public String getBlockNumber() {
            return blockNumber;
        }
    }
    public class Street {
        private String streetName;
        public void setStreetName() {
            streetName = splitAddress()[1];
        }
        public String getStreetName() {
            return streetName;
        }
        
    }
    public class Unit {
        private String unitNumber;
        public void setUnitNumber() {
            unitNumber = splitAddress()[2];
        }
        public String getUnitNumber() {
            return unitNumber;
        }
        
    }
    public class PostalCode {
        private String postalCode;
        public void setPostalCode() {
            postalCode = splitAddress()[3];
        }
        public String getPostalCode() {
            return postalCode;
        }
    }
    public String joinAddress() {
        Block b = new Block();
        b.setBlockNumber();
        Street s = new Street();
        s.setStreetName();
        Unit u = new Unit();
        u.setUnitNumber();
        PostalCode pc = new PostalCode();
        pc.setPostalCode();
        String[] alist = {b.getBlockNumber(),s.getStreetName(),u.getUnitNumber(),pc.getPostalCode()};
        return String.join(",",alist);
    }
}