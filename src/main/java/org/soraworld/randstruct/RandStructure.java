package org.soraworld.randstruct;

import org.bukkit.event.Listener;
import org.bukkit.generator.ChunkGenerator;
import org.soraworld.randstruct.command.CommandStructure;
import org.soraworld.randstruct.listener.EventListener;
import org.soraworld.randstruct.manager.StructureManager;
import org.soraworld.violet.command.SpigotBaseSubs;
import org.soraworld.violet.command.SpigotCommand;
import org.soraworld.violet.manager.SpigotManager;
import org.soraworld.violet.plugin.SpigotPlugin;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RandStructure extends SpigotPlugin {

    protected SpigotManager registerManager(Path path) {
        return new StructureManager(this, path);
    }

    protected List<Listener> registerListeners() {
        ArrayList<Listener> listeners = new ArrayList<>();
        if (manager instanceof StructureManager) {
            StructureManager manager = (StructureManager) this.manager;
            listeners.add(new EventListener(manager));
        }
        return listeners;
    }

    protected void registerCommands() {
        SpigotCommand command = new SpigotCommand(getId(), null, false, manager, "rst");
        command.extractSub(SpigotBaseSubs.class);
        command.extractSub(CommandStructure.class);
        command.setUsage("/rst ....");
        register(this, command);
    }

    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new RandGenerator();
    }
}
