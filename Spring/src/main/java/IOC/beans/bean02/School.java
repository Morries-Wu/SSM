package IOC.beans.bean02;

public class School {
    private String name;
    private String address;

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name;
    }

    public void setAddress(String address) {
        System.out.println("setAddress:" + address);
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
