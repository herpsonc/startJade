# startJade

Using the Jade's documentation, you can hardly find how to launch a platform from source code. This project only aims to show you how simple it is to create and launch some agents with jade from the code through a few examples.

 - Example 1 :
  - 1 main container, 3 containers, 4 agents
  - Agent0 on container1
  - Agent1 and Agent3 on container2
  - Agent2 on container3
 
 Agent0 will send one message to agent1, that's all :)
  
 - Example 2 : 
  - 1 main container, 3 containers, 2 agents
  - AgentA and AgentSUM on container2
  
  AgentA will send 10 random values to agentSUM, which will compute the sum and return the result to agentA.
 
In both examples, the "pause" when launching the platform  is just here to give you the possibility to activate the sniffer agent from its GUI in order to sniff the agents and to graphically see the message passing process. In any case, I choose here to print the message sent/received on the standard output.
 
For sake of simplicity, the creation of the containers and of the agents is hardcoded, 
and I do not activate the sniffer by default. It is bad.


> Cédric Herpson, version 05/01/2011, 
> Written with [StackEdit](https://stackedit.io/).
