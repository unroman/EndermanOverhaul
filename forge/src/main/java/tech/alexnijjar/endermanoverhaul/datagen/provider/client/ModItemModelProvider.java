package tech.alexnijjar.endermanoverhaul.datagen.provider.client;


import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import tech.alexnijjar.endermanoverhaul.EndermanOverhaul;
import tech.alexnijjar.endermanoverhaul.common.registry.ModItems;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EndermanOverhaul.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CORRUPTED_PEARL.get());
        basicItem(ModItems.SOUL_PEARL.get());
        basicItem(ModItems.ANCIENT_PEARL.get());
        basicItem(ModItems.BUBBLE_PEARL.get());
        basicItem(ModItems.SUMMONER_PEARL.get());
        basicItem(ModItems.ICY_PEARL.get());
        basicItem(ModItems.CRIMSON_PEARL.get());
        basicItem(ModItems.WARPED_PEARL.get());
        basicItem(ModItems.ENDERMAN_TOOTH.get());
        basicItem(ModItems.BADLANDS_HOOD.get());
        basicItem(ModItems.SAVANNAS_HOOD.get());
        basicItem(ModItems.SNOWY_HOOD.get());
        ModItems.SPAWN_EGGS.getEntries().stream().map(RegistryEntry::get).forEach(this::spawnEggItem);
    }

    public void spawnEggItem(Item item) {
        getBuilder(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).toString())
            .parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
    }
}
