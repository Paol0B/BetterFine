package betterfine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ZoomTest {
	private static final double EPSILON = 1e-6;

	@Test
	void startsAtFourTimes() {
		assertEquals(4.0, new Zoom().magnification(), EPSILON);
	}

	@Test
	void fovMagnifiesImageByMagnification() {
		Zoom zoom = new Zoom();
		double baseHalfTan = Math.tan(Math.toRadians(70.0) / 2);
		double zoomedHalfTan = Math.tan(Math.toRadians(zoom.fov(70.0F)) / 2);

		assertEquals(4.0, baseHalfTan / zoomedHalfTan, 1e-5);
	}

	@Test
	void sensitivityKeepsCrosshairSpeedOnScreen() {
		assertEquals(0.25, new Zoom().sensitivity(), EPSILON);
	}

	@Test
	void scrollUpZoomsInOneStep() {
		Zoom zoom = new Zoom();
		zoom.scroll(1.0);

		assertEquals(5.0, zoom.magnification(), EPSILON);
	}

	@Test
	void scrollDownZoomsOutOneStep() {
		Zoom zoom = new Zoom();
		zoom.scroll(-1.0);

		assertEquals(3.2, zoom.magnification(), EPSILON);
	}

	@Test
	void magnificationStopsAtTenTimes() {
		Zoom zoom = new Zoom();
		zoom.scroll(50.0);

		assertEquals(10.0, zoom.magnification(), EPSILON);
	}

	@Test
	void magnificationStopsAtTwoTimes() {
		Zoom zoom = new Zoom();
		zoom.scroll(-50.0);

		assertEquals(2.0, zoom.magnification(), EPSILON);
	}
}
