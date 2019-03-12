# This version is outdated

## Please, visit: https://gitlab.com/herpsonc/startJade/wikis/home for the latest.

# startJade

Using the [JADE](http://jade.tilab.com)'s documentation, you can hardly find how to launch a platform from source code. This project only aims to show you how simple it is to create and launch some agents with jade from the code through a few examples.

This is a maven project packaged for Eclipse.

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
 
The main class is the Principal.java file. The others implement the differents types of agents and their respectives behaviours. 

For sake of simplicity, the creation of the containers and of the agents is hardcoded, 
and I do not activate the sniffer by default. It is bad.


See the [wiki](https://github.com/herpsonc/startJade/wiki) for installation and execution details



> Cédric Herpson, version 05/01/2011, 
> Written with [StackEdit](https://stackedit.io/).
