/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jsfform;

import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author hp
 */
@Named(value = "admissionController")
@ViewScoped
public class AdmissionController implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    /**
     * Creates a new instance of AdmissionController
     */
    public AdmissionController() {
    }

    public void processForm() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            ctx.addMessage(null, new FacesMessage("Student admitted"));
        } catch (Exception ex) {
            ctx.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
