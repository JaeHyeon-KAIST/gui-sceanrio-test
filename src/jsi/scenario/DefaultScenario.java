package jsi.scenario;

import jsi.JSIApp;
import jsi.JSIScene;
import x.XApp;
import x.XCmdToChangeScene;
import x.XScenario;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class DefaultScenario extends XScenario {
  private DefaultScenarioScene1 defaultScene = null; // DefaultScene 참조

  // singleton pattern
  private static DefaultScenario mSingleton = null;


  public static DefaultScenario getSingleton() {
    assert (DefaultScenario.mSingleton != null);
    return mSingleton;
  }

  public static DefaultScenario createSingleton(XApp app) {
    assert (DefaultScenario.mSingleton == null);
    DefaultScenario.mSingleton = new DefaultScenario(app);
    return DefaultScenario.mSingleton;
  }

  private DefaultScenario(XApp app) {
    super(app);

    // Scene 생성
    this.defaultScene = DefaultScenarioScene1.createSingleton(this);
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

  public DefaultScenarioScene1 getDefaultScene() {
    return this.defaultScene;
  }

  public static class DefaultScenarioScene1 extends JSIScene {
    //  singleton
    private static DefaultScenarioScene1 mSingleton = null;

    public static DefaultScenarioScene1 getSingleton() {
      assert (DefaultScenarioScene1.mSingleton != null);
      return DefaultScenarioScene1.mSingleton;
    }

    public static DefaultScenarioScene1 createSingleton(XScenario scenario) {
      assert (DefaultScenarioScene1.mSingleton == null);
      DefaultScenarioScene1.mSingleton = new DefaultScenarioScene1(scenario);
      return DefaultScenarioScene1.mSingleton;
    }

    private DefaultScenarioScene1(XScenario scenario) {
      super(scenario);
    }

    public void handleButtonPress() {
      System.out.println("Button Pressed in DefaultScene");
      XCmdToChangeScene.execute((JSIApp) this.mScenario.getApp(), ChangeScenario.ChangeScenarioDefaultScene1.getSingleton(), this);
    }

    @Override
    public void handleMousePress(MouseEvent e) {
      System.out.println("Mouse Pressed in DefaultScene Screen");
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
      System.out.println("Mouse Pressed in DefaultScene");
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
      app.switchPage("DefaultPage");
    }

    @Override
    public void wrapUp() {

    }
  }
}
