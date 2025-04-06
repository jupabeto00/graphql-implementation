package com.ha.graphql.infrastructure.driving.rest;

import com.ha.graphql.application.port.*;
import com.ha.graphql.domain.model.*;
import com.ha.graphql.domain.model.graphql.CursorInfo;
import com.ha.graphql.domain.model.graphql.MovementsConnection;
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
	public Account getAccount(@Argument Long productId) {
		return accountService.retrieveByProductId(productId);
	}

	@QueryMapping()
	public CreditCard getCreditCard(@Argument Long productId) {
		return creditCardService.retrieveByProductId(productId);
	}

	@QueryMapping()
	public Credit getCredit(@Argument Long productId) {
		return creditService.retrieveByProductId(productId);
	}

	@QueryMapping()
	public List<Product> getProducts(@Argument ProductFilter filter) {
		if (filter.number() != null && filter.userId() != null) {
			Product product = productService.findByNumberAndUserId(filter.number(), filter.userId());
			return product != null ? List.of(product) : List.of();
		} else if (filter.number() != null) {
			Product product = productService.retrieveByNumber(filter.number());
			return product != null ? List.of(product) : List.of();
		} else if (filter.userId() != null) {
			return productService.retrieveByUserId(filter.userId());
		} else {
			throw new IllegalArgumentException("At least one field must be provided in filter");
		}
	}

	@QueryMapping()
	public User getUser(@Argument Long id) {
		return userService.retrieveById(id);
	}

	@QueryMapping
	public MovementsConnection getMovements(@Argument Long productId,
	                                        @Argument("first") Integer first,
	                                        @Argument("after") String after,
	                                        @Argument("last") Integer last,
	                                        @Argument("before") String before
	) {

		return movementsService.retrieveMovementsByProductIdPaginated(productId, new CursorInfo(first, after, last, before) );
	}

		@SchemaMapping
		public List<Movements> movements (Account account){

			return movementsService.retrieveMovementsByProductId(account.product().id());
		}

		@SchemaMapping
		public List<Movements> movements (CreditCard creditCard){
			return movementsService.retrieveMovementsByProductId(creditCard.product().id());
		}

		@SchemaMapping
		public List<Movements> movements (Credit credit){
			return movementsService.retrieveMovementsByProductId(credit.product().id());
		}
	}
