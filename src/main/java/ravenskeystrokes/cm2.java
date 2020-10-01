package ravenskeystrokes;

import net.minecraft.command.*;

public class cm2 extends CommandBase
{
    public String getCommandName() {
        return "keystrokesmod";
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) {
        w.f2();
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/keystrokesmod";
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender sender) {
        return true;
    }
}
