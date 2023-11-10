package org.HW_071123.task_1.lombok;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
//@Data - заменяет всё вышенаписанное
public class LombokExample {
    private String firstField;
    private String secondField;
    private String thirdField;
}