package io.github.MatheusFSantos.Kernel.KNUsers.model.util.cryptography.algorithms;

import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.BusinessCritical;
import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.Cryptography;
import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.InternalUseOnly;

import static java.util.Base64.*;

@InternalUseOnly
@BusinessCritical
public class Base64 {

    @Cryptography(encodeMethod=true)
    public static String encoder(String decryptedString) {
        return new String(getEncoder().encode(decryptedString.getBytes()));
    }

    @Cryptography(decodeMethod=true)
    public static String decode(String encryptedString) {
        return new String(getDecoder().decode(encryptedString.getBytes()));
    }

}
