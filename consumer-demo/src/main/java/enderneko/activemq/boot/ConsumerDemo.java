package enderneko.activemq.boot;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author enderneko
 * @date 2022/3/8
 */
@Component
public class ConsumerDemo {
    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("Received:" + textMessage.getText());
    }
}
