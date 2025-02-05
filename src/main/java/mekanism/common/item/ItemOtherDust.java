package mekanism.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemOtherDust extends ItemMekanism
{
	public IIcon[] icons = new IIcon[256];
	
	public static String[] subtypes = {"Diamond", "Steel", "null", 
									  "Sulfur", "Lithium", "RefinedObsidian",
									  "Obsidian"};
	
	public ItemOtherDust()
	{
		super();
		setHasSubtypes(true);
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		for(int i = 0; i < subtypes.length; i++)
		{
			if(i == 2)
			{
				continue;
			}
			
			icons[i] = register.registerIcon("mekanism:" + subtypes[i] + "Dust");
		}
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		return icons[meta];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List itemList)
	{
		for(int counter = 0; counter < subtypes.length; counter++)
		{
			if(counter == 2)
			{
				continue;
			}
			
			itemList.add(new ItemStack(this, 1, counter));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return "item." + subtypes[item.getItemDamage()].toLowerCase() + "Dust";
	}
}
