package testingGround;


import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class FloorPlanGui extends JFrame
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private JFrame floorPlan;

  private JPanel liveView = new JPanel() {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*for each furniture in room
        g.drawRect(furniture.getPosX, furniture.getPosY, furniture.getLengthX, furniture.getLengthY);
        */
    }
   };

  
  public FloorPlanGui() {
    constructFrame();
    addComponents();
    floorPlan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    floorPlan.setVisible(true);
  }
  
  
  private void constructFrame() {
    floorPlan = new JFrame();
    floorPlan.setSize(1280, 800);
    floorPlan.setTitle( "Floor Plan Designer" );
    floorPlan.setLayout( new BorderLayout() );
  }

  private void addComponents() {
    floorPlan.add(liveView, BorderLayout.CENTER);
  }
}