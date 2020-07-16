package net.glasslauncher.repo.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import net.glasslauncher.common.CommonConfig;
import net.glasslauncher.repo.api.mod.jsonobj.OtherMod;
import net.glasslauncher.repo.api.mod.jsonobj.typeadapter.AdapterOtherMod;

import java.util.logging.Logger;

public class Config {
    public static String REPOSITORY_URL = "https://glass-launcher.net/repo/";
    public static String API_URL = REPOSITORY_URL + "api/";
    public static Gson GSON;

    @Getter
    private static Logger logger = CommonConfig.makeLogger("GlassAPI", "glass-site-api");

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(OtherMod.class, new AdapterOtherMod());
        GSON = gsonBuilder.create();
    }
}
