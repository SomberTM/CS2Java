import greenfoot.*;  
import greenfoot.*;  

public class Frog extends Utilities
{
    private int leapTimer = 0;
    private int leapCooldown = 5;
   
    public void act() 
    {
        testEndConditions();
        EventHandler();
    }   
    
    private void EventHandler() {
        if ( leapTimer > leapCooldown ) {
            if ( keyDown(UP) ) {
                rotateMove(this, 0, getX(), getY()-38);
            } else if ( keyDown(RIGHT) ) {
                rotateMove(this, 90, getX()+33, getY());
            } else if ( keyDown(LEFT) ) {
                rotateMove(this, 270, getX()-33, getY());
            } else if ( keyDown(DOWN) ) {
                rotateMove(this, 180, getX(), getY()+38);
            }
            leapTimer = 0;
        }
        leapTimer++;
    }
    
    private void testEndConditions() {
        if ( getY() < imageHeight(this) - (imageHeight(this) / 2) ) {
            Greenfoot.stop();
        }     
    }
}
