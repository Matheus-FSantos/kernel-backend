package io.github.MatheusFSantos.Kernel.KNUsers.model.util.validation;

import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO.UsersDTO;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific.UserInvalidFields;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class UsersValidations {

    public static void validation(UsersDTO usersDTO) throws UsersException {
        List<String> exceptionMessages = new ArrayList<String>();

        UsersValidations.regexName(exceptionMessages, usersDTO.getName());
        UsersValidations.regexNickname(exceptionMessages, usersDTO.getNickname());
        UsersValidations.regexEmail(exceptionMessages, usersDTO.getEmail());
        UsersValidations.regexPassword(exceptionMessages, usersDTO.getPassword());
        UsersValidations.locationValidation(exceptionMessages, usersDTO);
        UsersValidations.biographyValidation(exceptionMessages, usersDTO);

        if(!exceptionMessages.isEmpty())
            throw new UserInvalidFields(exceptionMessages, "When filling out the form, the user entered some invalid data, all of which are listed above.", HttpStatus.SC_CONFLICT);
    }

    public static void regexName(List<String> exceptionMessages, String name) {
        String regex = "^[A-Za-z]+\\s[A-Za-z]+$";

        if(name.length() <= 4 || name.length() > 60)
            exceptionMessages.add("The name is outside accepted standards, it must contain between 4 and 30 characters.");
        else if(!name.matches(regex))
            exceptionMessages.add("The name is outside accepted standards, it must contain at least one uppercase character and only first and last name (separated by a single space).");
    }

    public static void regexNickname(List<String> exceptionMessages, String nickname) {
        String regex = "^[a-zA-Z0-9._]+$";

        if(nickname.length() <= 4 || nickname.length() > 30)
            exceptionMessages.add("The nickname is outside accepted standards, it must contain between 4 and 30 characters.");
        else if(!nickname.matches(regex))
            exceptionMessages.add("The nickname is outside accepted standards, it must contain characters (upper and lower case), numbers, periods and/or underscores.");
    }

    public static void regexEmail(List<String> exceptionMessages, String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        if(email.length() <= 4 || email.length() > 60)
            exceptionMessages.add("The e-mail is outside accepted standards, it must contain between 4 and 60 characters.");
        else if(!email.matches(regex))
             exceptionMessages.add("The e-mail is invalid.");
    }

    public static void regexPassword(List<String> exceptionMessages, String password) {
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";

        if(password.length() < 8 || password.length() > 25)
            exceptionMessages.add("The password is outside accepted standards, it must contain between 8 and 25 characters.");
        else if(!password.matches(regex))
            exceptionMessages.add("The password is outside accepted standards, it must contain at least one capital letter, one digit and/or at least 8 characters");
    }

    public static void locationValidation(List<String> exceptionMessages, UsersDTO usersDTO) {
        if(usersDTO.getLocation() == null)
            usersDTO.setLocation("");
        else if(usersDTO.getLocation().length() > 30)
            exceptionMessages.add("The location is outside accepted standards, it must contain be up 30 characters.");
    }

    public static void biographyValidation(List<String> exceptionMessages, UsersDTO usersDTO) {
        if(usersDTO.getBiography() == null)
            usersDTO.setBiography("");
        else if(usersDTO.getBiography().length() > 160)
            exceptionMessages.add("The biography is outside accepted standards, it must contain be up 160 characters.");
    }


}
