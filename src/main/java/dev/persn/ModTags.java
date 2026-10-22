package dev.persn;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModTags {
    public static final TagKey<Block> SILK_TOUCH_ALTERED_BREAK_SOUND = TagKey.create(
        Registries.BLOCK,
        Identifier.fromNamespaceAndPath(WDMGSLT.MOD_ID, "silk_touch_altered_break_sound")
    );

    private ModTags() {
    }
}
