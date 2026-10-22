package dev.persn;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public final class WDMGSLTClient {

	public static final Identifier SILKTOUCH_BREAK_ID = Identifier.fromNamespaceAndPath(WDMGSLT.MOD_ID, "silktouch_glass_break");

	/**
	 * Not registered in the sound event registry: the client sound manager resolves the
	 * event by its id from {@code assets/wdmgslt/sounds.json}, so nothing has to be synced
	 * with (or be known by) the server.
	 */
	public static final SoundEvent BLOCK_SILKTOUCH_BREAK = SoundEvent.createVariableRangeEvent(SILKTOUCH_BREAK_ID);

	/**
	 * Block tags are sent by the server, so the mod's own data pack tag is missing on vanilla
	 * servers. Vanilla glass, tinted glass, stained glass and all panes are therefore matched
	 * on the client as well; the tag still adds blocks when the server provides it.
	 * (This class is first loaded from the mixin, long after the block registry bootstrap.)
	 */
	private static final Set<Block> VANILLA_GLASS = Stream.of(
			Stream.of(Blocks.GLASS, Blocks.GLASS_PANE, Blocks.TINTED_GLASS),
			Blocks.STAINED_GLASS.asList().stream(),
			Blocks.STAINED_GLASS_PANE.asList().stream())
		.flatMap(blocks -> blocks)
		.collect(Collectors.toUnmodifiableSet());

	private WDMGSLTClient() {
	}

	public static boolean hasAlteredBreakSound(BlockState state) {
		return VANILLA_GLASS.contains(state.getBlock()) || state.is(ModTags.SILK_TOUCH_ALTERED_BREAK_SOUND);
	}

	public static boolean hasSilkTouch(ItemStack stack) {
		if (EnchantmentHelper.hasTag(stack, EnchantmentTags.PREVENTS_BEE_SPAWNS_WHEN_MINING)) {
			return true;
		}
		for (Holder<Enchantment> enchantment : stack.getEnchantments().keySet()) {
			if (enchantment.is(Enchantments.SILK_TOUCH)) {
				return true;
			}
		}
		return false;
	}
}
