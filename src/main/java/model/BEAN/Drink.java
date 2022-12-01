package model.BEAN;

public class Drink {
	String ID_Drink, Name_Drink, Ingredient, IMG, Type;
	Double Price;
	
	public Drink(String iD_Drink, String name_Drink,String type, String ingredient, String iMG, Double price) {
		super();
		ID_Drink = iD_Drink;
		Name_Drink = name_Drink;
		Ingredient = ingredient;
		IMG = iMG;
		Price = price;
		this.Type = type;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getID_Drink() {
		return ID_Drink;
	}
	public void setID_Drink(String iD_Drink) {
		ID_Drink = iD_Drink;
	}
	public String getName_Drink() {
		return Name_Drink;
	}
	public void setName_Drink(String name_Drink) {
		Name_Drink = name_Drink;
	}
	public String getIngredient() {
		return Ingredient;
	}
	public void setIngredient(String ingredient) {
		Ingredient = ingredient;
	}
	public String getIMG() {
		return IMG;
	}
	public void setIMG(String iMG) {
		IMG = iMG;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}

}
