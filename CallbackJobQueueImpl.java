import java.rmi.*;
import java.rmi.server.*;

public class CallbackJobQueueImpl extends UnicastRemoteObject 
			implements CallbackJobQueue {

	CallbackWorker client;

	public CallbackJobQueueImpl() throws RemoteException {
		super();
		try {
			Naming.bind("rmi:///JobQueue",this);
			System.out.println("Server Ready");
		} catch (Exception e){
			System.err.println("Failed to start RMI server: "
				+ e.getMessage());
		}
		//Loop forever and give out jobs
		while(true){
			if (client != null){
				client.processJob(new Job());
			}
			try {
				Thread.sleep(1000); //Sleep for a sec.
			} catch(InterruptedException e){}
		}
	}

	public void register(CallbackWorker aClient){
		client = aClient;
	}

	public static void main(String[] args){
		try {
			new CallbackJobQueueImpl();
		} catch (RemoteException e){
			System.err.println("Failure with RMI server: "
				+ e.getMessage());
		}
	}
}
