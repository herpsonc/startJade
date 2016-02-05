package agents.example1;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * AgentB receives the message sent by agentA and print the content in the console.
 * That's all.
 * 
 * @author hc
 *
 */
public class AgentB extends Agent{
	
	protected void setup(){

		super.setup();

		//get the parameters given into the object[] (here no parameters are expected)
		final Object[] args = getArguments();
		if(args.length!=0){
			System.out.println("Malfunction when creating the receiver agent (AgentB)");

		}

		//Add the behaviours
		addBehaviour(new ReceiveMessage(this));

		System.out.println("the receiver agent "+this.getLocalName()+ " is started");

	}

	/**
	 * This method is automatically called after doDelete()
	 */
	protected void takeDown(){

	}

	
	/**************************************
	 * 
	 * 
	 * 				BEHAVIOURS
	 * 
	 * 
	 **************************************/

	/**
	 * This behaviour allows and agent to receive any message sent to 
	 * him with the inform performative, and print it in the console
	 * 
	 * @author hc
	 *
	 */
	public class ReceiveMessage extends SimpleBehaviour{
		
		private static final long serialVersionUID = 9088209402507795289L;

		private boolean finished=false;

		public ReceiveMessage(final Agent myagent) {
			super(myagent);

		}


		public void action() {
			//1) Create the template to verify
			final MessageTemplate msgTemplate = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
		
			//Not used here, but shows how to filter more precisely a message
			//MessageTemplate.and(
			//		MessageTemplate.MatchProtocol(MyOntology.PROTOCOL_NAME),
			//		MessageTemplate.and(
			//				MessageTemplate.MatchLanguage(MyOntology.LANGUAGE_NAME),
			//				MessageTemplate.MatchOntology(MyOntology.ONTOLOGY_NAME)
			//		)
			//)
			
			//2) retrieves the message from the inbox IF the template corresponds
			final ACLMessage msg = this.myAgent.receive(msgTemplate);
			
			//3) Process the message
			if (msg != null) {		
				System.out.println("<----Message received from "+msg.getSender().getLocalName()+" ,content= "+msg.getContent());
				this.finished=true;
			}else{
				System.out.println("Receiver - No message received");
				
				//the behaviours goes to sleep until a new message arrives in the inbox. 
				//Whithout the use of block(), the behaviour is spinning (never a good idea)
				block();
			}
		}

		public boolean done() {
			return finished;
		}

	}

}
