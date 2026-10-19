package betterfine;

public final class Zoom {
	private static final double MIN = 2.0;
	private static final double MAX = 10.0;
	private static final double STEP = 1.25;

	private double magnification = 4.0;

	public double magnification() {
		return this.magnification;
	}

	// magnification is optical: tan(fov / 2) shrinks by it, so a target looks that many times bigger
	public float fov(float baseFov) {
		double halfTan = Math.tan(Math.toRadians(baseFov) / 2) / this.magnification;
		return (float) Math.toDegrees(2 * Math.atan(halfTan));
	}

	public double sensitivity() {
		return 1 / this.magnification;
	}

	public void scroll(double notches) {
		double next = this.magnification * Math.pow(STEP, notches);
		this.magnification = Math.clamp(next, MIN, MAX);
	}
}
