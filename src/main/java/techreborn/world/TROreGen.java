package techreborn.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import techreborn.config.ConfigTechReborn;
import techreborn.init.ModBlocks;
import techreborn.util.LogHelper;
import cpw.mods.fml.common.IWorldGenerator;

public class TROreGen implements IWorldGenerator {
	public static ConfigTechReborn config;

	WorldGenMinable oreGalena;
	WorldGenMinable oreIridium;
	WorldGenMinable oreRuby;
	WorldGenMinable oreSapphire;
	WorldGenMinable oreBauxite;
	WorldGenMinable orePyrite;
	WorldGenMinable oreCinnabar;
	WorldGenMinable oreSphalerite;
	WorldGenMinable oreTungston;
	WorldGenMinable oreSheldonite;
	WorldGenMinable oreOlivine;
	WorldGenMinable oreSodalite;
	WorldGenMinable oreCopper;
	WorldGenMinable oreTin;
	WorldGenMinable oreLead;
	WorldGenMinable oreSilver;

	public TROreGen()
	{
		// World
		oreGalena = new WorldGenMinable(ModBlocks.ore, 0, ConfigTechReborn.GalenaOreRare, Blocks.stone);
		oreIridium = new WorldGenMinable(ModBlocks.ore, 1, ConfigTechReborn.IridiumOreRare, Blocks.stone);
		oreRuby = new WorldGenMinable(ModBlocks.ore, 2, ConfigTechReborn.RubyOreRare, Blocks.stone);
		oreSapphire = new WorldGenMinable(ModBlocks.ore, 3, ConfigTechReborn.SapphireOreRare, Blocks.stone);
		oreBauxite = new WorldGenMinable(ModBlocks.ore, 4, ConfigTechReborn.BauxiteOreRare, Blocks.stone);
		oreCopper = new WorldGenMinable(ModBlocks.ore, 12, ConfigTechReborn.CopperOreRare, Blocks.stone);
		oreTin = new WorldGenMinable(ModBlocks.ore, 13, ConfigTechReborn.TinOreRare, Blocks.stone);
		oreLead = new WorldGenMinable(ModBlocks.ore, 14, ConfigTechReborn.LeadOreRare, Blocks.stone);
		oreSilver = new WorldGenMinable(ModBlocks.ore, 15, ConfigTechReborn.SilverOreRare, Blocks.stone);

		// Nether
		orePyrite = new WorldGenMinable(ModBlocks.ore, 5, ConfigTechReborn.PyriteOreRare, Blocks.netherrack);
		oreCinnabar = new WorldGenMinable(ModBlocks.ore, 6, ConfigTechReborn.CinnabarOreRare, Blocks.netherrack);
		oreSphalerite = new WorldGenMinable(ModBlocks.ore, 7, ConfigTechReborn.SphaleriteOreRare, Blocks.netherrack);
		
		// End
		oreTungston = new WorldGenMinable(ModBlocks.ore, 8, ConfigTechReborn.TungstenOreRare, Blocks.end_stone);
		oreSheldonite = new WorldGenMinable(ModBlocks.ore, 9, ConfigTechReborn.SheldoniteOreRare, Blocks.end_stone);
		oreOlivine = new WorldGenMinable(ModBlocks.ore, 10, ConfigTechReborn.OlivineOreRare, Blocks.end_stone);
		oreSodalite = new WorldGenMinable(ModBlocks.ore, 11, ConfigTechReborn.SodaliteOreRare, Blocks.end_stone);
		
		LogHelper.info("WorldGen Loaded");
	}
	
	public void retroGen(Random random, int chunkX, int chunkZ, World world) 
	{
		//TODO
		generateUndergroundOres(random, chunkX, chunkZ, world);
		generateHellOres(random, chunkX, chunkZ, world);
		generateEndOres(random, chunkX, chunkZ, world);
		world.getChunkFromChunkCoords(chunkX, chunkZ).setChunkModified();
	}

	@Override
	public void generate(Random random, int xChunk, int zChunk, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (world.provider.isSurfaceWorld())
		{
			generateUndergroundOres(random, xChunk * 16, zChunk * 16, world);
		} else if (world.provider.isHellWorld)
		{
			generateHellOres(random, xChunk * 16, zChunk * 16, world);
		} else
		{
			generateEndOres(random, xChunk * 16, zChunk * 16, world);
		}

	}

	void generateUndergroundOres(Random random, int xChunk, int zChunk,
			World world)
	{
		int xPos, yPos, zPos;
		if (config.GalenaOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreGalena.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.IridiumOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreIridium.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.RubyOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreRuby.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SapphireOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreSapphire.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.BauxiteOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreBauxite.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.CopperOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreCopper.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.TinOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreTin.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.LeadOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreLead.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SilverOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreSilver.generate(world, random, xPos, yPos, zPos);
			}
		}
	}

	void generateHellOres(Random random, int xChunk, int zChunk, World world)
	{
		int xPos, yPos, zPos;
		if (config.PyriteOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				orePyrite.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.CinnabarOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreCinnabar.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SphaleriteOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreSphalerite.generate(world, random, xPos, yPos, zPos);
			}
		}
	}

	void generateEndOres(Random random, int xChunk, int zChunk, World world)
	{
		int xPos, yPos, zPos;
		if (config.TungstenOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreTungston.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SheldoniteOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreSheldonite.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.OlivineOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreOlivine.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SodaliteOreTrue)
		{
			for (int i = 0; i <= 16; i++)
			{
				xPos = xChunk + random.nextInt(16);
				yPos = 60 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreSodalite.generate(world, random, xPos, yPos, zPos);
			}
		}
	}
}
