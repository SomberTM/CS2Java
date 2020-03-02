import greenfoot.*;  

public class Turtle extends Utilities
{
    private int speed = 1;
    private boolean intersecting;
    private boolean hasInitialDist;
    private int dist = 0;
    
    public Turtle()
    {
    
    }
    
    public Turtle(int speed) 
    {
        this.speed = speed;
    }
    
    public void act() 
    {
        setLocation(getX() - 1, getY()); 
        checkForFrog();
        getWorld().showText("IS INTERSECTING?? " + intersecting, 200,180);
    }    
    
    private void checkForFrog()
    {
        Frog frog = (Frog) getOneIntersectingObject(Frog.class);
        if ( frog != null )
        {
            intersecting = true;
            if ( !hasInitialDist ) {
                dist = (frog.getX() - this.getX());
                hasInitialDist = true;
            }
            frog.setLocation((int)(getX() + dist), getY());
            getWorld().showText("Frog Pos: " + frog.getX() + ", " + frog.getY(), 200, 220);
        } else {
            intersecting = false;
        }
    }
}
