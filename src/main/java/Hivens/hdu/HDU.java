package Hivens.hdu;
import Hivens.hdu.Common.Registry.*;
import Hivens.hdu.Common.compat.ModCompat;
import Hivens.hdu.Common.loot.ModLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(HDU.MODID)
public class HDU {
    public static final String MODID = "hdu";
    public static final Logger LOGGER = LogUtils.getLogger();

    public HDU() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        CreativeTabRegistry.register(modEventBus);
        BlockEntitiesRegistry.register(modEventBus);
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.info("HDU Mod Initialization Started");
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModCompat.initCommon(event);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HDU Common Setup Complete");
    }
}
