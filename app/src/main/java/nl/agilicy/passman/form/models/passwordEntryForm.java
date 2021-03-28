package nl.agilicy.passman.form.models;

import java.util.List;

public class passwordEntryForm {

    private Long directoryId;

    private String title;

    private List<String> passwordEntryValues;

    private List<String> passwordEntryFields;

    private List<String> passwordEntryTypes;

    public passwordEntryForm() {
        //
    }

    public passwordEntryForm(String title, List<String> passwordEntryFields, List<String> passwordEntryTypes) {
        this.title = title;
        this.passwordEntryFields = passwordEntryFields;
        this.passwordEntryTypes = passwordEntryTypes;
    }

    public Long getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(Long directoryId) {
        this.directoryId = directoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPasswordEntryValues() {
        return passwordEntryValues;
    }

    public void setPasswordEntryValues(List<String> passwordEntryValues) {
        this.passwordEntryValues = passwordEntryValues;
    }

    public List<String> getPasswordEntryFields() {
        return passwordEntryFields;
    }

    public void setPasswordEntryFields(List<String> passwordEntryFields) {
        this.passwordEntryFields = passwordEntryFields;
    }

    public List<String> getPasswordEntryTypes() {
        return passwordEntryTypes;
    }

    public void setPasswordEntryTypes(List<String> passwordEntryTypes) {
        this.passwordEntryTypes = passwordEntryTypes;
    }
}
