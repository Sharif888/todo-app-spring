package com.sprinboot.web.springdemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sprinboot.web.springdemo.model.Todo;
import com.sprinboot.web.springdemo.services.TodoService;
import com.sun.net.httpserver.Authenticator.Result;
 

@SessionAttributes("name")
@Controller
public class TodoController {
	@Autowired
	TodoService todoService;
	@InitBinder()
	public 	void initbinder(WebDataBinder binder)
	
	{
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
	// show the todos
	@RequestMapping(value = "/")
	public String defalut(ModelMap map)
	{
	return "login";
	}
	
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String getTodo(ModelMap modelMap) {
		String name = (String) modelMap.get("name");
//		gettting values from SessionAttributs
//		System.out.println("name in to do controller " + name);
		modelMap.put("todos", todoService.retriveTodo("sharif"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("sharif", "teli");
		map.put("Rizwan", "teli");
		map.put("Rashid", "Bagrodia");
		modelMap.put("map", map);
		return "list-todos";
	}

	// show the add todo page
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodo(ModelMap modelMap) {
		// creating the todo bean which is requested by the add todo post method
		modelMap.addAttribute("todo",new Todo(0,"sharif","default desc",new Date(),false));
		
		return "add-todo";
	}

	// adding the todo
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo( ModelMap modelMap,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors())
		{
			return "add-todo";
		}
		todoService.addTodo("sharif",todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}

	// delete a todo
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		if(id == 1)
		{
			throw new RuntimeException("something went wrong");
			
		}
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
		
	}
	
	
	//show update todo
	@RequestMapping(value =  "/update-todo",method = RequestMethod.GET)
	public String showUpdateTodo(ModelMap modelMap,@RequestParam int id)
	
	{
			Todo todo = todoService.retriveTodo(id);
			modelMap.addAttribute("todo",todo);
			return "add-todo";
	}
	@RequestMapping(value = "/update-todo",method = RequestMethod.POST  )
	public String updateTodo(ModelMap map,@Valid Todo todo,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "add-todo";
		}
	
		todo.setUser((String) map.getAttribute("name"));
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
		
	}
	
}
