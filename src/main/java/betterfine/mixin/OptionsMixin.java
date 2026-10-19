package betterfine.mixin;

import betterfine.BetterFine;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Options;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Options.class)
abstract class OptionsMixin {
	@Shadow
	@Final
	@Mutable
	public KeyMapping[] keyMappings;

	// before load() so options.txt can rebind the key
	@Inject(method = "load", at = @At("HEAD"))
	private void addZoomKey(CallbackInfo ci) {
		if (!ArrayUtils.contains(this.keyMappings, BetterFine.ZOOM_KEY)) {
			this.keyMappings = ArrayUtils.add(this.keyMappings, BetterFine.ZOOM_KEY);
		}
	}
}
