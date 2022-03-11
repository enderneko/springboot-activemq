package enderneko.activemq.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

/**
 * @author enderneko
 * @date 2022/3/8
 */
@Component
public class TopicProducerDemo {
    @Autowired
    private Topic topic;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Scheduled(fixedDelay = 5000)
    public void publish() {
        jmsMessagingTemplate.convertAndSend(topic,
                "topic:" + UUID.randomUUID().toString().substring(0, 6));
        System.out.println("TopicProducerDemo.publish");
    }
}
