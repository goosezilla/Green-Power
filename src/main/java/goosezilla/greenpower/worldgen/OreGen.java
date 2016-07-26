package goosezilla.greenpower.worldgen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import goosezilla.greenpower.registry.ModBlocks;
//import sokratis12gr.armorplus.resources.ConfigHandler;

import java.util.Random;

public class OreGen implements IWorldGenerator {

    public WorldGenerator xpCrystalGenerator;

    public OreGen() {
        xpCrystalGenerator = new WorldGenMinable(ModBlocks.BLOCK_XP_CRYSTAL.getDefaultState(), 50);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //Overworld Dimension
                //if (ConfigHandler.enableLavaCrystalOverworldGen) {
                    this.runGenerator(xpCrystalGenerator, world, random, chunkX, chunkZ, 80, 65, 75);
                //}

        }
    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}
