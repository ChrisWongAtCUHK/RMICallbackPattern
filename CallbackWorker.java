public interface CallbackWorker extends java.rmi.Remote{
	public void processJob(Job newJob) throws java.rmi.RemoteException;
}
