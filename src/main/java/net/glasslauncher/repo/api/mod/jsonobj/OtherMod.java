package net.glasslauncher.repo.api.mod.jsonobj;

import lombok.Getter;
import net.glasslauncher.repo.api.RepoConfig;
import net.glasslauncher.repo.api.Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * JSON Object for other mods that are referenced as dependencies, incompatible, etc. by other mods.
 */
@Getter
public class OtherMod {
    private String name;
    /** Null if no valid url found. */
    private URL url;
    /** Null if not a repo URL. */
    private String id;

    /**
     * @param unifiedString Unified string to convert to OtherMod JSON object.
     * @throws MalformedURLException Thrown if URL on a unified string with a URL specified is not valid.
     */
    public OtherMod(String unifiedString) throws MalformedURLException {
        Map<String, Object> otherMod = Util.convertUnified(unifiedString);
        this.name = (String) otherMod.get("name");
        this.url = (URL) otherMod.get("url");
        this.id = (String) otherMod.get("id");
    }

    /**
     * @param name The name of the other mod.
     * @param url The URL of the other mod.
     */
    public OtherMod(String name, URL url) {
        this.name = name;
        this.url = url;
    }

    /**
     * Returns if the URL can be used to automatically download mods.
     * @return True if the URL can be downloaded from glass-site automatically, false if it cannot.
     */
    public boolean isRepoURL() {
        return id != null;
    }

    /**
     * Gets the full mod info from glass-site if possible.
     * @return Returns null if the mod URL is not a repo URL or cannot be found.
     */
    public Mod getModInfo() {
        RepoConfig.getLogger().info("Retrieving mod info for " + name + "...");
        return RepoConfig.GSON.fromJson(RepoConfig.API_URL + "mod/" + name, Mod.class);
    }
}
