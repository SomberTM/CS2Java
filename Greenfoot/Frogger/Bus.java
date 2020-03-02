import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bus extends Utilities
{
    private int speed = 1;
    
    public void act() 
    {
        MyWorld world = (MyWorld) getWorld();
        setLocation(getX() - speed, getY());
        if ( !world.debug ) {
            checkCollision();
            deleteAtEdge(this);
        }
    }    

    private void checkCollision()
    {
        Frog frog = (Frog) getOneIntersectingObject(Frog.class);
        if ( frog != null ) {
            getWorld().removeObject(frog);
        }
    }
}
