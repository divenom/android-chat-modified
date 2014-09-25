package com.innovatedelhi.week3;

public class Dish {

	private String price;
	private String photo;
	private String owner;
    private String name;
    private String description;
    private String category;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Dish() { }

    Dish(String price, String photo, String owner, String name, String description, String category) {
        this.price = price;
        this.photo = photo;
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getPhoto() {
		return photo;
	}

	public String getOwner() {
		return owner;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
