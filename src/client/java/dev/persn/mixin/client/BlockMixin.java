package dev.persn.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.persn.WDMGSLTClient;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "spawnDestroyByEntityParticles", at = @At("HEAD"), cancellable = true)
    private void onSpawnDestroyByEntityParticles(Level level, Entity entity, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (level.isClientSide() && entity instanceof Player player
                && WDMGSLTClient.hasAlteredBreakSound(state)
                && WDMGSLTClient.hasSilkTouch(player.getMainHandItem())) {
            // Cancel the default particle spawn and sound
            ci.cancel();
            level.addDestroyBlockEffect(pos, state);
            level.playLocalSound(
                pos.getX() + 0.5D,
                pos.getY() + 0.5D,
                pos.getZ() + 0.5D,
                WDMGSLTClient.BLOCK_SILKTOUCH_BREAK,
                SoundSource.BLOCKS,
                1.0F,
                1.0F,
                false
            );
        }
    }
}
