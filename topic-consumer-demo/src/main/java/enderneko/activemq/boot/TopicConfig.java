package enderneko.activemq.boot;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import org.springframework.stereotype.Component;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Topic;

/**
 * @author enderneko
 * @date 2022/3/8
 */
@Configuration
@EnableJms
public class TopicConfig {
    @Value("${mytopic}")
    private String topicName;

    @Value("${myid}")
    private String id;

    // @Bean
    public Topic topic() {
        return new ActiveMQTopic(topicName);
    }

    @Value("${spring.activemq.password}")
    private String password;

    @Value("${spring.activemq.user}")
    private String userName;

    @Value("${spring.activemq.broker-url}")
    private String url;

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
}
