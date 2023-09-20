package tech.alexnijjar.endermanoverhaul.client;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.EntityType;
import tech.alexnijjar.endermanoverhaul.client.particles.EndermanParticle;
import tech.alexnijjar.endermanoverhaul.client.renderer.ReplacedEndermanRenderer;
import tech.alexnijjar.endermanoverhaul.client.renderer.base.BaseEndermanEntityRenderer;
import tech.alexnijjar.endermanoverhaul.client.utils.ClientPlatformUtils;
import tech.alexnijjar.endermanoverhaul.common.registry.ModEntityTypes;
import tech.alexnijjar.endermanoverhaul.common.registry.ModParticleTypes;

import java.util.function.BiConsumer;

public class EndermanOverhaulClient {
    public static void init() {
        registerEntityRenderers();
    }

    private static void registerEntityRenderers() {
        ClientPlatformUtils.registerRenderer(() -> EntityType.ENDERMAN, ReplacedEndermanRenderer::new);
        ClientPlatformUtils.registerRenderer(ModEntityTypes.CAVE_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.CAVE_ENDERMAN.get()));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.SAVANNA_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.SAVANNA_ENDERMAN.get()));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.NETHER_WASTES_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.NETHER_WASTES_ENDERMAN.get()));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.CRIMSON_FOREST_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.CRIMSON_FOREST_ENDERMAN.get()));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.SWAMP_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.SWAMP_ENDERMAN.get()));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.ICE_SPIKES_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.ICE_SPIKES_ENDERMAN.get(), BaseEndermanEntityRenderer.ICE_SPIKES_ANIMATION));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.DARK_OAK_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.DARK_OAK_ENDERMAN.get()));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.WINDSWEPT_HILLS_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.WINDSWEPT_HILLS_ENDERMAN.get()));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.BADLANDS_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.BADLANDS_ENDERMAN.get()));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.SNOWY_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.SNOWY_ENDERMAN.get(), BaseEndermanEntityRenderer.SNOWY_ANIMATION));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.DESERT_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.DESERT_ENDERMAN.get(), BaseEndermanEntityRenderer.DESERT_ANIMATION));
        ClientPlatformUtils.registerRenderer(ModEntityTypes.SOULSAND_VALLEY_ENDERMAN, c -> new BaseEndermanEntityRenderer<>(c, ModEntityTypes.SOULSAND_VALLEY_ENDERMAN.get(), BaseEndermanEntityRenderer.SOULSAND_VALLEY_ANIMATION));
    }

    public static void onRegisterParticles(BiConsumer<ParticleType<SimpleParticleType>, ClientPlatformUtils.SpriteParticleRegistration<SimpleParticleType>> register) {
        register.accept(ModParticleTypes.DUST.get(), spriteSet -> new EndermanParticle.Provider(spriteSet, 0.7f, 0.7f, 0.7f));
        register.accept(ModParticleTypes.SNOW.get(), EndermanParticle.Provider::new);
        register.accept(ModParticleTypes.SAND.get(), spriteSet -> new EndermanParticle.Provider(spriteSet, 0.8588235294117647f, 0.8274509803921568f, 0.6274509803921569f));
        register.accept(ModParticleTypes.SOUL_FIRE_FLAME.get(), EndermanParticle.Provider::new);
    }
}
