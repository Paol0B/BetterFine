package betterfine.mixin;

import betterfine.BetterFine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
abstract class MouseHandlerMixin {
	@Shadow
	@Final
	private Minecraft minecraft;

	@ModifyArg(method = "turnPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;turn(DD)V"), index = 0)
	private double scaleYaw(double yaw) {
		return scale(yaw);
	}

	@ModifyArg(method = "turnPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;turn(DD)V"), index = 1)
	private double scalePitch(double pitch) {
		return scale(pitch);
	}

	@Inject(method = "onScroll", at = @At("HEAD"), cancellable = true)
	private void scrollZoom(long handle, double xoffset, double yoffset, CallbackInfo ci) {
		if (BetterFine.zooming() && this.minecraft.gui.screen() == null) {
			BetterFine.ZOOM.scroll(yoffset);
			ci.cancel();
		}
	}

	private static double scale(double turn) {
		return BetterFine.zooming() ? turn * BetterFine.ZOOM.sensitivity() : turn;
	}
}
