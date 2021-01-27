package Model;
//This is used to allow the program to create clones of a user or item when needed
//This follows the Prototype design pattern
public abstract class ModelItem implements Cloneable {
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }
        catch (CloneNotSupportedException Error){
            Error.printStackTrace();

        }
        return clone;
    }

}
