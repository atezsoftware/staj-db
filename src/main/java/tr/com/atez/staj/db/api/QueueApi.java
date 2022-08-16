package tr.com.atez.staj.db.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/queue")
public class QueueApi {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@GetMapping("/test")
	public String testQueue(@RequestParam("mesaj") String mesaj) {
		rabbitTemplate.convertAndSend("", mesaj);
		return mesaj;
	}
}
