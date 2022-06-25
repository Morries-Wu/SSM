package IOC.items.item03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myschool")
public class School {

    @Value("中国邮政大学")
    private String name;
    @Value("广东广州")
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
