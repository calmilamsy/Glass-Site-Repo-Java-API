package net.glasslauncher.repo.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import net.glasslauncher.common.LoggerFactory;
import net.glasslauncher.repo.api.mod.jsonobj.OtherMod;
import net.glasslauncher.repo.api.mod.jsonobj.typeadapter.AdapterOtherMod;

import java.util.logging.Logger;

public class RepoConfig {
    public static String REPOSITORY_URL = "https://glass-repo.net/repo/";
    public static String API_URL = REPOSITORY_URL + "api/";
    public static Gson GSON;

    @Getter
    private static Logger logger = LoggerFactory.makeLogger("GlassRepoAPI", "glass-site-api");

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(OtherMod.class, new AdapterOtherMod());
        GSON = gsonBuilder.create();
    }
}
