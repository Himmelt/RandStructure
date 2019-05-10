package org.soraworld.randstruct.listener;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.soraworld.randstruct.manager.StructureManager;

public class EventListener implements Listener {

    private final StructureManager manager;

    public EventListener(StructureManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        World world = event.getWorld();
        // TODO 如果世界的UUID在配置中启用了随机建筑则继续，否则退出
        Chunk chunk = event.getChunk();
        int x = chunk.getX();
        int z = chunk.getZ();
        // TODO 避免重复生成，有至少两种方案
        //  1. 读取已生成的建筑的位置列表，根据当前区块的位置计算，是否在配置的半径内有其他已经生成过的建筑
        //  2. 对每个生成的建筑的区块中心(或其他某个固定位置)，都生成一个特殊方块或TileEntity(好处是可以存储自定义信息，
        //     比如告示牌)作为标记。然后检查半径内的所有区块的特定位置是否已有标记。

        // TODO 如果确认此区块可以生成建筑，则进入随机处理
        //  1. 随机类型 ：地牢，房屋，空岛。。。不同类型的建筑，可以设置不同的 Y 范围
        //  2. 随机建筑 ：根据已选的类型，进入对应建筑文件夹 "schematics/house/" 可以用数字作为文件名，以方便随机取出一个建筑
        //  3. 随机位置 ：尽量让建筑中心落在区块中心，建筑可以比区块大(最好不要太大)

        int randX = 0, randY = 0, randZ = 0;

        // TODO 文件后缀其实无所谓，不要都可以
        String name = "test.schematic";
        manager.paste(world, randX, randY, randZ, name);
    }
}
