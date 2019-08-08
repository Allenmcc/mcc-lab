package java8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by chunchen.meng on 2019/7/22.
 */
//@Getter
//@Setter
@ToString
public class Fruit {
    private String name;
    private Double price;

    public Fruit(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return java.util.Objects.equals(name, fruit.name) &&
                java.util.Objects.equals(price, fruit.price);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, price);
    }
    // 注意equals和hashCode必须成对出现
}
