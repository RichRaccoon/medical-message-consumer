package liga.medical.messageconsumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.common.dto.RabbitMessageDTO;
import liga.medical.messageconsumer.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMessageListener {
    private final ObjectMapper objectMapper;

    public RabbitMessageListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = RabbitConfig.DAILY_QUEUE_NAME)
    public void receiveDailyMessage(String message) {
        try {
            RabbitMessageDTO rabbitMessageDTO = objectMapper.readValue(message, RabbitMessageDTO.class);
            System.out.println(String.format("Сообщение [%s] получено из очереди [%s]", rabbitMessageDTO.getContent(), rabbitMessageDTO.getType()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitConfig.ALERT_QUEUE_NAME)
    public void receiveAlertMessage(String message) {
        try {
            RabbitMessageDTO rabbitMessageDTO = objectMapper.readValue(message, RabbitMessageDTO.class);
            System.out.println(String.format("Сообщение [%s] получено из очереди [%s]", rabbitMessageDTO.getContent(), rabbitMessageDTO.getType()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitConfig.ERROR_QUEUE_NAME)
    public void receiveErrorMessage(String message) {
        try {
            RabbitMessageDTO rabbitMessageDTO = objectMapper.readValue(message, RabbitMessageDTO.class);
            System.out.println(String.format("Сообщение [%s] получено из очереди [%s]", rabbitMessageDTO.getContent(), rabbitMessageDTO.getType()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
