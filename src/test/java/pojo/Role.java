package pojo;

public class Role {
    private static String id;
    private static String name;

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }


        public static void main (String[]args){
            Role.id = "123";
            Role.name = "123";
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
