package Stream_samples;

public class People_pojo {
    int count;

    public People_pojo(String name, int count) {
        this.name=name;
        this.count=count;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

}
