import greenfoot.*; 

public class WhiteRaceCar extends Utilities
{
    private int speed = 2;
    
    public void act() 
    {
        MyWorld world = (MyWorld) getWorld();
        setLocation(getX() + speed, getY());
        if ( !world.debug ) {
            checkCollision();
            deleteAtEdge(this);
        }
    }    
    
    private void checkCollision() 
    {
        Frog frog = (Frog) getOneIntersectingObject(Frog.class);
        if ( frog != null ) {
            getWorld().showText("Which Killer: WhiteRaceCar", 250,300); 
            getWorld().removeObject(frog);
        }        
    }
}
