package org.soraworld.randstruct.nbt;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class NBTUtilsTest {

    @Test
    public void readCompressed() {
        try {
            NBTTagCompound tag = NBTUtils.readCompressed(new FileInputStream("./test.schematic"));
            System.out.println(tag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}