package Thread_samples;

import java.io.Serializable;

public class demo_pojo implements Serializable {

    public demo_pojo(int id, String name){
        this.id=id;
        this.name=name;
    }
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}
