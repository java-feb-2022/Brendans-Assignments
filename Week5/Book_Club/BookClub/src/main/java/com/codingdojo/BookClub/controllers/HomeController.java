package com.codingdojo.BookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.BookClub.models.Book;
import com.codingdojo.BookClub.models.LoginUser;
import com.codingdojo.BookClub.models.User;
import com.codingdojo.BookClub.repositories.BookRepository;
import com.codingdojo.BookClub.services.BookService;
import com.codingdojo.BookClub.services.UserService;



@Controller
public class HomeController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser",new User());
		model.addAttribute("newLogin",new LoginUser());
		return "loginReg.jsp";
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("books", bookServ.getAllBooks());
		model.addAttribute("user", userServ.getUser((Long)session.getAttribute("user_id")));
		return "books.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		userServ.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin",new LoginUser());
			return "loginReg.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser",new User());
			return "loginReg.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		User user = userServ.getUser((Long)session.getAttribute("user_id"));
		model.addAttribute("user",user);
		model.addAttribute("newBook", new Book());
		return "newBook.jsp";
	}
	
	@PostMapping("/create/book")
	public String createBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		} else {
			bookServ.createBook(newBook);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("book",bookServ.getBook(id));
		model.addAttribute("user", userServ.getUser((Long)session.getAttribute("user_id")));
		return "showBook.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/delete/user/{id}")
	public String delete(@PathVariable("id") Long id) {
		userServ.delete(id);
		return "redirect:/home";
	}
}
