package net.glasslauncher.repo.api;

import org.apache.commons.validator.routines.UrlValidator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Util {

    /**
     * Converts a unified string to a map for use.
     * @param unifiedString Unified string to convert.
     * @return Map which contains a "url" (URL) and "name" (String)
     * @throws MalformedURLException If the URL specified by the unified string is invalid.
     */
    public static Map<String, Object> convertUnified(String unifiedString) throws MalformedURLException {
        HashMap<String, Object> otherMod = new HashMap<>();
        if (unifiedString.contains("|")) {
            String[] parts = unifiedString.split("\\|");
            if (parts[0].matches("^[0-9_a-z]{1,15}$")) {
                otherMod.put("url", new URL(Config.REPOSITORY_URL + "mod/" + parts[0]));
                otherMod.put("id", parts[0]);
            }
            else if (UrlValidator.getInstance().isValid(parts[0])) {
                otherMod.put("url", new URL(parts[0]));
                otherMod.put("id", null);
            }
            else {
                throw new MalformedURLException("Mod URL does not match a normal URL or shorthand repo URL. Did the mod author annotate wrong?");
            }
            otherMod.put("name", parts[1]);
        }
        else if (UrlValidator.getInstance().isValid(unifiedString)) {
            otherMod.put("name", unifiedString);
            otherMod.put("url", new URL(unifiedString));
            otherMod.put("id", null);
        }
        else {
            otherMod.put("name", unifiedString);
            otherMod.put("url", null);
            otherMod.put("id", null);
        }
        return otherMod;
    }
}
