package jsi.page;

import jsi.JSIApp;
import jsi.scenario.DefaultScenario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultPage {
  private JButton pageMoveButton;
  private JLabel label;
  private JPanel defaultGUI;

  public DefaultPage(JSIApp app) {

    pageMoveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        DefaultScenario scenario = (DefaultScenario) app.getScenarioMgr().getCurScene().getScenario();
        scenario.handleButtonPress();
      }
    });
  }

  // UI 컴포넌트에 접근하기 위한 메서드
  public JButton getButton() {
    return pageMoveButton;
  }

  // GUI를 반환하는 메서드
  public JPanel getDefaultGUI() {
    return defaultGUI;
  }
}
