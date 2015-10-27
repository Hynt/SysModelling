/**
 * @(#) Place.java
 */
public class Place
{
    private final String name;
    
    private int tokens;

    public Place( String name ) {
		this.name = name;
		this.tokens = 0;
	}

	public void incrementTokens( )
    {
        tokens++;
    }
    
    public void decrementTokens( )
    {
        tokens++;
    }
    
    public void removeAllTokens( )
    {
        tokens = 0;
    }
    
    

    public String getName( ) {
		return name;
	}

	public int getTokens( )
    {
        return tokens;
    }

    public boolean isStart( ) {
        return name.equals("p1");
    }

	@Override
    public String toString( ) {
		return "Place [name=" + name + ", tokens=" + tokens + "]";
	}
    
}
