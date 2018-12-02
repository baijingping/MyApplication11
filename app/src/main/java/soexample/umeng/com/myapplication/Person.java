package soexample.umeng.com.myapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by mumu on 2018/11/1.
 */

@Entity(nameInDb = "person_table")
public class Person {
    @Id(autoincrement = true)
    public Long id;
    @Property(nameInDb = "name")
    public String mingzi;
    public int age;
    @Transient
    public String identity;
    @Generated(hash = 244725397)
    public Person(Long id, String mingzi, int age) {
        this.id = id;
        this.mingzi = mingzi;
        this.age = age;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMingzi() {
        return this.mingzi;
    }
    public void setMingzi(String mingzi) {
        this.mingzi = mingzi;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", mingzi='" + mingzi + '\'' +
                ", age=" + age +
                ", identity='" + identity + '\'' +
                '}';
    }
}
