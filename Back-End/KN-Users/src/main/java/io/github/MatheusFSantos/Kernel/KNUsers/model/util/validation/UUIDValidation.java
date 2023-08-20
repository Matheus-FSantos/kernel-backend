package io.github.MatheusFSantos.Kernel.KNUsers.model.util.validation;

import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific.UUIDNotValid;
import org.apache.http.HttpStatus;

public class UUIDValidation {

    public static void isValidUUID(String id) throws UsersException {
        String regex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
        if(!id.matches(regex))
            throw new UUIDNotValid("Identifier invalid", "The entered identifier does not follow the standards required by the system", HttpStatus.SC_BAD_REQUEST);
    }

}
