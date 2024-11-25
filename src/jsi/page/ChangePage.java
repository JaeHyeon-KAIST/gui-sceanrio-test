package jsi.page;

import jsi.JSIApp;
import jsi.scenario.ChangeScenario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePage {
  private JLabel label;
  private JPanel changeGUI;
  private JButton returnButton;

  public ChangePage(JSIApp app) {
    returnButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ChangeScenario scenario = (ChangeScenario) app.getScenarioMgr().getCurScene().getScenario();
        scenario.handleButtonPress();
      }
    });
  }

  // UI 컴포넌트에 접근하기 위한 메서드
  public JButton getButton() {
    return returnButton;
  }

  // GUI를 반환하는 메서드
  public JPanel getChangeGUI() {
    return changeGUI;
  }
}
