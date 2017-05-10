/**
 * 
 */
package org.ho.tasks.item;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.ho.tasks.shoppingBasket.ShoppingBasket;
import org.ho.tasks.shoppingBasket.ShoppingBasketRepository;
import org.ho.tasks.shoppingBasket.ShoppingBasketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jrobotham
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class BasketItemServiceTests {
	@Mock
	private BasketItemRepository basketItemRepository;
	
	@InjectMocks
	private BasketItemService basketItemService;
	
	private int shoppingBasketId = 1;
	
	@Before(value = "")
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllBasketItems(){
		List<BasketItem> basketItemList = new ArrayList<BasketItem>();
		basketItemList.add(new BasketItem("BI1","BasketItem Sample 1",(long)10.09, 1, shoppingBasketId));
		basketItemList.add(new BasketItem("BI2","BasketItem Sample 2",(long)20.90, 2, shoppingBasketId));
		basketItemList.add(new BasketItem("BI3","BasketItem Sample 3",(long)14.99, 2, shoppingBasketId));
		when(basketItemRepository.findByShoppingBasket(shoppingBasketId)).thenReturn(basketItemList);
		
		List<BasketItem> result = basketItemService.getAllBasketItems(shoppingBasketId);
		assertEquals(3, result.size());
	}
	
	@Test
	public void testGetBasketItemById(){
		BasketItem BasketItem = new BasketItem("BI1","BasketItem Sample 1",(long) 12.99, 3, this.shoppingBasketId);
		when(basketItemRepository.findOne("BI1")).thenReturn(BasketItem);
		BasketItem result = basketItemService.getBasketItem("BI1");
		assertEquals("BI1", result.getId());
		assertEquals("BasketItem Sample 1", result.getName());
		assertEquals(3, result.getQuantity());
	}
	
	@Test
	public void saveToDo(){
		BasketItem BasketItem = new BasketItem("BI4","BasketItem Sample 4",(long) 10.00, 10, shoppingBasketId);
		basketItemRepository.save(BasketItem);
		//TODO add return object
		BasketItem result = basketItemService.getBasketItem("BI4");
		assertEquals("BI4", result.getId());
		assertEquals("BasketItem Sample 4", result.getName());
		assertEquals(11, result.getQuantity());
	}
	
	@Test
	public void removeToDo(){
		BasketItem BasketItem = new BasketItem("BI4","BasketItem Sample 4",(long) 19.99, 1, shoppingBasketId);
		basketItemService.deleteBasketItem("BI4");
        verify(basketItemRepository, times(1)).delete(BasketItem);
	}
}
