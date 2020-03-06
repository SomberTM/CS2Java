class Timer
{
    private int currentTime;
    private int goal;
    private int wait;
    private boolean ready = false;
    private boolean waiting = false;
    private boolean loopWaiting = false;
    
    public Timer()
    {
        currentTime = 0;
    }
    
    public void ready() { this.ready = true; }    
    public void stop() { this.ready = false; }
    public void stop(int stopAt) { this.ready = getTime() >= stopAt ? false : true; }
    
    public int getTime() { return this.currentTime; }
    
    public void count()
    {
        if ( this.ready )
        {
            currentTime++;
        }
    }
    
    public boolean past(int time)
    {
        if ( getTime() >= time )
        {
            return true;
        } 
        return false;
    }
    
    public boolean delay(int time)
    {
        if ( !waiting )
        {
            this.goal = getTime() + time;
            waiting = true;
        }
        if ( getTime() >= goal )
        {
            waiting = false;
            return !waiting;
        }
        return false;
    }
    
    public boolean loopDelay(int wait, int delay)
    {
        if ( !loopWaiting )
        {
            this.wait = wait;
            loopWaiting = true;
        }
        if ( this.past(this.wait) && this.delay(delay) )
        {
            this.wait += 100;
            return true;
        }   
        return false;
    }
       
}
