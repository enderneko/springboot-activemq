# springboot-activemq
SpringBoot ActiveMQ hello world

## Topic 持久订阅要点
```java
@Bean
public ConnectionFactory connectionFactory() {
    return new ActiveMQConnectionFactory(userName, password, url);
}

@Bean
public DestinationResolver destinationResolver() {
    return new DynamicDestinationResolver();
}

@Bean
public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setClientId(id);
    factory.setSubscriptionDurable(true);
    factory.setConnectionFactory(connectionFactory());
    factory.setDestinationResolver(destinationResolver());
    return factory;
}
```
