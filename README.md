# kafka-pub-sub
Apache Kafka Pub/Sub
# Few points to remember: <br/>
Generate spring boot project using spring initializr with following dependencies: <br/>
1. Spring Web <br/>
2. Spring for Apache Kafka <br/>

# Properties: <br/>
1. bootstrap.servers = list of brokers() more than one broker is called a cluster. <br/>
bootstrap-servers requires a comma-delimited list of host:port pairs to use for establishing the initial connections to the Kafka cluster. <br/>

2. group-id requires a unique string that identifies the consumer group to which this consumer belongs. <br/>

3. auto-offset-reset determines what to do when there is no initial offset in Kafka or if the current offset no longer exists on the server. <br/>

4. key-deserializer requires a deserializer class for keys. <br/>

5. value-deserializer requires a deserializer class for values. <br/>
