package ravenskeystrokes;

import net.minecraft.client.*;
import net.minecraft.client.settings.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;

public class ke
{
    private Minecraft a;
    private KeyBinding b;
    private int c;
    private int d;
    private boolean e;
    private long f;
    private int g;
    private double h;
    
    public ke(final KeyBinding i, final int j, final int k) {
        this.a = Minecraft.getMinecraft();
        this.e = true;
        this.f = 0L;
        this.g = 255;
        this.h = 1.0;
        this.b = i;
        this.c = j;
        this.d = k;
    }
    
    public void renderKey(final int l, final int m, final int n) {
        final boolean o = this.b.isKeyDown();
        final String p = Keyboard.getKeyName(this.b.getKeyCode());
        if (o != this.e) {
            this.e = o;
            this.f = System.currentTimeMillis();
        }
        if (o) {
            this.g = Math.min(255, (int)(2L * (System.currentTimeMillis() - this.f)));
            this.h = Math.max(0.0, 1.0 - (System.currentTimeMillis() - this.f) / 20.0);
        }
        else {
            this.g = Math.max(0, 255 - (int)(2L * (System.currentTimeMillis() - this.f)));
            this.h = Math.min(1.0, (System.currentTimeMillis() - this.f) / 20.0);
        }
        final int q = n >> 16 & 0xFF;
        final int r = n >> 8 & 0xFF;
        final int s = n & 0xFF;
        Gui.drawRect(l + this.c, m + this.d, l + this.c + 22, m + this.d + 22, 2013265920 + (this.g << 16) + (this.g << 8) + this.g);
        this.a.fontRendererObj.drawString(p, l + this.c + 8, m + this.d + 8, -16777216 + ((int)(q * this.h) << 16) + ((int)(r * this.h) << 8) + (int)(s * this.h));
    }
}
