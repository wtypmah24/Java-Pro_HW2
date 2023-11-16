package org.HW_141123.task_1.pizza;
import org.HW_141123.task_1.pizza.sauce.Sauce;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class PizzaLazy {
    private String crust;
    private Sauce sauce;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
}
