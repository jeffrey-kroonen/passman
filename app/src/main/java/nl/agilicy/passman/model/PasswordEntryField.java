package nl.agilicy.passman.model;

import java.util.UUID;

public class PasswordEntryField {
    enum DataType {
        STRING
    }

    private UUID id;

    private DataType datatype;
    
    private PasswordEntry password_entry;

    private String field_name;

    private int value;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DataType getDatatype() {
        return datatype;
    }

    public void setDatatype(DataType datatype) {
        this.datatype = datatype;
    }

    public PasswordEntry getPassword_entry() {
        return password_entry;
    }

    public void setPassword_entry(PasswordEntry password_entry) {
        this.password_entry = password_entry;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
