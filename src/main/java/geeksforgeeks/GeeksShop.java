package geeksforgeeks;

//check the main class for the solutio
public class GeeksShop {

    private int[] price;
    private long numberEnquiry;

    public GeeksShop(int[] price) {
        this.price = price;
        this.numberEnquiry = 0;
    }

    public int getPriceOfCurrentItem(int i){
        this.numberEnquiry++;
        if(numberEnquiry >50){
            return -1;
        }
        return this.price[i];
    }

}

