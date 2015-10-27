/**
 * @(#) Metrics.java
 */
public class Metrics
{
    private float fitness;
    
    private float SBA;
    
    private float SSA;

    public Metrics( float fitness, float SBA, float SSA ) {
        this.fitness = fitness;
        this.SBA = SBA;
        this.SSA = SSA;
    }

    public float getFitness( ) {
        return fitness;
    }

    public void setFitness( float fitness ) {
        this.fitness = fitness;
    }

    public float getSBA( ) {
        return SBA;
    }

    public void setSBA( float SBA ) {
        this.SBA = SBA;
    }

    public float getSSA( ) {
        return SSA;
    }

    public void setSSA( float SSA ) {
        this.SSA = SSA;
    }
}
