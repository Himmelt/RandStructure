package org.soraworld.randstruct.nbt;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagEnd extends NBTBase<Void> {

    public NBTTagEnd() {
        super(null);
    }

    void read(DataInput input, int depth) {
    }

    void write(DataOutput output) {
    }

    public byte getId() {
        return 0;
    }

    public String toString() {
        return "END";
    }

    public NBTTagEnd copy() {
        return new NBTTagEnd();
    }
}
