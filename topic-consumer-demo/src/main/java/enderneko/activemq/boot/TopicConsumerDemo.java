package enderneko.activemq.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author enderneko
 * @date 2022/3/8
 */
@Component
public class TopicConsumerDemo {
    @Value("${myid}")
    private String id;

    @JmsListener(destination = "${mytopic}", id = "${myid}", subscription = "${mytopic}")
    public void listen(TextMessage textMessage) throws JMSException {
        System.out.println("Received [" + id + "]:" + textMessage.getText());
    }
}
