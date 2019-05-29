package org.soraworld.randstruct;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Random;

public class RandGenerator extends ChunkGenerator {

    int currentHeight = 50;//leftArrowKey

    public byte[] generate(World world, Random random, int chunkX, int chunkZ) {

        System.out.println("x:" + chunkX + ",y:" + chunkZ);

        byte[] data = new byte[32768];

        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        generator.setScale(0.005D);

        for (int x = 0; x < 16; x++)
            for (int z = 0; z < 16; z++) {
                System.out.println("xx:" + x + ",zz:" + z);
                int index = (x * 16 + z) * 128;
                currentHeight = (int) (generator.noise(chunkX * 16 + x, chunkZ * 16 + z, 0.5D, 0.5D) * 15D + 50D);
                data[index] = 7;
                for (int level = 1; level <= currentHeight && level < 256; level++) {
                    data[index + level] = currentHeight - level < 5 ? (byte) 2 : (byte) 1;
                }
            }
        return data;
    }
}
