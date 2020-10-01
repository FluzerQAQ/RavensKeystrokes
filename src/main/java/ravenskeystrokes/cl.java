package ravenskeystrokes;

import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import java.util.*;

public class cl
{
    private static List<Long> a;
    private static List<Long> b;
    
    public cl() {
        cl.a = new ArrayList<Long>();
        cl.b = new ArrayList<Long>();
    }
    
    @SubscribeEvent
    public void c(final MouseEvent d) {
        if (d.button == 0 && d.buttonstate) {
            e();
        }
        if (d.button == 1 && d.buttonstate) {
            h();
        }
    }
    
    public static void e() {
        cl.a.add(System.currentTimeMillis());
    }
    
    public static int f() {
        final Iterator<Long> g = cl.a.iterator();
        while (g.hasNext()) {
            if (g.next() < System.currentTimeMillis() - 1000L) {
                g.remove();
            }
        }
        return cl.a.size();
    }
    
    public static void h() {
        cl.b.add(System.currentTimeMillis());
    }
    
    public static int i() {
        final Iterator<Long> j = cl.b.iterator();
        while (j.hasNext()) {
            if (j.next() < System.currentTimeMillis() - 1000L) {
                j.remove();
            }
        }
        return cl.b.size();
    }
}
