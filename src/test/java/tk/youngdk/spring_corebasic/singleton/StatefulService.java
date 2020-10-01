package tk.youngdk.spring_corebasic.singleton;

public class StatefulService {

    // 상태를 유지하는 필
    private int price;

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);

        // 여기가 문제
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}
