package model;

/**
 * Class represent a base entity
 */
public class BaseEntity {

	private int id;
    public BaseEntity(){}
    
    public BaseEntity(int id) {
        this.id = id;
    }
  
    //Return the id.
    public int getId() {
        return id;
    }
}
