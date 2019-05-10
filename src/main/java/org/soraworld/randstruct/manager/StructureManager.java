package org.soraworld.randstruct.manager;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import org.bukkit.World;
import org.soraworld.violet.manager.SpigotManager;
import org.soraworld.violet.plugin.SpigotPlugin;
import org.soraworld.violet.util.ChatColor;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;

public class StructureManager extends SpigotManager {

    private final HashMap<UUID, EditSession> sessions = new HashMap<>();

    public StructureManager(SpigotPlugin plugin, Path path) {
        super(plugin, path);
    }

    @Nonnull
    public ChatColor defChatColor() {
        return ChatColor.YELLOW;
    }

    public EditSession getWorldSession(World world) {
        return sessions.computeIfAbsent(world.getUID(), uuid
                -> WorldEdit.getInstance().getEditSessionFactory().getEditSession(new BukkitWorld(world), 0));
    }

    public void paste(World world, int x, int y, int z, String path) {
        try {
            MCEditSchematicFormat.MCEDIT.load(this.path.resolve(path).toFile()).paste(
                    getWorldSession(world), new Vector(x, y, z), true
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
