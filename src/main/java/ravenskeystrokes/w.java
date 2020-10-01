package ravenskeystrokes;

import net.minecraft.client.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.client.*;
import net.minecraft.command.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.gui.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Mod(modid = "ravenskeystrokes", name = "Raven's Keystrokes", version = "1.0", acceptedMinecraftVersions = "[1.8.9]")
public class w
{
    public static int a;
    public static int b;
    public static Minecraft mc;
    private static ks a2;
    private static kr b2;
    private static boolean c2;
    
    public w() {
        w.mc = Minecraft.getMinecraft();
    }
    
    @Mod.EventHandler
    public void d(final FMLInitializationEvent e) {
        w.a2 = new ks();
        w.b2 = new kr();
        a2.loadInformation();
        ClientCommandHandler.instance.registerCommand((ICommand)new cm2());
        FMLCommonHandler.instance().bus().register((Object)this);
        FMLCommonHandler.instance().bus().register((Object)new cl());
        FMLCommonHandler.instance().bus().register((Object)new kr());
    }
    
    @SubscribeEvent
    public void f(final TickEvent.ClientTickEvent g) {
        if (w.c2) {
            w.mc.displayGuiScreen((GuiScreen)new gsk());
            w.c2 = false;
        }
    }
    
    public static ks d2() {
        return w.a2;
    }
    
    public static kr e2() {
        return w.b2;
    }
    
    public static void f2() {
        w.c2 = true;
    }
    
    static {
        w.a = 1;
        w.b = 0;
    }
    
    
}
