import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedRaceCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedRaceCar extends Utilities
{
    private int speed = 2;
    
    public RedRaceCar() 
    {
        this.getImage().scale(42, 35);
    }
    
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
