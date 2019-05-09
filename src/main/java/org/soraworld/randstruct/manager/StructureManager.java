package org.soraworld.randstruct.manager;

import org.soraworld.violet.manager.SpigotManager;
import org.soraworld.violet.plugin.SpigotPlugin;
import org.soraworld.violet.util.ChatColor;

import javax.annotation.Nonnull;
import java.nio.file.Path;

public class StructureManager extends SpigotManager {

    public StructureManager(SpigotPlugin plugin, Path path) {
        super(plugin, path);
    }

    @Nonnull
    public ChatColor defChatColor() {
        return ChatColor.YELLOW;
    }
}
