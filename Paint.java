import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.swing.*;


/**
 this part is for editing the photo if the use wants to create something new 
 with the photo they can edit it here.
 */

public class Paint extends JApplet{

	public Paint() {
		 //creating a window and some operations
		 JFrame window = new JFrame("Edit Photo");
	      PaintPanel content = new PaintPanel();
	    
	      window.setContentPane(content);
	      window.setSize(600,500);
	      window.setLocation(100,100);
	      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      window.setVisible(true);
	      init();
		}
   
   /*public static void main(String[] args) {
      JFrame window = new JFrame("Edit Photo");
      SimplePaintPanel content = new SimplePaintPanel();
      window.setContentPane(content);
      window.setSize(600,500);
      window.setLocation(100,100);
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setVisible(true);

   }*/
   
  
   
   public void init() {
      setContentPane( new PaintPanel() );
   }

   public static class PaintPanel extends JPanel
               implements MouseListener, MouseMotionListener {
      
	   //here is the constant numbers for the colors.
      private final static int BLACK = 0,
                       		RED = 1,     
                       		GREEN = 2,   
                       		BLUE = 3, 
                       		CYAN = 4,   
                       		MAGENTA = 5,
                       		YELLOW = 6;
      
      private int curColor = BLACK; 		//constant choosen current color.
      private int previousX, previousY;     // The previous location of the mouse.   
      private boolean dragging;      		// Check if the user is drawing true.    
      private Graphics graphicsDraws; 
                           
      
      
      /**
       * Constructor for SimplePaintPanel class sets the background color to be
       * white and sets it to listen for mouse events on itself.
       */
      PaintPanel() {
         setBackground(Color.WHITE);
         addMouseListener(this);
         addMouseMotionListener(this);
      }
      
            
      /**
       * main contents of the panel
       */
      public void paintComponent(Graphics g) {
         
         super.paintComponent(g);  // Fill with background color (white).
         
         int width = getWidth();    // Width of the panel.
         int height = getHeight();  // Height of the panel.
         
         int colorSpacing = (height - 56) / 7;

         g.setColor(Color.GRAY);
         g.drawRect(0, 0, width-1, height-1);
         g.drawRect(1, 1, width-3, height-3);
         g.drawRect(2, 2, width-5, height-5);
         
         g.fillRect(width - 56, 0, 56, height);
         
         g.setColor(Color.WHITE);
         g.fillRect(width-53,  height-53, 50, 50);
         g.setColor(Color.BLACK);
         g.drawRect(width-53, height-53, 49, 49);
         g.drawString("CLEAR", width-48, height-23); 
         
         /* Draw the seven color rectangles. */
         
         g.setColor(Color.BLACK);
         g.fillRect(width-53, 3 + 0*colorSpacing, 50, colorSpacing-3);
         g.setColor(Color.RED);
         g.fillRect(width-53, 3 + 1*colorSpacing, 50, colorSpacing-3);
         g.setColor(Color.GREEN);
         g.fillRect(width-53, 3 + 2*colorSpacing, 50, colorSpacing-3);
         g.setColor(Color.BLUE);
         g.fillRect(width-53, 3 + 3*colorSpacing, 50, colorSpacing-3);
         g.setColor(Color.CYAN);
         g.fillRect(width-53, 3 + 4*colorSpacing, 50, colorSpacing-3);
         g.setColor(Color.MAGENTA);
         g.fillRect(width-53, 3 + 5*colorSpacing, 50, colorSpacing-3);
         g.setColor(Color.YELLOW);
         g.fillRect(width-53, 3 + 6*colorSpacing, 50, colorSpacing-3); 
         g.setColor(Color.WHITE);
         g.drawRect(width-55, 1 + curColor*colorSpacing, 53, colorSpacing);
         g.drawRect(width-54, 2 + curColor*colorSpacing, 51, colorSpacing-2);
         
      } // end paintComponent()
      
      
      /**
       * mouse listener to change color with user's requests
       */
      private void changeColor(int y) {
         
         int width = getWidth();           // Width of app
         int height = getHeight();         // Height of app
         int colorSpacing = (height - 56) / 7;
         int newColor = y / colorSpacing;       // choose color 
         
         if (newColor < 0 || newColor > 6)      // Make sure the color number is valid.
            return;
         
         Graphics g = getGraphics();
         g.setColor(Color.GRAY);
         g.drawRect(width-55, 1 + curColor*colorSpacing, 53, colorSpacing);
         g.drawRect(width-54, 2 + curColor*colorSpacing, 51, colorSpacing-2);
         curColor = newColor;
         g.setColor(Color.WHITE);
         g.drawRect(width-55, 1 + curColor*colorSpacing, 53, colorSpacing);
         g.drawRect(width-54, 2 + curColor*colorSpacing, 51, colorSpacing-2);
         g.dispose();
         
      } 
      
      /**
 			to be used to draw the user's sketch in the current color.
       */
      private void setUpDrawingGraphics() {
    	  graphicsDraws = getGraphics();
         switch (curColor) {
         case BLACK:
        	 graphicsDraws.setColor(Color.BLACK);
            break;
         case RED:
        	 graphicsDraws.setColor(Color.RED);
            break;
         case GREEN:
            graphicsDraws.setColor(Color.GREEN);
            break;
         case BLUE:
        	 graphicsDraws.setColor(Color.BLUE);
            break;
         case CYAN:
        	 graphicsDraws.setColor(Color.CYAN);
            break;
         case MAGENTA:
        	 graphicsDraws.setColor(Color.MAGENTA);
            break;
         case YELLOW:
        	 graphicsDraws.setColor(Color.YELLOW);
            break;
         }
      } // end setUpDrawingGraphics()
      
      
      /**
       * There are three possible responses, depending on where the user clicked:  
       * Change the current color, clear the drawing, or start drawing a curve.  
       */
      public void mousePressed(MouseEvent evnt) {
         
         int x = evnt.getX();   // x-coordinate where the user clicked.
         int y = evnt.getY();   // y-coordinate where the user clicked.
         
         int width = getWidth();    // Width of the panel.
         int height = getHeight();  // Height of the panel.
         
         if (dragging == true)  
        	 return;
         
         if (x > width - 53) {
 
            if (y > height - 53)
               repaint();       //  Clicked on "CLEAR button".
            else
               changeColor(y);  // Clicked on the color palette.
         }
         else if (x > 3 && x < width - 56 && y > 3 && y < height - 3) {
  
            previousX = x;
            previousY = y;
            dragging = true;
            setUpDrawingGraphics();
         }
         
      } 
      
      public void mouseReleased(MouseEvent evnt) {
         if (dragging == false)
            return;  // Nothing to do because the user isn't drawing.
         dragging = false;
         graphicsDraws.dispose();
         graphicsDraws = null;
      }
      

      public void mouseDragged(MouseEvent evnt) {
         
         if (dragging == false)
            return;  // Nothing to do because the user isn't drawing.
         
         int x = evnt.getX();   // x-coordinate of mouse.
         int y = evnt.getY();   // y-coordinate of mouse.
         
         if (x < 3)                          // Adjust the value of x,
            x = 3;                           //   to make sure it's in
         if (x > getWidth() - 57)       //   the drawing area.
            x = getWidth() - 57;
         
         if (y < 3)                          // Adjust the value of y,
            y = 3;                           //   to make sure it's in
         if (y > getHeight() - 4)       //   the drawing area.
            y = getHeight() - 4;
         
         graphicsDraws.drawLine(previousX, previousY, x, y);  // Draw the line.
         
         previousX = x;  // Get ready for the next line segment in the curve.
         previousY = y;
         
      } // end mouseDragged()
      
      
      public void mouseEntered(MouseEvent evnt) { }   // Some empty routines.
      public void mouseExited(MouseEvent evnt) { }    //    (Required by the MouseListener
      public void mouseClicked(MouseEvent evnt) { }   //    and MouseMotionListener
      public void mouseMoved(MouseEvent evnt) { }     //    interfaces).
      
      
   }


} 