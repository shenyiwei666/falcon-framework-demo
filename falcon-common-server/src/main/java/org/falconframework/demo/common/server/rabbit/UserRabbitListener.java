package org.falconframework.demo.common.server.rabbit;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * 功能说明
 *
 * @author 申益炜
 * @version 1.0.0
 * @date 2022/3/9
 */
@Slf4j
@Component
public class UserRabbitListener {

    @RabbitListener(queues = "queue.faceid.lineStatistic_local"/*, containerFactory = "falconRabbitContainerFactory"*/)
    public void receive(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        try {
            String receiveMsg = new String(message.getBody(), "utf-8");
            log.info("rabbitMQ接收消息：{}", receiveMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
