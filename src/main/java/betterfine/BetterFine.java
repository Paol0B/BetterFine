package betterfine;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

public final class BetterFine {
	// plain name, not a translation key: without Fabric API the game never loads mod lang files
	public static final KeyMapping ZOOM_KEY = new KeyMapping("Zoom", InputConstants.KEY_C, KeyMapping.Category.MISC);
	public static final Zoom ZOOM = new Zoom();

	private BetterFine() {
	}

	public static boolean zooming() {
		return ZOOM_KEY.isDown();
	}
}
