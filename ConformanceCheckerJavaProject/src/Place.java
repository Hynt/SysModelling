/**
 * @(#) Place.java
 */
public class Place
{
    private String name;
    
    private int tokens;
    
    private PetriNet petriNet;
    
    //TODO not needed fields
    private Transition transitionTP;
    
    private Transition transitionPT;

    public Place( String name ) {
		super();
		this.name = name;
		this.tokens = 0;
	}

	public void incrementTokens( )
    {
        
    }
    
    public void decrementTokens( )
    {
        
    }
    
    public void removeAllTokens( )
    {
        
    }
    
    

    public String getName( ) {
		return name;
	}

	public int getTokens( )
    {
        return 0;
    }

    public boolean isStart( ) {
        return start;
    }

	@Override
    public String toString( ) {
		return "Place [name=" + name + ", tokens=" + tokens + "]";
	}
    
}
