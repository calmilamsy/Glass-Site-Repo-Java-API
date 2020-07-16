package net.glasslauncher.repo.api.mod.jsonobj;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ModPreview {

    /**
     * The mod ID for use in URLs.
     */
    private String id;

    /**
     * The mod display name.
     */
    private String name;

    /**
     * The plain-text short description for the mod.
     */
    @SerializedName("short_description")
    private String shortDescription;

    /**
     * The latest version ID for the mod.
     */
    @SerializedName("version_latest")
    private String latestVersion;

    /**
     * The Minecraft versions supported by the mod.
     */
    @SerializedName("minecraft_versions")
    private String[] minecraftVersions;

    /**
     * The classes edited by the mod.
     * These are user-defined out and may be inaccurate.
     * This field is for at-a-glance compatibility checking for the user.
     * Do not use this to check compatibility for mods.
     * It is recommended to scan the zip/jar files of mods to see if they are incompatible instead.
     */
    @SerializedName("edited_classes")
    private String[] editedClasses;

    /**
     * Tags for searching mods.
     * User defined, so typos or non-standard names may exist.
     */
    private String[] tags;

    /**
     * The types that the mod matches.
     * These are for defining if a mod supports ModLoader, Forge, Bukkit, etc.
     * @see ModValues
     */
    private String[] types;

    /**
     * The categories that the mod matches.
     * These are broad site-defined categories for what kind of content a mod adds.
     * @see ModValues
     */
    private String[] categories;

    /**
     * Mods that are required.
     * These are user-defined and may be inaccurate.
     * @see OtherMod
     */
    private OtherMod[] dependencies;

    /**
     * Mods that are either recommended or supported.
     * These are user-defined and may be inaccurate.
     * @see OtherMod
     */
    @SerializedName("optional_dependencies")
    private OtherMod[] optionalDependencies;

    /**
     * Mods that are incompatible and either can't be used at all, or may cause incorrect behaviour.
     * These are user-defined and may be inaccurate.
     * @see OtherMod
     */
    @SerializedName("incompatible_mods")
    private OtherMod[] incompatibleMods;
}
