import greenfoot.*;  

public class Turtle extends Utilities
{
    public int dist;
    public boolean isDown = false;
    public boolean willGoDown = true;
    private int timer = 0;
    private int waiter;
    private int downTimer = 0;
    private int downCooldown = 25;
    
    public Turtle()
    {
        if ( random(100) > 80 ) {
            willGoDown = true;
        } 
    }
    
    public void act() 
    {
        ifGoDown();
        setLocation(getX()-1, getY());
        deleteAtEdge(this);
    }    
    
    public void giveDist(int dist)
    {
        this.dist = dist;
    }
    
    public void setWaiter(int time) 
    {
        waiter = time;
    }
    
    private void ifGoDown() 
    {
        Frog frog = (Frog) getOneIntersectingObject(Frog.class);
        if ( willGoDown ) {
            timer++;
        }
        if ( timer > waiter ) {
            this.isDown = true;
            this.setImage("froggerTurtleDown.PNG");
        }
        if ( this.isDown && downTimer < downCooldown ) {
            downTimer++;
        } else if ( this.isDown && frog == null ) {
            downCooldown = 0;
            this.isDown = false;
            this.setImage("froggerTurtleUp.PNG");
        }
    }
}
