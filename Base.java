package net.minecraft.client.gui;

import org.quantic.Quantic;

import java.io.IOException;

public class GuiMainMenu extends GuiScreen
{

    private int addDistance(int delta) {
        return delta + 24;
    }

    private int getWidth() {
        return 98 / 2;
    }

    @Override
    public void initGui() {
        this.buttons.add(new GuiButton(0, width / 2 - getWidth(), height / 2, 98, 20, "SinglePlayer"));
        this.buttons.add(new GuiButton(1, width / 2 - getWidth(), addDistance(height / 2), 98, 20, "MultiPlayer"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case 0:
                mc.displayGuiScreen(new GuiSelectWorld(this));
                break;
            case 1:
                mc.displayGuiScreen(new GuiMultiplayer(this));
                break;
            default:
                Quantic.getQuantic().getLogger().error("Button: " + button.id + " not found...");
                break;
        }
        super.actionPerformed(button);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
