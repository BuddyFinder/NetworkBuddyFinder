# Alcubiere
## Source Agent
### Purpose
The source agent can be used to send logs to Kafka or RabbitMQ. In case of any error in sending the data, it defaults to writing logs on a configurable backup location.

### Steps to Run
1. Place the properties files at a location. 
2. Edit source-agent.properties as required. When using kafka, place all kafka configuration in kafka-config.properties
3. Run SourceAgentEmitter.java with following configuration:
  * Command Arguments: source Name, Input Directory path, blocking queue size, tracker file path and thread pool size 
  * Pass the properties file location as CONFIG_PATH VM argument.
  
##### Argument Description
* Source name: The name for this agent. Can be any string. 
* Input Directory: The log agent tails all the .log file in this folder, with names starting with a prefix. The prefix can be set in source-agent.properties using the key file.name.prefix.
* Blocking queue Size: The blocking queue size which, 
* Tracker File: The path of the folder where all the tracking files will be placed. These files keep track of the offset upto where a log file has been read.
* Thread pool size: Any integer value >=3.
