# [Tinkers' Construct](http://www.minecraftforum.net/topic/1659892-tinkers-construct/) for 1.6.4

Modify all the things, then do it again! 	 
Melt down any metals you find. 	 
Turn everything into golems!

Install Forge as usual, and setup your IDE as with any other Forge project. Copy `TCore_dummy.jar` to `forge/mcp/jars/mods/` to enable the Preloader (optional -- only needed when working on the preloader itself)

## Compile from Source
Run [gradle] in the repository root: `gradlew[.bat] build`. To get a JAR, run `gradlew jar`. To test your changes in the game, run `gradlew runClient`. To reobfuscate the JAR for use in an obfuscated game, run `gradle renameJarToSrg`.

## Issue reporting
Please include the following:

* Minecraft version
* Tinkers' Construct version and where you got it
* Forge version/build
* Versions of any mods potentially related to the issue 
* Any relevant screenshots are greatly appreciated.
* For crashes:
	* Steps to reproduce
	* ForgeModLoader-client-0.log (the FML log) from the root folder of the client

## Licenses
Most code is public domain under [Creative Commons 0](http://creativecommons.org/publicdomain/zero/1.0/).

Textures and binaries are licensed under [Creative Commons 3](http://creativecommons.org/licenses/by/3.0/).

Any alternate licenses are noted where appropriate.

Please do not file issues with the original mod's authors; you should do that here instead.
