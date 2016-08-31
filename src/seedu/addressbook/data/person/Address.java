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

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    
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
        String[] AddressComponents = splitAddress();
        block = new Block(AddressComponents[0]);
        street = new Street(AddressComponents[1]);
        unit = new Unit(AddressComponents[2]);
        postalCode = new PostalCode(AddressComponents[3]);
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
    
    class Block {
        private String blockNumber;
        public Block(String block) {
            blockNumber = block;
        }
        public void setBlockNumber(String blockNo) {
           blockNumber = blockNo;
        }
        @Override
        public String toString() {
            return blockNumber;
        }
        public String getBlockNumber() {
            return toString();
        }
    }
    
    class Street {
        private String streetName;
        
        public Street(String street) {
            streetName = street;
        }
        public void setStreetName(String street) {
            streetName = street;
        }
        
        @Override
        public String toString() {
            return streetName;
            
        }
        public String getStreetName() {
            return toString();
        }
        
    }
    public class Unit {
        private String unitNumber;
        
        public Unit(String unit) {
            unitNumber = unit;
        }
        public void setUnitNumber(String unitNo) {
            unitNumber = unitNo;
        }
        
        @Override
        public String toString() {
            return unitNumber;
        }
        public String getUnitNumber() {
            return toString();
        }
        
    }
    public class PostalCode {
        private String postalCode;
        
        public PostalCode(String pin) {
            postalCode = pin;
        }
        
        public void setPostalCode(String pin) {
            postalCode = pin;
        }
        
        @Override
        public String toString() {
            return postalCode;
        }
        public String getPostalCode() {
            return toString();
        }
    }
    public String joinAddress() {
        String[] alist = {block.getBlockNumber(),street.getStreetName(),unit.getUnitNumber(),postalCode.getPostalCode()};
        return String.join(",",alist);
        // using string builder
        // using string concatenation
    }
}