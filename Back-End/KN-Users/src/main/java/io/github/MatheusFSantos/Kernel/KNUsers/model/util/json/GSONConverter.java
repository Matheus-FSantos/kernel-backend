package io.github.MatheusFSantos.Kernel.KNUsers.model.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.MatheusFSantos.Kernel.KNUsers.model.adapter.LocalDateTimeTypeAdapter;
import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.BusinessCritical;
import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.InternalUseOnly;
import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO.UsersBackupDTO;

import java.time.LocalDateTime;

@InternalUseOnly
@BusinessCritical
public class GSONConverter {

    private final Gson gson;

    public GSONConverter() {
        this.gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter()).create();
    }

    public String serializable(UsersBackupDTO userBackupDTO) {
        return this.getGson().toJson(userBackupDTO);
    }

    public UsersBackupDTO deserializable(String json) {
        return this.getGson().fromJson(json, UsersBackupDTO.class);
    }

    public Gson getGson() {
        return this.gson;
    }

}
