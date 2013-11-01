Reference
	http://www.itec.uni-klu.ac.at/~harald/ds2001/rmi/pattern/pattern2.html


How to run:
	javac CallbackJobQueue.java 
	javac CallbackWorker.java 
	javac CallbackJobQueueImpl.java 
	javac CallbackWorkerImpl.java 
	rmic CallbackWorkerImpl 
	mic CallbackJobQueueImpl 
	miregistry & 
	java CallbackJobQueueImpl & 
	java CallbackWorkerImpl 
