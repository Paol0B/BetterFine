# BetterFine

![Minecraft 26.3](https://img.shields.io/badge/Minecraft-26.3-62B47A)
![Fabric Loader 0.19.5+](https://img.shields.io/badge/Fabric_Loader-0.19.5%2B-DBD0B4)
![Java 25](https://img.shields.io/badge/Java-25-E76F00)

Precise zoom for Minecraft Java Edition. Hold **C**, aim, shoot.

Made for long-range bow shots. The view and the mouse scale together, so the crosshair moves the same on screen at 2x or at 10x.

## Features

- Hold `C` to zoom, release to go back.
- Scroll while zooming to change magnification from 2x to 10x. It starts at 4x and steps by 1.25x per notch.
- Mouse sensitivity divides by the magnification. No cinematic smoothing.
- Drawing a bow or sprinting does not shift the zoomed view.
- Only the field of view changes, so it works on both the OpenGL and the Vulkan renderer.
- Client only. The server (Paper, vanilla or anything else) needs nothing.
- One 8 KB jar. No Fabric API, no other dependencies.

## Requirements

| | Version |
|---|---|
| Minecraft | 26.3 |
| Fabric Loader | 0.19.5 or newer |
| Java | 25 |

## Install

Download `betterfine-1.0.0.jar` from the [latest release](../../releases/latest).

### Prism Launcher

1. Right-click your 26.3 instance and pick **Copy**, so the original stays vanilla.
2. On the copy, open **Edit → Version → Install Fabric**.
3. Open **Mods → Add file** and pick the jar.
4. Launch the copy.

### Official launcher

1. Run the [Fabric installer](https://fabricmc.net/use/installer/) for 26.3.
2. Put the jar in `.minecraft/mods`.
3. Start the `fabric-loader-26.3` profile.

## Usage

| Action | Input |
|---|---|
| Zoom | hold `C` |
| Change magnification | mouse wheel while zooming |
| Rebind | Options → Controls → Key Binds → Miscellaneous → Zoom |

## Build

```sh
./gradlew build
```

The jar lands in `build/libs/`. Gradle downloads JDK 25 on its own if it is not installed.
