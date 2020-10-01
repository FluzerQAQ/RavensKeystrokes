package ravenskeystrokes;

import net.minecraft.client.*;
import net.minecraftforge.fml.common.gameevent.*;
import java.io.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.client.gui.*;
import java.awt.*;

public class kr
{
    private static final int[] a;
    private Minecraft mc;
    private ke[] b;
    private m4[] c;
    
    public kr() {
        this.mc = Minecraft.getMinecraft();
        this.b = new ke[4];
        this.c = new m4[2];
        this.b[0] = new ke(this.mc.gameSettings.keyBindForward, 26, 2);
        this.b[1] = new ke(this.mc.gameSettings.keyBindBack, 26, 26);
        this.b[2] = new ke(this.mc.gameSettings.keyBindLeft, 2, 26);
        this.b[3] = new ke(this.mc.gameSettings.keyBindRight, 50, 26);
        this.c[0] = new m4(0, 2, 50);
        this.c[1] = new m4(1, 38, 50);
    }
    
    @SubscribeEvent
    public void d(final TickEvent.RenderTickEvent e) {
        if (this.mc.currentScreen != null) {
            if (this.mc.currentScreen instanceof gsk) {
                try {
                    this.mc.currentScreen.handleInput();
                }
                catch (IOException ex) {}
            }
            return;
        }
        if (!this.mc.inGameHasFocus || this.mc.gameSettings.showDebugInfo) {
            return;
        }
        this.renderKeystrokes();
    }
    
    public void renderKeystrokes() {
        final ks f = w.d2();
        if (!f.isEnabled()) {
            return;
        }
        int x = f.getX();
        int y = f.getY();
        final int g = this.getColor(f.getTextColor());
        final boolean h = f.isShowingMouseButtons();
        final ScaledResolution res = new ScaledResolution(this.mc);
        final int width = 74;
        final int height = h ? 74 : 50;
        if (x < 0) {
            f.setX(0);
            x = f.getX();
        }
        else if (x > res.getScaledWidth() - width) {
            f.setX(res.getScaledWidth() - width);
            x = f.getX();
        }
        if (y < 0) {
            f.setY(0);
            y = f.getY();
        }
        else if (y > res.getScaledHeight() - height) {
            f.setY(res.getScaledHeight() - height);
            y = f.getY();
        }
        this.drawMovementKeys(x, y, g);
        if (h) {
            this.drawMouseButtons(x, y, g);
        }
    }
    
    private int getColor(final int index) {
        if (index == 6) {
            return Color.HSBtoRGB(System.currentTimeMillis() % 1000L / 1000.0f, 0.8f, 0.8f);
        }
        return kr.a[index];
    }
    
    private void drawMovementKeys(final int x, final int y, final int textColor) {
        for (final ke key : this.b) {
            key.renderKey(x, y, textColor);
        }
    }
    
    private void drawMouseButtons(final int x, final int y, final int textColor) {
        for (final m4 button : this.c) {
            button.n(x, y, textColor);
        }
    }
    
    static {
        a = new int[] { 16777215, 16711680, 65280, 255, 16776960, 11141290 };
    }
}
