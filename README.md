4 microservices 
1. kafka-oder : 
	artifact-name: kafka-order
	group/package-name: com.mz.kafka
	dependencies:
		- spring-web 
		- spring-kafka
		- spring-data-jpa
		- lombok
		- devTools
		- database: H2

2. kafka-pattern
	artifact-name: kafka-pattern
	group/package-name: com.mz.kafka
	dependencies: 
		- sprign-kafka
		- devtools
		- Lombok
3. kafka-reward
	artifact-name: kafka-reward
        group/package-name: com.mz.kafka
	dependencies:
		- sprign-kafka
                - devtools
                - Lombok

4. kafka-storage
	artifact-name: kafka-storage
        group/package-name: com.mz.kafka
	dependencies:
		- sprign-kafka
                - devtools
                - Lombok
