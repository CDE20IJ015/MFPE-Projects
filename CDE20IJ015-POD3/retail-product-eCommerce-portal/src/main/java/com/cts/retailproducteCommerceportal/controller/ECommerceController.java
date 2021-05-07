package com.cts.retailproducteCommerceportal.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cts.retailproducteCommerceportal.client.AuthClient;
import com.cts.retailproducteCommerceportal.client.ProceedClient;
import com.cts.retailproducteCommerceportal.client.ProductClient;
import com.cts.retailproducteCommerceportal.client.VendorClient;
import com.cts.retailproducteCommerceportal.exception.CartNotFoundException;
import com.cts.retailproducteCommerceportal.exception.InternalServerErrorException;
import com.cts.retailproducteCommerceportal.exception.PasswordNotMatchException;
import com.cts.retailproducteCommerceportal.exception.ProductNotFoundException;
import com.cts.retailproducteCommerceportal.exception.UnauthorisedAccessException;
import com.cts.retailproducteCommerceportal.exception.WishlistNotFoundException;
import com.cts.retailproducteCommerceportal.model.CartRequest;
import com.cts.retailproducteCommerceportal.model.LoginCustomer;
import com.cts.retailproducteCommerceportal.model.Product;
import com.cts.retailproducteCommerceportal.model.UserAuth;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ECommerceController {

	@Autowired
	HttpSession httpSession;
	
	@Autowired
	AuthClient authClient;
	
	@Autowired
	ProductClient productClient;
	
	@Autowired
	VendorClient vendorClient;
	
	@Autowired
	ProceedClient proceedClient;
	
	@GetMapping("/login.html")
	public String login(@ModelAttribute("credentials") LoginCustomer credentials) {
		// System.out.println("this is a login page");
		httpSession.setAttribute("token", "");
		String preToken = (String) httpSession.getAttribute("token");
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>insideeeeeeeeeeeeeeeget" + preToken + "<<<<<");

		return "login";
	}
	
	@PostMapping("/login.html")
	public ModelAndView loginSubmit(@ModelAttribute("credentials") LoginCustomer credentials,RedirectAttributes redirectAttr)throws UnauthorisedAccessException, ProductNotFoundException, InternalServerErrorException {
		
		ModelAndView modelAndView = new ModelAndView();
		try {
			String loginStatus = authClient.login(credentials);
			String token = "Bearer " + loginStatus;
			log.info("TOKEN: {}",token);
			httpSession.setAttribute("token", token);
//			modelAndView.addObject("list", productClient.getProducts(token));
//			redirectAttr.addFlashAttribute("list", productClient.getProducts(token));
			modelAndView.setViewName("redirect:/index.html");
		}catch (FeignException e) {
			// TODO: handle exception
			int httpStatus = e.status();
			switch (httpStatus) {
			case 401:
				throw new UnauthorisedAccessException("Invalid Credentials");
			case 404:
				throw new ProductNotFoundException("No product Found");
			default:
				throw new InternalServerErrorException("Either product or authentication service is not working");
			}
		}
		return modelAndView;
	}
	
	@GetMapping("/wishlist.html")
	public ModelAndView wishlist() throws WishlistNotFoundException, UnauthorisedAccessException {
		String token = (String) httpSession.getAttribute("token");
		try {
			 proceedClient.getWishlist(token);
		} catch (Exception e) {
			ModelAndView modelAndView = new ModelAndView("cartEmpty");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("wishlist");
		modelAndView.addObject("list", proceedClient.getWishlist(token));
		return modelAndView;
	}
	
	@GetMapping("/cart.html")
	public ModelAndView cart() throws UnauthorisedAccessException, CartNotFoundException, InternalServerErrorException {
		
		String token = (String) httpSession.getAttribute("token");
		log.info("inside cart");
		try {
			proceedClient.getCart(token);
		} catch (FeignException e) {
			int status = e.status();
			switch(status) {
			case 404:
				throw new CartNotFoundException("Cart is Empty");
			case 401:
				throw new UnauthorisedAccessException("Invalid Token");
			default:
				throw new InternalServerErrorException("Proceed To Buy Microservice is not Working");
			}
		}
		
		ModelAndView modelAndView = new ModelAndView("cart");
		modelAndView.addObject("list", proceedClient.getCart(token).getBody());
		float productTotal = proceedClient.calculateTotalForCart(token).getBody();
		modelAndView.addObject("productTotal", productTotal);
		double delivery = proceedClient.getDeliveryCharge(token).getBody();
		modelAndView.addObject("delivery", delivery);
		modelAndView.addObject("total", productTotal + delivery);

		return modelAndView;
	}
	
	@GetMapping("/addProductToCart")
	public ModelAndView addProductToCart(@RequestParam("id") int productId)
			throws ProductNotFoundException, UnauthorisedAccessException, ParseException {
		String preToken = (String) httpSession.getAttribute("token");
		
		int custId = authClient.getId(preToken);
		int zip = authClient.getZip(preToken);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String expectedDeliveryDate = LocalDate.now().plusDays(7).format(formatter);
		proceedClient.addProductToCart(preToken, productId, expectedDeliveryDate);
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>insideeeeeeeeeeeeeeeeeeee|||||||||||||||" + custId
				+ "||||||||||||" + zip);
		
		return new ModelAndView("redirect:/cart.html");

	}

	@GetMapping("/updateCart/{productId}/{qty}")
	public ModelAndView updateCart(@PathVariable int productId, @PathVariable int qty)
			throws ProductNotFoundException, UnauthorisedAccessException, CartNotFoundException {
		
		log.info("qty={}",qty);
		String token = (String) httpSession.getAttribute("token");
		try {
			proceedClient.getCart(token);
		} catch (Exception e) {
			ModelAndView modelAndView = new ModelAndView("cartEmpty");
			return modelAndView;
		}
		proceedClient.updateCart(token, productId, qty);
		log.info("cart updated successfully");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/cart.html");
		return modelAndView;
	}

	@GetMapping("/signup.html")
	public String signup(@ModelAttribute("credentials") UserAuth credentials) {
		System.out.println("this is a signup page");
		return "signup";
	}
	
	@PostMapping("/signup.html")
	public ModelAndView signupSubmit(@ModelAttribute("credentials") UserAuth credentials) throws ProductNotFoundException, UnauthorisedAccessException {
		String preToken = (String) httpSession.getAttribute("token");

		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>insideeeeeeeeeeeeeee" + preToken + "<<<<<");
		log.info(credentials.toString());
		String token = "Bearer " + authClient.register(credentials);
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + token);
		httpSession.setAttribute("token", token);
		
		ModelAndView modelAndView = new ModelAndView("redirect:/index.html");
		
		return modelAndView;
	}
	
	@GetMapping("/searchByName/{search}")
	public ModelAndView searchProductByName(@PathVariable("search") String name,RedirectAttributes redirectAttr) throws ProductNotFoundException, UnauthorisedAccessException, InternalServerErrorException {
		String token = (String) httpSession.getAttribute("token");
		log.info("inside search by name method");
		ModelAndView modelAndView = new ModelAndView("redirect:/index.html");
		redirectAttr.addFlashAttribute("name", name);
		return modelAndView;
	}
	
	@RequestMapping("/index.html")
	public ModelAndView index(@ModelAttribute("name") String name) throws UnauthorisedAccessException, InternalServerErrorException, ProductNotFoundException {
		String token = (String) httpSession.getAttribute("token");
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			authClient.getValidity(token);
			log.info("Validation Successfull");
			if(!name.equals("")) {
				log.info(name);
				modelAndView.addObject("list",productClient.searchProductByName(token, name));
				modelAndView.addObject("message","Prdouct containing name \'"+name+"\'");
			}
			else {
				modelAndView.addObject("list",productClient.getProducts(token));
				modelAndView.addObject("message","Products");
			}
		}
		catch(FeignException f) {
			int status = f.status();
			switch(status) {
			case 401:
				throw new UnauthorisedAccessException("Invalid Token");
			case 404:
				String message;
				if(!name.equals(""))
					message = "Product name containing \'"+name+"\' is not found";
				else
					message = "No Products are there";
				throw new ProductNotFoundException(message);
			default:
				throw new InternalServerErrorException("Authentication Service is not working");
			}
		}
		return modelAndView;
	}
	
	@GetMapping("/removeCart/{productId}")
	public ModelAndView removeCart(@PathVariable int productId)
			throws ProductNotFoundException, UnauthorisedAccessException, CartNotFoundException {
		
		String token = (String) httpSession.getAttribute("token");
		ModelAndView modelAndView = new ModelAndView();
		if(proceedClient.getCart(token).getStatusCode() == HttpStatus.NOT_FOUND) {
			throw new CartNotFoundException("Cart is Empty");
		}

		proceedClient.deleteProductFromCart(token, productId);
		modelAndView.setViewName("redirect:/cart.html");

		return modelAndView;
	}
	
	@RequestMapping("/vendors/{productId}/{qty}")
	public ModelAndView vendors(@PathVariable int productId, @PathVariable int qty) throws UnauthorisedAccessException {
		// System.out.println("this is a vendor page");
		
		String token = (String) httpSession.getAttribute("token");
		ModelAndView modelAndView = new ModelAndView("vendor");
		// modelAndView.addObject("list", eCommerceClient.getProducts());
		modelAndView.addObject("list", vendorClient.getVendors(token, productId, qty));
		log.info("{}",vendorClient.getVendors(token, productId, qty));
		modelAndView.addObject("productId", productId);
		modelAndView.addObject("qty", qty);
		// log.info(">>>>>>>>>>>>>>>>>>>>"+proceedClient.getCart(token,
		// authClient.getId(token)).);
		return modelAndView;
	}
	
	@RequestMapping("/updateVendor/{vendorId}/{productId}/{qty}")
	public ModelAndView updateVendor(@PathVariable int vendorId, @PathVariable int productId, @PathVariable int qty)
			throws UnauthorisedAccessException, CartNotFoundException {
		// System.out.println("this is a vendor page");
		String token = (String) httpSession.getAttribute("token");
		log.info("inside update Vendor");
		proceedClient.updateVendor(token, productId, qty, vendorId);
		try {
			proceedClient.getCart(token);
			}catch (Exception e) {
				ModelAndView modelAndView = new ModelAndView("cartEmpty");
				return modelAndView;
			}
		ModelAndView modelAndView = new ModelAndView("redirect:/cart.html");

		return modelAndView;
	}
	
	@GetMapping("/")
	public String home() {
		String token = (String) httpSession.getAttribute("token");
		log.info(token);
		if(token != null) {
			return "redirect:index.html";
		}
		return "home";
	}
	
	@RequestMapping("/addProductRating/{productId}/{rating}")
	public ModelAndView addProductRating(@PathVariable int productId, @PathVariable int rating)
			throws ProductNotFoundException, UnauthorisedAccessException {
		String token = (String) httpSession.getAttribute("token");
		productClient.addProductRating(token, productId, rating);
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("list", productClient.getProducts(token));
		return modelAndView;
	}
}
