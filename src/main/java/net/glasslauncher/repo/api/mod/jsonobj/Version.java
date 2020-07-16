package net.glasslauncher.repo.api.mod.jsonobj;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import net.glasslauncher.repo.api.Config;
import org.intellij.lang.annotations.MagicConstant;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;

@Getter
public class Version {
    public static final String CLIENT = "client";
    public static final String SERVER = "server";
    public static final String BUKKIT = "bukkit";

    public static final String JAR = "jar";
    public static final String  ZIP = "zip";

    /**
     * The version ID for use in URLs.
     */
    private String version;

    /**
     * The markdown-formatted description of the version. GitHub flavoured.
     */
    private String description;

    /**
     * The type of the version.
     * @see ModValues
     */
    private String type;

    /**
     * The mod the version belongs to.
     * @see Mod
     */
    @SerializedName("parent_mod")
    private String parentMod;

    /**
     * A unix formatted timestamp.
     */
    private float timestamp;

    /**
     * The size of the file in bytes. Non-functional.
     */
    private long size;

    /**
     * The amount of times the mod version has been downloaded.
     */
    @SerializedName("download_count")
    private long downloadCount;

    /**
     * If the client file works on server, then this will be true.
     * Always false if client file does not exist or if server exists.
     */
    @SerializedName("is_client_server")
    private boolean isClientServer;

    /**
     * If there is a client file this will be true.
     */
    @SerializedName("has_client")
    private boolean hasClient;

    /**
     * If there is a server file this will be true.
     */
    @SerializedName("has_server")
    private boolean hasServer;

    /**
     * If there is a bukkit file this will be true.
     */
    @SerializedName("has_bukkit")
    private boolean hasBukkit;

    /**
     * Send a pull request to returned URL to get
     * @return A url that can be opened to get the version file.
     */
    public URL getDownloadURL(@MagicConstant(stringValues = {CLIENT, SERVER, BUKKIT}) String side, @MagicConstant(stringValues = {JAR, ZIP}) String type) throws MalformedURLException {
        if (!hasClient && side.equals(CLIENT))
            throw new InvalidParameterException("Asked for client file when there is no client file!");
        if (!hasServer && side.equals(SERVER))
            throw new InvalidParameterException("Asked for server file when there is no server file!");
        if (!hasBukkit && side.equals(BUKKIT))
            throw new InvalidParameterException("Asked for bukkit file when there is no bukkit file!");
        return new URL(Config.REPOSITORY_URL + "mod/" + parentMod + "/versions/" + version + "/download?type=" + type + "&side=" + side);
    }
}
