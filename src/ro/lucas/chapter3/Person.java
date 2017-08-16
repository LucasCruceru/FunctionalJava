package ro.lucas.chapter3;

class Person {

    private final String name;
    private final int age;

    Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    int ageDifference(final Person other){
        return age - other.age;
    }

    public String toString(){
        return String.format("%s - %d", name, age);
    }
}
