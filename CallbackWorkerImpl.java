import java.rmi.*;
import java.rmi.server.*;

public class CallbackWorkerImpl implements CallbackWorker{
	public CallbackWorkerImpl(){
		try {
			UnicastRemoteObject.exportObject(this);
			CallbackJobQueue server = 
				(CallbackJobQueue)Naming.lookup(
					"rmi:///JobQueue");
			//Register with the server, then just wait for jobs
			server.register(this); 
		} catch (Exception e){
			System.err.println("Failed to setup for RMI");
		}
	}

	public void processJob(Job newJob){
		newJob.process();
	}

	public static void main(String[] args){
		new CallbackWorkerImpl();
	}
}
