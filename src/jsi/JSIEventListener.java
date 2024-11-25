package jsi;

import java.awt.event.*;

public class JSIEventListener implements MouseListener, MouseMotionListener, KeyListener {

  private JSIApp mJSI = null;

  public JSIEventListener(JSIApp jsi) {
    this.mJSI = jsi;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    JSIScene curScene = (JSIScene) mJSI.getScenarioMgr().getCurScene();
    curScene.handleMousePress(e);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    JSIScene curScene = (JSIScene) mJSI.getScenarioMgr().getCurScene();
    curScene.handleMouseDrag(e);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    JSIScene curScene = (JSIScene) mJSI.getScenarioMgr().getCurScene();
    curScene.handleMouseRelease(e);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    JSIScene curScene = (JSIScene) mJSI.getScenarioMgr().getCurScene();
    curScene.handleKeyDown(e);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    JSIScene curScene = (JSIScene) mJSI.getScenarioMgr().getCurScene();
    curScene.handleKeyUp(e);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }


  @Override
  public void mouseClicked(MouseEvent e) {
  }


  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }


  @Override
  public void mouseMoved(MouseEvent e) {
  }
}
