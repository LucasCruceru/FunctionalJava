package ro.lucas.chapter4;

import java.util.function.Consumer;

public class Mailer {
    private Mailer(){}
    private Mailer from(final String address){return this;}
    private Mailer to(final String address){return this;}
    private Mailer subject(final String line){return this;}
    private void body(final String message){}
    private static void send(final Consumer<Mailer> block){
        final Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.println("sending...");}

    public static void main(String[] args) {
        Mailer.send(mailer ->
                    mailer.from("example@gmail.com")
                        .to("anotherexample@gmail.com")
                        .subject("buildNotification")
                        .body("... TEXT ..."));
    }
}
