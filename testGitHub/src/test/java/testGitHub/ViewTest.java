package testGitHub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.awt.Frame;
import java.awt.Label;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class ViewTest {

   private View view;

   @Before
   public void setUp() {
      // Initialize the View object before each test
      view = new View();
   }

   @Test
   public void testInitView() throws Exception {
      // Call the initView method
      view.initView();

      // Use reflection to access the private 'frame' field
      Field frameField = View.class.getDeclaredField("frame");
      frameField.setAccessible(true);
      Frame frame = (Frame) frameField.get(view);

      // Use reflection to access the private 'label' field
      Field labelField = View.class.getDeclaredField("label");
      labelField.setAccessible(true);
      Label label = (Label) labelField.get(view);

      // Assert that the label is correctly initialized
      assertNotNull("Label should be initialized", label);
      assertEquals("Label text should be 'Hello World'", "Hello World", label.getText());
      assertEquals("Label alignment should be centered", Label.CENTER, label.getAlignment());

      // Assert that the label is added to the frame
      assertEquals("Frame should contain one component", 1, frame.getComponentCount());
      assertSame("Label should be added to the frame", label, frame.getComponent(0));
   }
}
