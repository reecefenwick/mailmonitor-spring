////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2015, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////

package au.com.suncorp.mailmonitor.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "MAILBOX")
public final class  Mailbox implements Serializable {

    @Id
    @NotNull
    @Size(min = 18)
    @Column(name = "ID")
    public String key;

    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "USERNAME")
    private String username;

    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "ALERT_RECIPIENT")
    private String alertRecipient;

    @NotNull
    private Boolean active;

    public Mailbox() { }

    public Mailbox(String description, String username, String password, String alertRecipient, Boolean active) {
        this.description = description;
        this.username = username;
        this.password = password;
        this.alertRecipient = alertRecipient;
        this.active = active;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
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
