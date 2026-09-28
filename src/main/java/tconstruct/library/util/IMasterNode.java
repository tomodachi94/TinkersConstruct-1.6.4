package tconstruct.library.util;

public interface IMasterNode extends IMasterLogic, IServantLogic {
  boolean isCurrentlyMaster();

  boolean isEquivalentMaster(IMasterLogic master);
}
