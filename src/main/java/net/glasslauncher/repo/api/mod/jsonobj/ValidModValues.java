package net.glasslauncher.repo.api.mod.jsonobj;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ValidModValues {

    @SerializedName("valid_values")
    private ModValues validValues;
}
