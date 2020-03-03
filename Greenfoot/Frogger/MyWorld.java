import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{

    public boolean debug = false;

    private int rows = 15; private int cols = 15;
    private int maxBusses = 3;
    private int currentBusses;
    private int sinceLastBus = 0;
    private int busDelay = 0;
    
    private int maxWhiteCars = 4; 
    private int currentWhiteCars;
    private int sinceLastWhiteCar = 0;
    private int whiteCarDelay;
    
    private int maxPinkCars = 3;
    private int currentPinkCars;
    private int sinceLastPinkCar = 0;
    private int pinkCarDelay = 0;
    
    private int maxRedCars = 3;
    private int currentRedCars;
    private int sinceLastRedCar = 0;
    private int redCarDelay = 0;

    
    public MyWorld()
    {    
        super(459, 630, 1);                
        addStartingObstacles();
        addFrog();
    }
    
    public void act()
    {
        busSpawner();
        whiteCarSpawner();
        redCarSpawner();
        pinkCarSpawner();
    }
    
    private void addStartingObstacles()
    {
        addObject( new Turtle(), 400, getHeight() - (9*38));
        
        //Busses
        addObject(new Bus(), 100, getHeight() - (7*38));
        addObject(new Bus(), 300, getHeight() - (7*38));
        
        //White Race Cars
        addObject( new WhiteRaceCar(), 150, getHeight() - (6 * 38));
        addObject( new WhiteRaceCar(), 270, getHeight() - (6 * 38));
        addObject( new WhiteRaceCar(), 390, getHeight() - (6 * 38));
        addObject( new WhiteRaceCar(), 470, getHeight() - (6 * 38));
        
        //Red Race Cars
        addObject( new RedRaceCar(), 130, getHeight() - (3 * 38));
        addObject( new RedRaceCar(), 240, getHeight() - (3 * 38));
        addObject( new RedRaceCar(), 350, getHeight() - (3 * 38));
        addObject( new RedRaceCar(), 10, getHeight() - (3 * 38));
        
        //Pink Cars
        addObject( new PinkCar(), 120, getHeight() - (5 * 38));
        addObject( new PinkCar(), 330, getHeight() - (5 * 38));
    }    
    
    private void busSpawner()
    {
        currentBusses = getObjects(Bus.class).size();
        if ( sinceLastBus > busDelay && currentBusses < maxBusses ) {
            sinceLastBus = 0;
            busDelay = Greenfoot.getRandomNumber(100) + 150;
            addObject( new Bus(), getWidth()-1, getHeight() - (7*38));
        }
        sinceLastBus++;
    }
    
    private void whiteCarSpawner()
    {
        currentWhiteCars = getObjects(WhiteRaceCar.class).size();
        if ( sinceLastWhiteCar > whiteCarDelay && currentWhiteCars < maxWhiteCars ) {
            sinceLastWhiteCar = 0; 
            whiteCarDelay = Greenfoot.getRandomNumber(50) + 75;
            addObject( new WhiteRaceCar(), 1, getHeight() - (6*38));
        }
        sinceLastWhiteCar++;
    }
    
    private void pinkCarSpawner()
    {
        currentPinkCars = getObjects(PinkCar.class).size();
        if ( sinceLastPinkCar > pinkCarDelay && currentPinkCars < maxPinkCars ) {
            sinceLastPinkCar = 0;
            pinkCarDelay = Greenfoot.getRandomNumber(75) + 125;
            addObject( new PinkCar(), getWidth()-1, getHeight() - (5*38));
        }
        sinceLastPinkCar++;
    }
    
    private void redCarSpawner()
    {
        currentRedCars = getObjects(RedRaceCar.class).size();
        if ( sinceLastRedCar > redCarDelay && currentRedCars < maxRedCars ) {
            sinceLastRedCar = 0;
            redCarDelay = Greenfoot.getRandomNumber(50) + 75;
            addObject(new RedRaceCar(), getWidth()-1, getHeight() - (3*38));
        }
        sinceLastRedCar++;
    }
    
    private void addFrog()
    {
        Frog frog = new Frog();
        frog.getImage().scale(35,35);
        addObject( frog, getWidth() / 2, getHeight() - 75 );  
    }
    
}
 //----

import greenfoot.*;

public class MyWorld extends World
{
    public MyWorld()
    {            
        super(459, 630, 1); 
        ThreeTurtleSpawner(getHeight() - (9*38));   
        ThreeTurtleSpawner(getHeight() - (12*38));  
        Frog frog = new Frog();
        frog.getImage().scale(35,35);
        addObject( frog, getWidth() / 2, getHeight() - 75 );         
    }
    
    public void act() {
        smallLogSpawner();
    }
    
    private void ThreeTurtleSpawner(int turtleHeight)
    {
        Turtle turtle = new Turtle();
        Turtle turtle2 = new Turtle();
        Turtle turtle3 = new Turtle();
        int waiter = Greenfoot.getRandomNumber(300) + 100;
        if ( turtle.willGoDown || turtle2.willGoDown || turtle3.willGoDown ) 
        {
            turtle.willGoDown = true; turtle2.willGoDown = true; turtle3.willGoDown = true;
            turtle.setWaiter(waiter); turtle2.setWaiter(waiter); turtle3.setWaiter(waiter);
        }
        int m_TurtleHeight = turtleHeight;
        addObject( turtle, getWidth(), m_TurtleHeight);
        addObject( turtle2, getWidth() - (turtle.getImage().getWidth()), m_TurtleHeight);
        addObject( turtle3, getWidth() - (turtle.getImage().getWidth() * 2), m_TurtleHeight);        
    }
    
    private void smallLogSpawner() 
    {
        if ( Greenfoot.getRandomNumber(100) > 85 ) {
            addObject( new SmallLog(), getWidth(), getHeight() - (10*38));
        }
    }
}
