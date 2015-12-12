package pl.codesphere.spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.codesphere.spring.boot.domain.User;
import pl.codesphere.spring.boot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(Model model) {
		return "user/login";
	}
	
	@RequestMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "user/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String save(User user) {
		userService.save(user);
		return "redirect:/user/show/" + user.getId();
	}

	@RequestMapping("/show/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.findOne(id));
		return "user/show";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", userService.findAll());
		return "/user/index";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.findOne(id));
		return "user/new";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		userService.delete(id);
		return "redirect:/user/index";
	}
}
