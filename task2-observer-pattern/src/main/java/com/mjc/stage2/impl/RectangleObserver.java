package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.repository.RectangleRepository;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        System.out.println("Observing from RectangleObserver");
        RectangleWarehouse warehouse = RectangleWarehouse.getInstance();
        RectangleRepository repository = RectangleRepository.getInstance();

        Rectangle rectangle = repository.getRectangle(event.getSource().getId());
        RectangleValues values = warehouse.get(event.getSource().getId());

        values.setSquare(rectangle.getSideA() * rectangle.getSideB());
        values.setPerimeter((rectangle.getSideA() + rectangle.getSideB()) * 2);
    }

}
