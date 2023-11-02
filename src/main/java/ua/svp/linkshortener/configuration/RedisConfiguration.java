package ua.svp.linkshortener.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import ua.svp.linkshortener.model.ShortLinkModel;

@Configuration
public class RedisConfiguration {

    @Bean
    RedisTemplate<String, ShortLinkModel> template(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, ShortLinkModel> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
