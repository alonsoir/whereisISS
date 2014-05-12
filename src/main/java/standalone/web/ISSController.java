package standalone.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ISSController {

	@RequestMapping("/iss")
	public String listQuakes() {
		return "iss/list";
	}
}
