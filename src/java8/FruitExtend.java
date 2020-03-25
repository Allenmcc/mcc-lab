package java8;

import lombok.ToString;

/**
 * Created by chunchen.meng on 2019/7/22.
 */
//@Getter
//@Setter
@ToString
public class FruitExtend  extends Fruit{
    private Integer quality;


    public FruitExtend(String name, Double price, Integer quality) {
        super(name, price);
        this.quality = quality;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }
}
