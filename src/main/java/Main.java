
import service.MenuService;


public class Main {
    public static void main(String[] args) throws Exception {
        MenuService menuService = new MenuService();
        menuService.startMenuService();
//        PersoneConfiguration personeConfiguration = new PersoneConfiguration();
//        System.out.println(personeConfiguration.getAllPerson());

//        PersoneConfiguration personeConfiguration = new PersoneConfiguration("max");
//        personeConfiguration.addPerson(new Person("Bibob Boy", 100, 1,1));
//        personeConfiguration.addPerson(new Person("Bomgic", 100, 2,2));
//        personeConfiguration.addPerson(new Person("King", 100, 3,4));
//        personeConfiguration.addPerson(new Person("Magor", 100, 1,3));
//        System.out.println(personeConfiguration);
//        objectMapper.writeValue(new File("src\\\\\\\\main\\\\\\\\resources\\\\\\\\persons.yml"), personeConfiguration );
//        ItemConfiguration itemConfiguration = new ItemConfiguration("max");
//        itemConfiguration.addItem(new Item("Knife", 3, 2));
//        itemConfiguration.addItem(new Item("Bulava", 5, 1));
//        itemConfiguration.addItem(new Item("Pistol", 7, 0));
//        itemConfiguration.addItem(new Item("Sword", 5, 3));
//        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
//        objectMapper.writeValue(new File("src\\\\\\\\main\\\\\\\\resources\\\\\\\\items.yml"), itemConfiguration);

    }
}
