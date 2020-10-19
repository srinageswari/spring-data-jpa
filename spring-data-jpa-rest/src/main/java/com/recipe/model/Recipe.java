package com.recipe.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author smanickavasagam
 *
 */
@Entity
@Table(name = "Recipe")
public class Recipe {
	@Id
	private int id;
	private String name;
    private String time;
    private String method;
    private String notes;
    private boolean isKidsRecipe;
    private String flavour;
    private String type;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the isKidsRecipe
	 */
	public boolean isKidsRecipe() {
		return isKidsRecipe;
	}
	/**
	 * @param isKidsRecipe the isKidsRecipe to set
	 */
	public void setKidsRecipe(boolean isKidsRecipe) {
		this.isKidsRecipe = isKidsRecipe;
	}
	/**
	 * @return the flavour
	 */
	public String getFlavour() {
		return flavour;
	}
	/**
	 * @param flavour the flavour to set
	 */
	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(flavour, id, isKidsRecipe, method, name, notes, time, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		return Objects.equals(flavour, other.flavour) && id == other.id && isKidsRecipe == other.isKidsRecipe
				&& Objects.equals(method, other.method) && Objects.equals(name, other.name)
				&& Objects.equals(notes, other.notes) && Objects.equals(time, other.time)
				&& Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", time=" + time + ", method="
				+ method + ", notes=" + notes + ", isKidsRecipe=" + isKidsRecipe + ", flavour=" + flavour + ", type="
				+ type + "]";
	}
	
}
