package net.glasslauncher.repo.api.mod.jsonobj;

import lombok.Getter;

@Getter
public class Author {

    /**
     * Avatar URL for the author. Suitable for being put in <img> tags.
     */
    private String avatar;

    /**
     * Numerical ID for the user.
     */
    private String id;

    /**
     * The display name of the user.
     */
    private String username;

    /**
     * The #0000 part after the user display name.
     */
    private String discriminator;

    /**
     * The site defined by the user. May not be a valid URL!
     */
    private String site;
}
