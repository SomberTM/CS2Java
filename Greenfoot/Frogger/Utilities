import greenfoot.*;  

public class Utilities extends Actor
{
    protected String LEFT = "left";
    protected String RIGHT = "right";
    protected String UP = "up";
    protected String DOWN = "down";   
    
    protected boolean keyDown(String key) {
        return Greenfoot.isKeyDown(key);
    }
    
    protected int imageWidth(Actor actor) {
        return actor.getImage().getWidth();
    }
    
    protected int imageHeight(Actor actor) {
        return actor.getImage().getHeight();
    }    
    
    protected void rotateMove(Actor who, int rotation, int x, int y) {
        who.setRotation(rotation);
        who.setLocation(x, y);
    }
    
    protected void deleteAtEdge(Actor actor)
    {
        if ( actor.getX() >= getWorld().getWidth()-1 || actor.getX() <= 0 ) {
            getWorld().removeObject(actor);
        }
    }
       
}


