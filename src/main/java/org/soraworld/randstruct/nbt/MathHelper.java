package org.soraworld.randstruct.nbt;

class MathHelper {
    static int floor(double value) {
        int i = (int) value;
        return value < (double) i ? i - 1 : i;
    }
}
