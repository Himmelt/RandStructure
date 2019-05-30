package org.soraworld.randstruct;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.soraworld.randstruct.manager.StructureManager;

import java.util.Random;

public class RandBlockPopulator extends BlockPopulator {

    private final StructureManager manager;

    public RandBlockPopulator(StructureManager manager) {
        this.manager = manager;
    }

    public void populate(World world, Random random, Chunk source) {
        source.getBlock(0, 100, 0).setType(Material.DIAMOND_BLOCK);
    }
}
