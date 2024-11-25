package jsi.scenario;

import jsi.JSIApp;
import jsi.JSIScene;
import x.XApp;
import x.XCmdToChangeScene;
import x.XScenario;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ChangeScenario extends XScenario {
  private ChangeScenarioDefaultScene1 defaultScene = null; // DefaultScene 참조

  // singleton pattern
  private static ChangeScenario mSingleton = null;

  public static ChangeScenario getSingleton() {
    assert (ChangeScenario.mSingleton != null);
    return mSingleton;
  }

  public static ChangeScenario createSingleton(XApp app) {
    assert (ChangeScenario.mSingleton == null);
    ChangeScenario.mSingleton = new ChangeScenario(app);
    return ChangeScenario.mSingleton;
  }

  private ChangeScenario(XApp app) {
    super(app);

    // Scene 생성
    this.defaultScene = ChangeScenarioDefaultScene1.createSingleton(this);
  }

  @Override
  protected void addScenes() {
    this.addScene(this.defaultScene);
  }

  public void handleButtonPress() {
    System.out.println("Button Pressed in DefaultScenario");
    // 현재 활성화된 씬에 따라 동작 분기
    if (this.getApp().getScenarioMgr().getCurScene() == this.defaultScene) {
      // default scene의 handleButtonPress 함수 호출
      this.defaultScene.handleButtonPress();
    }
  }

  public static class ChangeScenarioDefaultScene1 extends JSIScene {
    //  singleton
    private static ChangeScenarioDefaultScene1 mSingleton = null;

    public static ChangeScenarioDefaultScene1 getSingleton() {
      assert (ChangeScenarioDefaultScene1.mSingleton != null);
      return ChangeScenarioDefaultScene1.mSingleton;
    }

    public static ChangeScenarioDefaultScene1 createSingleton(XScenario scenario) {
      assert (ChangeScenarioDefaultScene1.mSingleton == null);
      ChangeScenarioDefaultScene1.mSingleton = new ChangeScenarioDefaultScene1(scenario);
      return ChangeScenarioDefaultScene1.mSingleton;
    }

    private ChangeScenarioDefaultScene1(XScenario scenario) {
      super(scenario);
    }

    public void handleButtonPress() {
      System.out.println("Button Pressed in ChangeScenarioDefaultScene1");
      XCmdToChangeScene.execute((JSIApp) this.mScenario.getApp(), this.mReturnScene, null);
    }

    @Override
    public void handleMousePress(MouseEvent e) {

    }

    @Override
    public void handleMouseDrag(MouseEvent e) {
    }

    @Override
    public void handleMouseRelease(MouseEvent e) {
    }

    @Override
    public void handleKeyDown(KeyEvent e) {
    }

    @Override
    public void handleKeyUp(KeyEvent e) {
    }

    @Override
    public void updateSupportObjects() {

    }

    @Override
    public void renderWorldObjects(Graphics2D g2) {

    }

    @Override
    public void renderScreenObjects(Graphics2D g2) {

    }

    @Override
    public void getReady() {
      JSIApp app = (JSIApp) this.mScenario.getApp();
      app.switchPage("ChangePage");
    }

    @Override
    public void wrapUp() {

    }
  }
}
