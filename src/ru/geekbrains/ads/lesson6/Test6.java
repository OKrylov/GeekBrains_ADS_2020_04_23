package ru.geekbrains.ads.lesson6;

public class Test6 {

    public static void main(String[] args) {
        Tree<Person> tree = new TreeImpl<>();
        tree.add(new Person(60, "Alexey"));
        tree.add(new Person(25, "Alexey"));
        tree.add(new Person(66, "Alexey"));
        tree.add(new Person(15, "Alexey"));
        tree.add(new Person(5, "Alexey"));
        tree.add(new Person(20, "Alexey"));
        tree.add(new Person(45, "Alexey"));
        tree.add(new Person(30, "Alexey"));
        tree.add(new Person(55, "Alexey"));
        tree.add(new Person(32, "Alexey"));

        tree.traverse(Tree.TraverseMode.IN_ORDER);
        tree.display();

        System.out.println("Contains 30: " + tree.contains(new Person(30, "Alexey")));
        System.out.println("Contains 777: " + tree.contains(new Person(777, "Alexey")));

        tree.remove(new Person(25, "Alexey"));
        tree.display();
    }
}
