package mekanism.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.IIcon;

import java.util.List;

public interface IGuiWrapper
{
	public void drawTexturedRect(int x, int y, int u, int v, int w, int h);

	public void drawTexturedRectFromIcon(int x, int y, IIcon icon, int w, int h);

	public void displayTooltip(String s, int xAxis, int yAxis);

	public void displayTooltips(List<String> list, int xAxis, int yAxis);

	public FontRenderer getFont();
}
