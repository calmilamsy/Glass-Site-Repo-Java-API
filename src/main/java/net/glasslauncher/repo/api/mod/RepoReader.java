package net.glasslauncher.repo.api.mod;

import net.glasslauncher.common.FileUtils;
import net.glasslauncher.repo.api.RepoConfig;
import net.glasslauncher.repo.api.mod.jsonobj.Mod;
import net.glasslauncher.repo.api.mod.jsonobj.ModPreview;
import net.glasslauncher.repo.api.mod.jsonobj.ModValues;
import net.glasslauncher.repo.api.mod.jsonobj.Version;

import java.io.IOException;
import java.net.URL;

public class RepoReader {

    /**
     * Gets the public mod list.
     * @return The public mod list as a ModPreview array.
     * @throws IOException Thrown when something goes wrong with retrieving the mod list.
     * @see ModPreview
     */
    public static ModPreview[] getMods() throws IOException {
        RepoConfig.getLogger().info("Retrieving public mod list...");
        return RepoConfig.GSON.fromJson(FileUtils.convertStreamToString(new URL(RepoConfig.API_URL + "mods").openStream()), ModPreview[].class);
    }

    /**
     * Gets the public information for the mod, its latest version and its owners.
     * @param modId The ID of the mod.
     * @return A Mod object containing the mod information.
     * @throws IOException Thrown when something goes wrong with retrieving the mod information.
     * @see Mod
     */
    public static Mod getMod(String modId) throws IOException {
        RepoConfig.getLogger().info("Retrieving mod info for " + modId + "...");
        return RepoConfig.GSON.fromJson(FileUtils.convertStreamToString(new URL(RepoConfig.API_URL + "mod/" + modId).openStream()), Mod.class);
    }

    /**
     * Gets the public information for the mod version.
     * @param modId The ID of the mod.
     * @param versionId The ID of the version.
     * @return A Version object containing the version information.
     * @throws IOException Thrown when something goes wrong with retrieving the mod version information.
     * @see Version
     */
    public static Version getVersion(String modId, String versionId) throws IOException {
        RepoConfig.getLogger().info("Retrieving version info for " + modId + "/" + versionId + "...");
        return RepoConfig.GSON.fromJson(FileUtils.convertStreamToString(new URL(RepoConfig.API_URL + "mod/" + modId + "/versions/" + versionId).openStream()), Version.class);
    }

    /**
     * Gets the valid types for certain fields. Recommended if incorporating a search function.
     * @return A ModValues object containing valid mod values.
     * @throws IOException Thrown when something goes wrong with retrieving the valid mod values.
     */
    public static ModValues getValidValues() throws IOException {
        RepoConfig.getLogger().info("Retrieving valid mod values...");
        return RepoConfig.GSON.fromJson(FileUtils.convertStreamToString(new URL(RepoConfig.API_URL + "validmodvalues").openStream()), ModValues.class);
    }
}
