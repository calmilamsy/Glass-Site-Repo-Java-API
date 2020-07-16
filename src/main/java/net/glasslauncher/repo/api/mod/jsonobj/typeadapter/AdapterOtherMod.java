package net.glasslauncher.repo.api.mod.jsonobj.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.glasslauncher.repo.api.Config;
import net.glasslauncher.repo.api.mod.jsonobj.OtherMod;

import java.io.IOException;

public class AdapterOtherMod extends TypeAdapter<OtherMod> {

    /**
     * Converts object to unified string.
     * @param out
     * @param value the Java object to write. Never null.
     */
    @Override
    public void write(JsonWriter out, OtherMod value) throws IOException {
        if (value.isRepoURL()) {
            out.value(value.getId() != null ? value.getId() + "|" + value.getName() : value.getName());
        } else {
            out.value(value.getUrl() != null ? value.getUrl() + "|" + value.getName() : value.getName());
        }
    }

    /**
     * Converts unified string to object.
     * @param in
     * @return the converted Java object. Never null.
     * @see OtherMod
     */
    @Override
    public OtherMod read(JsonReader in) throws IOException {
        String inputString = in.nextString();
        try {
            return new OtherMod(inputString);
        } catch (Exception e) {
            Config.getLogger().info("Caught error parsing unified string \"" + inputString + "\":");
            e.printStackTrace();
        }
        return null;
    }
}
