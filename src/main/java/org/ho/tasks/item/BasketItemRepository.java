package org.ho.tasks.item;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BasketItemRepository extends CrudRepository<BasketItem, String>{
	
	 /**
	 * @param shoppingBasketId
	 * @return
	 */
	public List<BasketItem> findByShoppingBasket(int shoppingBasketId);
	
	public List<BasketItem> findByName(String itemName);
}
