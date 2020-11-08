package co.edu.ucentral.domin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Aplication {

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "Home";
	}
}
