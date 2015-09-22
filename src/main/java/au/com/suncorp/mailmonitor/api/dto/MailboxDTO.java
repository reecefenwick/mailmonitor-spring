package au.com.suncorp.mailmonitor.api.dto;


import javax.validation.constraints.Size;

public class MailboxDTO {

    @Size(max = 50)
    private String description;

    @Size(max = 50)
    private String username;

    @Size(max = 50)
    private String password;

    @Size(max = 50)
    private String alertRecipient;

    private Boolean active;

    public MailboxDTO() {
    }

    public MailboxDTO(String description, String username, String password, String alertRecipient, Boolean active) {
        this.description = description;
        this.username = username;
        this.password = password;
        this.alertRecipient = alertRecipient;
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlertRecipient() {
        return alertRecipient;
    }

    public void setAlertRecipient(String alertRecipient) {
        this.alertRecipient = alertRecipient;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

