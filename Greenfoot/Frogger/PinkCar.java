import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class PinkCar extends Utilities
{
    private int speed = 1;
        
    public PinkCar()
    {
        this.getImage().scale(42,35);
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
