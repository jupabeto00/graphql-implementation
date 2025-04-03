package com.ha.graphql.infrastructure.driving.rest;

import com.ha.graphql.application.port.*;
import com.ha.graphql.domain.model.*;
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
	public Product getProduct(@Argument Long id) {
		return productService.retrieveById(id);
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
