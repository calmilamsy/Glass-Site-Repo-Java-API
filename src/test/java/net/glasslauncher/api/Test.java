package net.glasslauncher.api;

import net.glasslauncher.repo.api.RepoConfig;
import net.glasslauncher.repo.api.mod.RepoReader;
import net.glasslauncher.repo.api.mod.jsonobj.ModPreview;
import net.glasslauncher.repo.api.mod.jsonobj.Version;

import static net.glasslauncher.repo.api.mod.RepoReader.getMods;

public class Test {


    public static void main(String[] args) {
        RepoConfig.getLogger().info(RepoConfig.API_URL);
        try {
            ModPreview[] mods = getMods();
            System.out.println(RepoReader.getVersion("testmod", "1.0").getDownloadURL(Version.CLIENT, Version.ZIP));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
