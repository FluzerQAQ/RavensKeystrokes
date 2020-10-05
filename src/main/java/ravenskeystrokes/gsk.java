package ravenskeystrokes;

import net.minecraft.client.gui.*;
import net.minecraft.client.resources.I18n;
import java.io.*;

public class gsk extends GuiScreen
{
    private static final String[] cn;
    private GuiButton b1;
    private GuiButton b2;
    private GuiButton b3;
    private GuiButton b4;
    private boolean d;
    private int lx;
    private int ly;
    
    public gsk() {
        this.d = false;
    }
    
    public void initGui() {
        final ks settings = w.d2();
        this.buttonList.add(this.b1 = new GuiButton(0, this.width / 2 - 70, this.height / 2 - 28, 140, 20, settings.isEnabled() ? I18n.format("rks.enabled") : I18n.format("rks.disabled")));
        this.buttonList.add(this.b2 = new GuiButton(1, this.width / 2 - 70, this.height / 2 - 6, 140, 20, I18n.format("rks.showmousebuttons") + (settings.isShowingMouseButtons() ? I18n.format("rks.on") : I18n.format("rks.off"))));
        this.buttonList.add(this.b3 = new GuiButton(2, this.width / 2 - 70, this.height / 2 + 16, 140, 20, I18n.format("rks.showcps") + (settings.isShowingCPS() ? I18n.format("rks.on") : I18n.format("rks.off"))));
        this.buttonList.add(this.b4 = new GuiButton(3, this.width / 2 - 70, this.height / 2 + 38, 140, 20, I18n.format("rks.textcolor") + gsk.cn[settings.getTextColor()]));
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        w.e2().renderKeystrokes();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    protected void actionPerformed(final GuiButton button) {
        final ks settings = w.d2();
        if (button == this.b1) {
            settings.setEnabled(!settings.isEnabled());
            this.b1.displayString = (settings.isEnabled() ? I18n.format("rks.enabled") : I18n.format("rks.disabled"));
        }
        else if (button == this.b2) {
            settings.setShowingMouseButtons(!settings.isShowingMouseButtons());
            this.b2.displayString = I18n.format("rks.showmousebuttons") + (settings.isShowingMouseButtons() ? I18n.format("rks.on") : I18n.format("rks.off"));
        }
        else if (button == this.b3) {
            settings.setShowingCPS(!settings.isShowingCPS());
            this.b3.displayString = I18n.format("rks.showcps") + (settings.isShowingCPS() ? I18n.format("rks.on") : I18n.format("rks.off"));
        }
        else if (button == this.b4) {
            settings.setTextColor((settings.getTextColor() == 6) ? 0 : (settings.getTextColor() + 1));
            this.b4.displayString = I18n.format("rks.textcolor") + gsk.cn[settings.getTextColor()];
        }
    }
    
    protected void mouseClicked(final int mouseX, final int mouseY, final int button) {
        try {
            super.mouseClicked(mouseX, mouseY, button);
        }
        catch (IOException ex) {}
        if (button != 0) {
            return;
        }
        final ks settings = w.d2();
        final int startX = settings.getX();
        final int startY = settings.getY();
        final int endX = startX + 74;
        final int endY = startY + (settings.isShowingMouseButtons() ? 74 : 50);
        if (mouseX >= startX && mouseX <= endX && mouseY >= startY && mouseY <= endY) {
            this.d = true;
            this.lx = mouseX;
            this.ly = mouseY;
        }
    }
    
    protected void mouseReleased(final int mouseX, final int mouseY, final int action) {
        super.mouseReleased(mouseX, mouseY, action);
        this.d = false;
    }
    
    protected void mouseClickMove(final int mouseX, final int mouseY, final int lastButtonClicked, final long timeSinceMouseClick) {
        super.mouseClickMove(mouseX, mouseY, lastButtonClicked, timeSinceMouseClick);
        if (!this.d) {
            return;
        }
        final ks settings = w.d2();
        settings.setX(settings.getX() + mouseX - this.lx);
        settings.setY(settings.getY() + mouseY - this.ly);
        this.lx = mouseX;
        this.ly = mouseY;
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    static {
        cn = new String[] { I18n.format("rks.white"), I18n.format("rks.red"), I18n.format("rks.green"), I18n.format("rks.blue"), I18n.format("rks.yellow"), I18n.format("rks.purple"), I18n.format("rks.rainbow") };
    }
}
