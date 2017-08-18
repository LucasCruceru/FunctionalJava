package ro.lucas.chapter6.heavy;

import java.util.function.Supplier;

public class Holder {
    private Supplier<Heavy> heavy = this::createAndCacheHeavy;

    private Holder() {
        System.out.println("Holder Created");
    }

    private synchronized Heavy createAndCacheHeavy(){
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavyInstance = new Heavy();
            @Override
            public Heavy get(){return heavyInstance;}
        }
        if(!HeavyFactory.class.isInstance(heavy)){
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }

    public static void main(String[] args) {
        final Holder holder = new Holder();
        System.out.println("deferring heavy creation...");
//        System.out.println(holder.getHeavy());
//        System.out.println(holder.getHeavy());
    }

}
