package Model;

public class Item {
    private String Name;
    private String Code;
    private float Price;
    private int AmountInStock;
    public Item(String inputName, String inputCode,float inputPrice,int inputStock){
        Name = inputName;
        Code = inputCode;
        Price = inputPrice;
        AmountInStock = inputStock;
    }
    public String getName(){
        return Name;
    }
    public String getCode(){
        return Code;
    }
    public float getPrice(){
        return Price;
    }
    public int getAmountInStock(){
        return AmountInStock;
    }
    public void setName(String inputName){
        Name = inputName;
    }
    public void setCode(String inputCode){
        Code = inputCode;
    }
    public void setPrice(Float inputPrice){
        Price = inputPrice;
    }
    public void setAmountInStock(int inputStock){
        AmountInStock = inputStock;
    }
}
