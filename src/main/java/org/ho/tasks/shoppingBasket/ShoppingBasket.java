/**
 * 
 */
package org.ho.tasks.shoppingBasket;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.ho.tasks.item.BasketItem;

/**
 * @author jrobotham
 *
 */
@Entity
public class ShoppingBasket {
	@Id
	@GeneratedValue
	private int id;
	
	public ShoppingBasket(int id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
