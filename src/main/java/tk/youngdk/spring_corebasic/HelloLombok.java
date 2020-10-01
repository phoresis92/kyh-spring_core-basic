package tk.youngdk.spring_corebasic;

import lombok.Data;

@Data
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();

        helloLombok.setName("asdf");
        helloLombok.setAge(20);

        System.out.println("helloLombok = " + helloLombok);
    }
}
