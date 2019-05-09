package org.soraworld.randstruct.data;

import org.bukkit.Location;

import java.io.File;

public class Schematic {

    public Schematic(File file) {

    }

    public void paste(Location location) {

    }

    public static Schematic read(File file) {
        return new Schematic(file);
    }

}
