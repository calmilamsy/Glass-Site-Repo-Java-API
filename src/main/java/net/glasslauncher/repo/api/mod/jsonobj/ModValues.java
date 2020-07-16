package net.glasslauncher.repo.api.mod.jsonobj;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class ModValues {

    /**
     * Valid types. May change.
     */
    private String[] types;

    /**
     * Valid categories. May change.
     */
    private String[] categories;

    /**
     * Valid Minecraft versions. May change.
     */
    @SerializedName("minecraft_versions")
    private String[] minecraftVersions;
}
