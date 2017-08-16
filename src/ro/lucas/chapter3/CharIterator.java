package ro.lucas.chapter3;

class CharIterator {
    public static void main(String[] args) {
        final String str = "w00t";

        str.chars()
                .forEach(System.out::println);

        System.out.println("--------------------------");

        str.chars()
                .filter(Character::isDigit)
                .forEach(CharIterator::printChar);

        System.out.println("--------------------------");

        str.chars()
                .mapToObj(ch -> ((char) ch))
                .forEach(System.out::println);


    }

    private static void printChar(int aChar){
        System.out.println((char)(aChar));
    }
}
