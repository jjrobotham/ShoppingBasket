package org.ho.tasks.shoppingBasket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingBasketService {
	
	@Autowired
	private ShoppingBasketRepository shoppingBasketRepository;
	
	/**
	 * @param id
	 * @return
	 */
	public ShoppingBasket getShoppingBasket(String id) {
		return shoppingBasketRepository.findOne(id);
	}
	
	/**
	 * @param shoppingBasket
	 */
	public void addShoppingBasket(ShoppingBasket shoppingBasket) {
		shoppingBasketRepository.save(shoppingBasket);
	}
	
	/**
	 * @param id
	 * @param shoppingBasket
	 */
	public void updateShoppingBasket(String id, ShoppingBasket shoppingBasket) {
		shoppingBasketRepository.save(shoppingBasket);
	}
	
	/**
	 * @param id
	 */
	public void deleteShoppingBasket(String id) {
		shoppingBasketRepository.delete(id);
	}

}
