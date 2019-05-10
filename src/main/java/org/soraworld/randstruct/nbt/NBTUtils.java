package org.soraworld.randstruct.nbt;

import javax.annotation.Nullable;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class NBTUtils {

    public static NBTTagCompound readCompressed(InputStream inputStream) throws IOException {
        DataInputStream stream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream)));
        NBTTagCompound compound = new NBTTagCompound();
        compound.read(stream, 0);
        return compound;
    }

    public static void writeCompressed(NBTTagCompound compound, OutputStream outputStream) throws IOException {
        DataOutputStream dataoutputstream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(outputStream)));

        try {
            write(compound, dataoutputstream);
        } finally {
            dataoutputstream.close();
        }
    }

    public static void safeWrite(NBTTagCompound compound, File fileIn) throws IOException {
        File file1 = new File(fileIn.getAbsolutePath() + "_tmp");

        if (file1.exists()) {
            file1.delete();
        }

        write(compound, file1);

        if (fileIn.exists()) {
            fileIn.delete();
        }

        if (fileIn.exists()) {
            throw new IOException("Failed to delete " + fileIn);
        } else {
            file1.renameTo(fileIn);
        }
    }

    public static NBTTagCompound read(DataInput input) throws IOException {
        NBTBase nbtbase = read(input, 0);

        if (nbtbase instanceof NBTTagCompound) {
            return (NBTTagCompound) nbtbase;
        } else {
            throw new IOException("Root tag must be a named compound tag");
        }
    }

    public static void write(NBTTagCompound compound, DataOutput output) throws IOException {
        writeTag(compound, output);
    }

    private static void writeTag(NBTBase tag, DataOutput output) throws IOException {
        output.writeByte(tag.getId());

        if (tag.getId() != 0) {
            output.writeUTF("");
            tag.write(output);
        }
    }

    private static NBTBase read(DataInput input, int depth) throws IOException {
        byte b0 = input.readByte();

        if (b0 == 0) {
            return new NBTTagEnd();
        } else {
            NBTBase nbtbase = NBTBase.create(b0);
            nbtbase.read(input, depth);
            return nbtbase;
        }
    }

    public static void write(NBTTagCompound compound, File fileIn) throws IOException {
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(fileIn));

        try {
            write(compound, dataoutputstream);
        } finally {
            dataoutputstream.close();
        }
    }

    @Nullable
    public static NBTTagCompound read(File fileIn) throws IOException {
        if (!fileIn.exists()) {
            return null;
        } else {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(fileIn));
            NBTTagCompound nbttagcompound;

            try {
                nbttagcompound = read(datainputstream);
            } finally {
                datainputstream.close();
            }

            return nbttagcompound;
        }
    }
}
