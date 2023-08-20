package io.github.MatheusFSantos.Kernel.KNUsers.model.util.converter;

public class NicknameConverter {

    public static String convert(String nickname) {
        StringBuilder readyToSaveNickname = new StringBuilder();

        if(!nickname.substring(0, 1).equals("@"))
            return readyToSaveNickname.append("@").append(nickname).toString();

        return readyToSaveNickname.append(nickname).toString();
    }

}
