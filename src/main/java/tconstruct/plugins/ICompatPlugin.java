package tconstruct.plugins;

public interface ICompatPlugin {

  // Mod ID the plugin handles
  String getModId();

  // Called during TCon PreInit
  void preInit();

  // Called during TCon Init
  void init();

  // Called during TCon PostInit
  void postInit();
}
