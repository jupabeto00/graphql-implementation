package com.ha.graphql.infrastructure.driving.rest;

import com.ha.graphql.application.port.*;
import com.ha.graphql.domain.model.*;
import com.ha.graphql.infrastructure.driving.model.ProductFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
public class ProductController {

	private AccountService accountService;
	private CreditCardService creditCardService;
	private CreditService creditService;
	private ProductService productService;
	private MovementsService movementsService;
	private UserService userService;

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Autowired
	public void setCreditCardService(CreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}

	@Autowired
	public void setCreditService(CreditService creditService) {
		this.creditService = creditService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	public void setMovementsService(MovementsService movementsService) {
		this.movementsService = movementsService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@QueryMapping()
	public Account getAccount(@Argument Long id) {
			return accountService.retrieveById(id);
	}

	@QueryMapping()
	public CreditCard getCreditCard(@Argument Long id) {
		return creditCardService.retrieveById(id);
	}

	@QueryMapping()
	public Credit getCredit(@Argument Long id) {
		return creditService.retrieveById(id);
	}

	@QueryMapping()
	public List<Product> getProducts(@Argument ProductFilter filter) {
		if (filter.id() != null && filter.userId() != null) {
			Product product = productService.findByIdAndUserId(filter.id(), filter.userId());
			return product != null ? List.of(product) : List.of();
		} else if (filter.id() != null) {
			Product product = productService.retrieveById(filter.id());
			return product != null ? List.of(product) : List.of();
		} else if (filter.userId() != null) {
			return productService.retrieveByUserId(filter.userId());
		} else {
			throw new IllegalArgumentException("At least one field must be provided in filter");
		}
	}

	@QueryMapping()
	public User getUser(@Argument Long id, @Argument String name) {
		return userService.retrieveById(id);
	}

	@SchemaMapping
	public User user(Product product) {
		return userService.retrieveById(product.user().id());
	}

	@SchemaMapping
	public Account account(Product product) {
		return accountService.retrieveByProductId(product.id());
	}

	@SchemaMapping
	public CreditCard creditCard(Product product) {
		return creditCardService.retrieveByProductId(product.id());
	}

	@SchemaMapping
	public Credit credit(Product product) {
		return creditService.retrieveByProductId(product.id());
	}

	@SchemaMapping
	public List<Movements> movements(Account account) {
			return movementsService.retrieveMovementsByProductId(account.id());
	}

	@SchemaMapping
	public List<Movements> movements(CreditCard creditCard) {
		return movementsService.retrieveMovementsByProductId(creditCard.id());
	}

	@SchemaMapping
	public List<Movements> movements(Credit credit) {
		return movementsService.retrieveMovementsByProductId(credit.id());
	}
}
