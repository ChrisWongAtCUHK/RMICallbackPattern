/*
 * This class represents a simple object that does some processing.
 * In order to be passed in an RMI call objects must implement java.io.Serializable.
 * Serializable is an empty interface that
 * simply allows you to control which objects may be passed across the network and
 * which objects may not.
 */

public class Job implements java.io.Serializable{
	String msg;
	public Job(){
		//Just to distinguish one job from the next
		msg = Long.toString(System.currentTimeMillis());
	}
	
	public void process(){
		//Put complex algorithm here
		System.out.println("Job generated on server at: "+msg);
	}
}
