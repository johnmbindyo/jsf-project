/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jsfform.validators;

import java.util.Calendar;
import static java.util.Calendar.YEAR;
import java.util.Date;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author hp
 */
@FacesValidator(value = "age.validator")
public class AgeValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object object) throws ValidatorException {
        FacesMessage message = null;
        Date dob = (Date) object;
        int dobYear = getCalendar(dob).get(YEAR);
        int currentYear = getCalendar(new Date(System.currentTimeMillis())).get(YEAR);

        boolean invalidAge = false;
        try {
            int age = currentYear - dobYear;
            if (age < 10) {
                message = new FacesMessage("Too young for our school.Min admission age is 10 years");
                invalidAge = true;
            } else if (age > 18) {
                message = new FacesMessage("Above age for our school.Max admission age is 18 years");
                invalidAge = true;
            }
            if (invalidAge) {
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        } catch (Exception ex) {
            throw new ValidatorException(new FacesMessage(ex.getMessage()));
        }
    }

    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

}
