package enderneko.activemq.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.time.LocalDateTime;

/**
 * @author enderneko
 * @date 2022/3/8
 */
@Component
public class ProducerDemo {
    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Scheduled(fixedDelay = 5000)
    public void sendScheduled() {
        messagingTemplate.convertAndSend(queue, LocalDateTime.now().toString());
        System.out.println("ProducerDemo.sendScheduled");
    }
}
