package org.soraworld.randstruct.data;

import org.bukkit.Location;
import org.soraworld.randstruct.nbt.NBTTagCompound;
import org.soraworld.randstruct.nbt.NBTUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Schematic {

    public Schematic(File file) {

    }

    public void paste(Location location) {

    }

    public void load(InputStream stream) throws IOException {

        NBTTagCompound nbt = NBTUtils.readCompressed(stream);


    }

    public static Schematic read(File file) {
        return new Schematic(file);
    }

}
