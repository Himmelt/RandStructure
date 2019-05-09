package org.soraworld.randstruct.listener;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.soraworld.randstruct.data.Schematic;
import org.soraworld.randstruct.manager.StructureManager;

import java.io.File;

public class EventListener implements Listener {

    private final StructureManager manager;

    public EventListener(StructureManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        World world = event.getWorld();
        Chunk chunk = event.getChunk();
        int x = chunk.getX();
        int z = chunk.getZ();
        new Schematic(new File("test.schematic")).paste(new Location(world, 1, 1, 1));
    }
}
