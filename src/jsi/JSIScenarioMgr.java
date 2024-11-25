package jsi;

import jsi.scenario.*;
import x.XScenarioMgr;

public class JSIScenarioMgr extends XScenarioMgr {
  public JSIScenarioMgr(JSIApp jsi) {
    super(jsi);
  }

  @Override
  protected void addScenarios() {
    this.addScenario(DefaultScenario.createSingleton(this.mApp));
    this.addScenario(ChangeScenario.createSingleton(this.mApp));
  }

  @Override
  protected void setInitCurScene() {
    this.setCurScene(DefaultScenario.DefaultScenarioScene1.getSingleton());
  }
}
