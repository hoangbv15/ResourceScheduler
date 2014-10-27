package jpmorgan.cca.test.messagingsystem;

import jpmorgan.cca.test.messagingsystem.exceptions.TerminatedGroupException;

/***
 * ResourceScheduler has the responsibility to listen to incoming messages, and process them as resources 
 * become available. ResourceScheduler utilises ResourceManager, in order to invoke Resources to process 
 * Messages. ResourceScheduler can also cancel a group of Messages, or receive Termination nessages.
 * @author buivuhoang
 *
 */
public abstract class ResourceScheduler {
	
	/***
	 * This method is called by the user, to add a new message to the queue. The new message can be a normal
	 * message or a termination message.
	 * @param msg
	 * @throws TerminatedGroupException 
	 */
	public abstract void addMessage(Message msg) throws TerminatedGroupException;
	
	/***
	 * This method starts the main thread of ResourceScheduler. Once started, the scheduler will wait for 
	 * messages to arrive.
	 */
	public abstract void start();
	
	/***
	 * Cancels a group of message. Once cancelled, no more message of that group will be sent to the gateway.
	 * @param group
	 */
	public abstract void cancelGroup(String group);
	
	
}
