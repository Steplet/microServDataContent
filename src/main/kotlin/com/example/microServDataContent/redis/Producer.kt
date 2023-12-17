package com.example.microServDataContent.redis

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.stereotype.Component

@Component
class Producer(val redisTemplate:RedisTemplate<String, Any>) {

    fun publish(channelTopic: String, mes:String){

        redisTemplate.convertAndSend(channelTopic, mes)

    }


}