package tr.com.atez.staj.db.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	static final String Q_NAME = "staj";
	static final String EXCHANGE_NAME = "staj";

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		rabbitTemplate.setExchange(EXCHANGE_NAME);

		return rabbitTemplate;
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public Queue createQueue() {
		return new Queue(Q_NAME, true);
	}

	@Bean
	public Exchange exchange() {
		return new DirectExchange(EXCHANGE_NAME, true, false);
	}

	@Bean
	public Binding queueBinding() {
		return new Binding(Q_NAME, Binding.DestinationType.QUEUE, EXCHANGE_NAME, "", null);
	}
}
