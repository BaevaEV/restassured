package pojo;

import java.util.Objects;

public class Role {
    private String id;
    private String name;


    public Role() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void main(String[] args){
        this.id = "123";
        this.name = "123";
            String something = "123";


            // Рефлексивность
            System.out.println("Рефлексивность, id = id " +" "+ id.equals(id));
            System.out.println("Рефлексивность, name = name " +" "+ name.equals(name));

            // Симметричность
            System.out.println("Симметричность id = name" +" "+ id.equals(name));

            //Транзитивность
            System.out.println("Транзитивность id = something" +" "+ id.equals(something));
            System.out.println("Транзитивность id = name" +" "+ id.equals(name));
            System.out.println("Транзитивность name = something" +" "+ name.equals(something));

            //Согласованность (снова сравним id & name)
            System.out.println("Согласованность id = name" +" "+ id.equals(name));

            //Сравнение null
            System.out.println("Сравнение null" +" "+ id.equals(null));

        }


}
