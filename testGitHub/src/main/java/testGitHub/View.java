package testGitHub;

import java.awt.Frame;
import java.awt.Label;

public class View {

   private Frame frame;
   private Label label;

   public View() {

      frame = new Frame("AWT Hello World Example");
      frame.setSize(300, 200);
      frame.setVisible(true);
   }

   public void initView() {

      label = new Label("Hello World", Label.CENTER);
      frame.add(label);

   }

}
