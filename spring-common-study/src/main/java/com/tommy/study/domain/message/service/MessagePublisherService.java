package com.tommy.study.domain.message.service;

import com.tommy.study.domain.message.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessagePublisherService {

  private final RedisTemplate<String, Object> normalRedisTemplate;
  private final RedisMessageListenerContainer redisMessageListenerContainer;
  private final MessageSubscribeService messageSubscribeService;

  public void publish(String channel, MessageDto messageDto) {
    redisMessageListenerContainer.addMessageListener(messageSubscribeService,
        new ChannelTopic(channel));
    normalRedisTemplate.convertAndSend(
        new ChannelTopic(channel).getTopic(), messageDto);
  }

  public void publish(String channel, String message) {
    redisMessageListenerContainer.addMessageListener(messageSubscribeService,
        new ChannelTopic(channel));
    normalRedisTemplate.convertAndSend(
        new ChannelTopic(channel).getTopic(), message);
  }
}
