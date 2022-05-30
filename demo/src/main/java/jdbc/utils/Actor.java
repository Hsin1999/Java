package jdbc.utils;

import java.sql.Timestamp;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/30 19:27
 */
public class Actor {
    private Integer id;
    private String name;
    private Timestamp createtime;
    public Actor(){};

    public Actor(Integer id, String name, Timestamp createtime) {
        this.id = id;
        this.name = name;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
