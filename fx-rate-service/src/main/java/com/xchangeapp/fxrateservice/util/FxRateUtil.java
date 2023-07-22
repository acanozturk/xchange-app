package com.xchangeapp.fxrateservice.util;

import com.google.gson.JsonObject;
import lombok.experimental.UtilityClass;

import java.util.Set;

@UtilityClass
public class FxRateUtil {

    private final Set<String> FIELDS_TO_REMOVE = Set.of(
            "result",
            "documentation",
            "terms_of_use",
            "time_last_update_unix",
            "time_next_update_unix"
    );
    
    public JsonObject removeUnnecessaryFields(JsonObject jsonObject) {
        FIELDS_TO_REMOVE.forEach(jsonObject::remove);
        return jsonObject;
    }
    
}
