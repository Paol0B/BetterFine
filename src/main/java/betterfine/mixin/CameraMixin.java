package betterfine.mixin;

import betterfine.BetterFine;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
abstract class CameraMixin {
	@Shadow
	private boolean isPanoramicMode;

	@Shadow
	@Final
	private Minecraft minecraft;

	// skips the sprint and bow-draw FOV changes so the image stays still while aiming
	@Inject(method = "calculateFov", at = @At("HEAD"), cancellable = true)
	private void zoom(float partialTicks, CallbackInfoReturnable<Float> cir) {
		if (BetterFine.zooming() && !this.isPanoramicMode) {
			cir.setReturnValue(BetterFine.ZOOM.fov(this.minecraft.options.fov().get()));
		}
	}
}
