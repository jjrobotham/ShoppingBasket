package org.ho.tasks.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.ho.tasks.shoppingBasket.ShoppingBasket;

@Entity
public class BasketItem {
	
	@Id
	@GeneratedValue
	private String id;
	
	private String name;
	private long unitCost;
	private int quantity;
	
	@ManyToOne
	private ShoppingBasket shoppingBasket;
	
	public BasketItem (String id, String name, long unitCost, int quantity, int shoppingBasketId) {
		super();
		this.id = id;
		this.name = name;
		this.unitCost = unitCost;
		this.quantity = quantity;
		this.shoppingBasket = new ShoppingBasket(shoppingBasketId);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the unitCost
	 */
	public long getUnitCost() {
		return unitCost;
	}

	/**
	 * @param unitCost the unitCost to set
	 */
	public void setUnitCost(long unitCost) {
		this.unitCost = unitCost;
	}

	/**
	 * @return the shoppingBasket
	 */
	public ShoppingBasket getShoppingBasket() {
		return shoppingBasket;
	}

	/**
	 * @param shoppingBasket the shoppingBasket to set
	 */
	public void setShoppingBasket(ShoppingBasket shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	

}
