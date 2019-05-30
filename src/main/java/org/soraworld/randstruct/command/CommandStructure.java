package org.soraworld.randstruct.command;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.soraworld.randstruct.RandBlockPopulator;
import org.soraworld.randstruct.manager.StructureManager;
import org.soraworld.violet.command.Args;
import org.soraworld.violet.command.SpigotCommand;
import org.soraworld.violet.command.Sub;

public final class CommandStructure {

    @Sub(onlyPlayer = true)
    public static void testpaste(SpigotCommand self, CommandSender sender, Args args) {
        Player player = (Player) sender;
        StructureManager manager = (StructureManager) self.manager;
        World world = player.getWorld();
        Location loc = player.getLocation();
        manager.paste(world, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), "schematics/test.schematic");
    }

    @Sub(onlyPlayer = true)
    public static void rand(SpigotCommand self, CommandSender sender, Args args) {
        Player player = (Player) sender;
        StructureManager manager = (StructureManager) self.manager;
        World world = player.getWorld();
        ChunkGenerator generator = world.getGenerator();
        System.out.println(generator);
        world.getPopulators().add(new RandBlockPopulator(manager));
        System.out.println(world.getPopulators());
    }
}
