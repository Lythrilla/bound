package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "bound";
    public static final String NAME = "Bound";
    public static final String VERSION = "1.0";

    private static Logger logger;

    public static KeyBinding menuKey = new KeyBinding("Open Menu", Keyboard.KEY_C, "Bound");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ClientRegistry.registerKeyBinding(menuKey);
        
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
        
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onKeyInput(ClientTickEvent event) {
        if (menuKey.isPressed()) {
            Minecraft.getMinecraft().player.sendChatMessage("/menu");
        }
    }
}
