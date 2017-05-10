package org.ho.tasks.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BasketItemService {
	
	@Autowired
	private BasketItemRepository basketItemRepository;
	
	/**
	 * Get all items within a shopping basket
	 * 
	 * @param shoppingBasketId 
	 * @return
	 */
	public List<BasketItem> getAllBasketItems(int shoppingBasketId){
		List<BasketItem> basketItems = new ArrayList<>();
		basketItemRepository.findByShoppingBasket(shoppingBasketId)
		.forEach(basketItems::add);
		
		return basketItems;
	}
	
	/**
	 * Get the Total Cost for all items within a shopping Basket
	 * 
	 * @param shoppingBasketId
	 * @return
	 */
	public long getTotalCost(int shoppingBasketId) {
		List<Long>totalCost = new ArrayList<Long>();
		getAllBasketItems(shoppingBasketId).stream().forEach(item ->totalCost.add(item.getUnitCost()));		
		
		return totalCost.stream().mapToLong(Long::longValue).sum();
	}
	
	/**
	 * Get a Basket item
	 * 
	 * @param id
	 * @return
	 */
	public BasketItem getBasketItem(String id) {
		
		//String basketItemIdString = Integer.toString(id);
		return basketItemRepository.findOne(id);
	}
	
	/**
	 * This will add a item to the database
	 * If the item name matches one that is already in the database
	 * then the quantity will be incremented by 1 instead
	 * 
	 * @param basketItem 
	 */
	public void addBasketItem(BasketItem basketItem) {
		List<BasketItem> duplicateItemList = basketItemRepository.findByName(basketItem.getName());
		
		if( duplicateItemList.isEmpty() == false) {
			if (duplicateFound(duplicateItemList)) {
				String existingId = duplicateItemList.parallelStream().findFirst().get().getId(); 
				basketItem.setId(existingId);
				basketItem.setQuantity(basketItem.getQuantity() + 1);
			}
		}
		
		basketItemRepository.save(basketItem);
	}
	
	/**
	 * Update A basket Item
	 * 
	 * @param id
	 * @param basketItem
	 */
	public void updateBasketItem(String id, BasketItem basketItem) {
		basketItemRepository.save(basketItem);
	}
	
	/**
	 * Delete a basket item
	 * If the item name matches one that is already in the database
	 * and the quantity is > 1
	 * then the quantity will be decreased by 1 instead
	 * 
	 * @param id
	 */
	public void deleteBasketItem(String id) {
		basketItemRepository.delete(id);
	}
	
	/**
	 * Checks if the list contains one element only
	 * 
	 * @param basketItems
	 * @return 
	 */
	public boolean duplicateFound(List<BasketItem> basketItems) {			
		return ((basketItems.isEmpty()) == false || (basketItems.size() == 1) ? false : true);
	}
}
