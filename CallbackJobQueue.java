public interface CallbackJobQueue extends java.rmi.Remote{
	void register(CallbackWorker aClient) throws java.rmi.RemoteException;
}
