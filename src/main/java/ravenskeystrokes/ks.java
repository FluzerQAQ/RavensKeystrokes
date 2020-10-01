package ravenskeystrokes;

import java.io.*;

public class ks
{
    private int a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    
    public ks() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = false;
        this.e = true;
    }
    
    public void loadInformation() {
        try {
            final File file = new File("./config/", "ravenskeystrokes.txt");
            if (!file.exists()) {
                saveInformation();
                return;
            }
            final FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            final DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.contains(":")) {
                    continue;
                }
                final String key = line.split(":")[0];
                final String value = line.split(":")[1];
                if (key.equalsIgnoreCase("a")) {
                    this.a = Integer.parseInt(value);
                }
                else if (key.equalsIgnoreCase("b")) {
                    this.b = Integer.parseInt(value);
                }
                else if (key.equalsIgnoreCase("c")) {
                    this.c = Integer.parseInt(value);
                }
                else if (key.equalsIgnoreCase("d")) {
                    this.d = Boolean.parseBoolean(value);
                }
                else {
                    if (!key.equalsIgnoreCase("e")) {
                        continue;
                    }
                    this.e = Boolean.parseBoolean(value);
                }
            }
            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            saveInformation();
        }
    }
    
    public void saveInformation() {
        try {
            final File file = new File("./config/", "ravenskeystrokes.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("a:" + this.a + "\r\n");
            bufferedWriter.write("b:" + this.b + "\r\n");
            bufferedWriter.write("c:" + this.c + "\r\n");
            bufferedWriter.write("d:" + this.d + "\r\n");
            bufferedWriter.write("e:" + this.e);
            bufferedWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getX() {
        return this.a;
    }
    
    public void setX(final int x) {
        this.a = x;
        this.saveInformation();
    }
    
    public int getY() {
        return this.b;
    }
    
    public void setY(final int y) {
        this.b = y;
        this.saveInformation();
    }
    
    public int getTextColor() {
        return this.c;
    }
    
    public void setTextColor(final int textColor) {
        this.c = textColor;
        this.saveInformation();
    }
    
    public boolean isEnabled() {
        return this.e;
    }
    
    public void setEnabled(final boolean enabled) {
        this.e = enabled;
        this.saveInformation();
    }
    
    public boolean isShowingMouseButtons() {
        return this.d;
    }
    
    public void setShowingMouseButtons(final boolean showingMouseButtons) {
        this.d = showingMouseButtons;
        this.saveInformation();
    }
    
}
