package com.example.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productSercice;
	
	/*
	 * @RequestMapping(value="/addProduct",
	 * method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	 * public ResponseEntity<Products> addProduct(@RequestBody Products
	 * product){ productSercice.addProduct(product);
	 * 
	 * return new ResponseEntity<Products>(HttpStatus.OK);
	 * 
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView modelAndView = new ModelAndView();
		Products product = new Products();
		modelAndView.addObject("product", product);
		modelAndView.setViewName("addProduct");
		return modelAndView;
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@Valid Products products, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			
			modelAndView.setViewName("addProduct");
			return modelAndView;
		} else {
			productSercice.addProduct(products);
			modelAndView.addObject("successMessage", "product registered successfully");
			modelAndView.addObject("product", new Products());
			modelAndView.setViewName("addProduct");
			
			return modelAndView;
		}
		
	}
	
	/*
	 * @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	 * public ModelAndView createNewUser(@Valid User user, BindingResult
	 * bindingResult) { ModelAndView modelAndView = new ModelAndView(); User
	 * userExists = userService.findUserByEmail(user.getEmail()); if (userExists
	 * != null) { bindingResult.rejectValue("email", "error.user",
	 * "There is already a user registered with the email provided"); } if
	 * (bindingResult.hasErrors()) { modelAndView.setViewName("registration"); }
	 * else { userService.saveUser(user);
	 * modelAndView.addObject("successMessage",
	 * "User has been registered successfully"); modelAndView.addObject("user",
	 * new User()); modelAndView.setViewName("registration");
	 * 
	 * } return modelAndView; }
	 */
}
