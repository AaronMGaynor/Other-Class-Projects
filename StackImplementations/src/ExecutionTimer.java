
public class ExecutionTimer {
	  private long start;
	  private long end;

	  public ExecutionTimer() {
	    reset();
	  }

	  public void start() {
	    start = System.currentTimeMillis();
	  }

	  public void end() {
	    end = System.currentTimeMillis();
	  }

	  public double durationInSeconds(){
	    return ((end-start)/1000.0);
	  }

	  public void reset() {
	    start = 0;  
	    end   = 0;
	  }
	}