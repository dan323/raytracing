package com.dan.geometry.camera.utils;

import com.dan.geometry.phong.material.Color;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ColorReduceMean implements Collector<Map.Entry<Integer, Color>, Map.Entry<Integer, Color>, Color> {


    @Override
    public Supplier<Map.Entry<Integer, Color>> supplier() {
        return () -> new AbstractMap.SimpleEntry<>(0, Color.BLACK);
    }

    @Override
    public BiConsumer<Map.Entry<Integer, Color>, Map.Entry<Integer, Color>> accumulator() {
        return (c1, c2) -> c1 = new AbstractMap.SimpleEntry<>(c1.getKey() + c2.getKey(), c1.getValue().add(c2.getValue()));
    }

    @Override
    public BinaryOperator<Map.Entry<Integer, Color>> combiner() {
        return (c1, c2) -> new AbstractMap.SimpleEntry<>(c1.getKey() + c2.getKey(), c1.getValue().add(c2.getValue()));
    }

    @Override
    public Function<Map.Entry<Integer, Color>, Color> finisher() {
        return c -> c.getValue().scale(1.0 / c.getKey());
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.CONCURRENT, Characteristics.UNORDERED);
    }
}
