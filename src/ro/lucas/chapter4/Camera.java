package ro.lucas.chapter4;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
class Camera {
    private Function<Color,Color> filter;
    private Color capture(final Color inputColor){
        return filter.apply(inputColor);
    }

    private void setFilters(Function<Color, Color>... filters) {
        filter = Stream.of(filters)
        .reduce((filter, next) -> filter.compose((next)))
        .orElseGet(Function::identity);
    }
    private Camera(){setFilters();}

    public static void main(String[] args) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured = (filterInfo) ->
                System.out.println(String.format("with %s: %s", filterInfo,
                        camera.capture(new Color(200,100, 200))));
        printCaptured.accept("no filter");
        camera.setFilters(Color::brighter);
        printCaptured.accept("brighter filter");
        camera.setFilters(Color::darker);
        printCaptured.accept("darker filer");
        camera.setFilters(Color::darker,Color::brighter);
        printCaptured.accept("darker and brighter filer");

    }
}
