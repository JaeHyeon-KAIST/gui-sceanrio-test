package jsi;

import jsi.page.ChangePage;
import jsi.page.DefaultPage;
import x.XApp;
import x.XLogMgr;
import x.XScenarioMgr;

import javax.swing.*;
import java.awt.*;

public class JSIApp extends XApp {
  // fields
  private JFrame frame;
  private JPanel cardPanel;
  private CardLayout cardLayout;
  private JSIScenarioMgr scenarioMgr;
  private JSIEventListener eventListener;
  private XLogMgr mLogMgr = null;

  @Override
  public XLogMgr getLogMgr() {
    return this.mLogMgr;
  }

  @Override
  public XScenarioMgr getScenarioMgr() {
    return this.scenarioMgr;
  }

  public JSIApp() {
    // create components.
    // 1) frame 2) other components 3) event listeners 4) managers
    this.frame = new JFrame("Scenario GUI Example");
    this.cardLayout = new CardLayout();
    this.cardPanel = new JPanel(this.cardLayout);
    this.eventListener = new JSIEventListener(this);
    this.scenarioMgr = new JSIScenarioMgr(this);
    this.mLogMgr = new XLogMgr();
    this.mLogMgr.setPrintOn(true);

    // connect event listeners
    this.cardPanel.addMouseListener(this.eventListener);
    this.cardPanel.addMouseMotionListener(this.eventListener);
    this.frame.setFocusable(true);
    this.frame.addKeyListener(this.eventListener);

    // build and show visual components.
    this.cardPanel.add(new DefaultPage(this).getDefaultGUI(), "DefaultPage");
    this.cardPanel.add(new ChangePage(this).getChangeGUI(), "ChangePage");
    this.frame.add(this.cardPanel);
    this.frame.setSize(400, 300);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setVisible(true);
  }

  public void switchPage(String pageName) {
    this.cardLayout.show(this.cardPanel, pageName);
  }

  public static void main(String[] args) {
    //create a JSI instance.
    JSIApp app = new JSIApp();
  }
}
