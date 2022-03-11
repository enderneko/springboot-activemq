package enderneko.activemq.boot;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @author enderneko
 * @date 2022/3/8
 */
@Configuration
public class TopicConfig {
    @Value("${mytopic}")
    private String topicName;

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(topicName);
    }
}
