package exnihiloadscensio.items;

import exnihiloadscensio.blocks.BlockSieve.MeshType;
import exnihiloadscensio.util.Data;
import exnihiloadscensio.util.IHasModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ItemMesh extends Item implements IHasModel {
	
	public ItemMesh() {
		super();
		this.setHasSubtypes(true);
		this.setUnlocalizedName("itemMesh");
		this.setRegistryName("itemMesh");
		this.setMaxStackSize(1);
        Data.ITEMS.add(this);
	}
	
	@Override
	public int getItemEnchantability(ItemStack stack)
	{
	    switch(stack.getMetadata())
	    {
	        case 1:
	            return 15;
	        case 2:
	            return 7;
	        case 3:
	            return 14;
	        case 4:
	            return 10;
	        default:
	            return 0;
	    }
	}
	
	@Override @Nonnull
	public String getUnlocalizedName(ItemStack stack) {
	    return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull CreativeTabs tab, NonNullList<ItemStack> list)
    {
        if (this.isInCreativeTab(tab))
        for (int i = 1 ; i < MeshType.values().length ; i++) { //0 is the "none" case.
            list.add(new ItemStack(this, 1, i));
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(this, 1, new ModelResourceLocation("exnihiloadscensio:itemMeshString"));
		ModelLoader.setCustomModelResourceLocation(this, 2, new ModelResourceLocation("exnihiloadscensio:itemMeshFlint"));
		ModelLoader.setCustomModelResourceLocation(this, 3, new ModelResourceLocation("exnihiloadscensio:itemMeshIron"));
		ModelLoader.setCustomModelResourceLocation(this, 4, new ModelResourceLocation("exnihiloadscensio:itemMeshDiamond"));
	}

}
