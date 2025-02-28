package com.tommy.study.domain.message.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tommy.study.domain.message.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessageSubscribeService implements MessageListener {

  private final RedisTemplate<String, Object> messageRedisTemplate;
  private final RedisTemplate<String, Object> normalRedisTemplate;
  private final ObjectMapper objectMapper;


  @Override
  public void onMessage(Message message, byte[] pattern) {
    try {
      String publishMessage = normalRedisTemplate
          .getStringSerializer().deserialize(message.getBody());

      MessageDto messageDto = objectMapper.readValue(publishMessage, MessageDto.class);

      log.info("Redis Subscribe Channel : " + messageDto.getMessage());
      log.info("Redis SUB Message : {}", publishMessage);

      normalRedisTemplate.opsForValue().set(messageDto.getMessageUniqueId(), messageDto);

      var savedMessages = normalRedisTemplate.opsForValue().get(messageDto.getMessageUniqueId());
      log.info("savedMessages : {}", savedMessages);
    } catch (JsonMappingException e) {
      throw new RuntimeException(e);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}