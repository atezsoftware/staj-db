package tr.com.atez.staj.db.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "staj")
public class MqListener {

	@RabbitHandler
	public void onMessage(String mesaj) {
		System.out.println("******* Listener mesajı aldı, mesaj: " + mesaj);
	}

}
