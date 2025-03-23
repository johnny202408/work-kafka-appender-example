```markdown
# Kafka Logging Appender Demo

This project demonstrates how to implement Kafka logging appender with Logback in a Groovy application. It shows how to forward application logs to Apache Kafka using the logback-kafka-appender.

## Prerequisites

- Java 8 or higher
- Gradle
- Apache Kafka running locally or a Kafka cluster connection
- Basic understanding of logging concepts and Kafka

## Project Setup

The project uses the following key dependencies:

- Groovy 4.0.14
- Logback 1.4.14
- Logback Kafka Appender 0.2.0-RC2
- Logstash Logback Encoder 7.0

## Configuration

### Gradle Dependencies

The project includes necessary dependencies for:
- Logging (SLF4J, Log4j, Logback)
- Kafka integration
- Structured logging with Logstash encoder

### Logging Configuration

To configure the Kafka appender, create a `logback.xml` file in `src/main/resources/` with your Kafka broker settings and logging patterns.

Example configuration:
```xml
<configuration>
    <appender name="KAFKA" class="com.github.danielwegener.logback.kafka.KafkaAppender">
        <encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
        <topic>logs</topic>
        <keyingStrategy class="com.github.danielwegener.logback.kafka.keying.NoKeyKeyingStrategy"/>
        <deliveryStrategy class="com.github.danielwegener.logback.kafka.delivery.AsynchronousDeliveryStrategy"/>

        <producerConfig>bootstrap.servers=localhost:9092</producerConfig>
    </appender>

    <root level="INFO">
        <appender-ref ref="KAFKA"/>
    </root>
</configuration>
```

## Usage

1. Start your Kafka broker
2. Configure the `logback.xml` with your Kafka broker details
3. Run the application using:
```bash
./gradlew run
```

## Features

- Asynchronous log delivery to Kafka
- Structured logging using Logstash format
- Configurable logging patterns and levels
- Support for multiple logging frameworks (SLF4J, Log4j)

## Project Structure

```
src/
├── main/
│   ├── groovy/
│   │   └── org/
│   │       └── example/
│   │           └── App.groovy
│   └── resources/
│       └── logback.xml
└── test/
    └── groovy/
```

## Logging Examples

```groovy
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Example {
    private static final Logger logger = LoggerFactory.getLogger(Example.class)
    
    void demonstrateLogging() {
        logger.info("This message will be sent to Kafka")
        logger.error("Error message with exception", new Exception("Sample exception"))
    }
}
```

## Monitoring

You can monitor the logs in Kafka using:
```bash
kafka-console-consumer --bootstrap-server localhost:9092 --topic logs --from-beginning
```

## Troubleshooting

Common issues and solutions:
1. Kafka Connection Issues
   - Verify Kafka broker is running
   - Check broker connection settings in `logback.xml`
   
2. Missing Logs
   - Verify log level configuration
   - Check Kafka topic exists
   - Ensure proper appender configuration

## Contributing

Feel free to submit issues and enhancement requests.

## License

MIT License

## References

- [Logback Documentation](https://logback.qos.ch/)
- [Kafka Appender Documentation](https://github.com/danielwegener/logback-kafka-appender)
- [Logstash Encoder Documentation](https://github.com/logstash/logstash-logback-encoder)
```
