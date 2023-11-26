package org.HW_231123.task_2.bike;


import lombok.Getter;
import lombok.Setter;
import org.HW_021123.obstacle.Obstacle;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

/**
 * Class {@code Fahrrad} is a shop, where you can construct your default bicycle.
 * You can complete your personal bike through choosing:
 * Handlebar, Saddle, Wheel, Gears and Frame.
 * Each detail's type has a durability.
 * Bike can ride and during this ride it meets a variable obstacle such as:
 * Pit, puddle, rock, broken glass. It causes random damage that reduce random detail durability.
 * When durability some detail become less or equal null bike can't ride further.
 */

@Setter
@Getter
public class Bike implements Serializable {
    private final Handlebar handlebar;
    private final Saddle saddle;
    private final Wheel wheel;
    private final Gears gears;
    private final Frame frame;
    Random random = new Random();
    public Bike(Handlebar.HandlebarType handlebarType,
                Saddle.SaddleType saddleType,
                Wheel.WheelType wheelType,
                Gears.GearsType gearsType,
                Frame.FrameType frameType) {
        handlebar = new Handlebar(handlebarType);
        saddle = new Saddle(saddleType);
        wheel = new Wheel(wheelType);
        gears = new Gears(gearsType);
        frame = new Frame(frameType);
    }

    /**
     * abstract parent class for all bike's parts.
     * it has one field - durability
     */
    public abstract static class BikeParts implements Serializable{
        private int durability;

        public int getDurability() {
            return durability;
        }

        public void setDurability(int durability) {
            this.durability = durability;
        }
    }

    public static class Handlebar extends BikeParts implements Serializable{
        HandlebarType handlebarType;

        public Handlebar(HandlebarType handlebarType) {
            this.handlebarType = handlebarType;
            setDurability(handlebarType.durability);
        }

        public enum HandlebarType implements Serializable{
            FLAT(55),
            DROP(60),
            BULLHORN(90),
            AERO_BARS(88),
            TRACK(87),
            RISER(77);
            private final int durability;

            HandlebarType(int damage) {
                this.durability = damage;
            }
        }
    }

    public static class Saddle extends BikeParts implements Serializable{
        SaddleType saddleType;

        public Saddle(SaddleType saddleType) {
            this.saddleType = saddleType;
            setDurability(saddleType.durability);
        }

        public enum SaddleType implements Serializable{
            MOUNTAIN(90),
            RACE(66),
            ROAD(77);
            private final int durability;

            SaddleType(int damage) {
                this.durability = damage;
            }
        }
    }

    public static class Wheel extends BikeParts implements Serializable{
        WheelType wheelType;

        public Wheel(WheelType wheelType) {
            this.wheelType = wheelType;
            setDurability(wheelType.durability);
        }

        public enum WheelType implements Serializable{
            BMX(99),
            MOUNTAIN(90),
            RACE(70);
            private final int durability;

            WheelType(int durability) {
                this.durability = durability;
            }
        }
    }

    public static class Gears extends BikeParts implements Serializable{
        GearsType gearsType;

        public Gears(GearsType gearsType) {
            this.gearsType = gearsType;
            setDurability(gearsType.durability);
        }

        public enum GearsType implements Serializable{
            SINGLE(100),
            MULTI(80),
            AUTOMATIC(60);
            private final int durability;

            GearsType(int durability) {
                this.durability = durability;
            }
        }
    }

    public static class Frame extends BikeParts implements Serializable{
        FrameType frameType;

        public Frame(FrameType frameType) {
            this.frameType = frameType;
            setDurability(frameType.durability);
        }

        public enum FrameType implements Serializable{
            FEMALE(80),
            TEENAGER(90),
            MALE(100);
            private final int durability;

            FrameType(int durability) {
                this.durability = durability;
            }
        }
    }

    /**
     * @param part   the part that damaged
     * @param damage value of the damage
     */
    public void damaging(BikeParts part, int damage) {
        part.durability -= damage;
    }

    /**
     * @param part bike's part to be checked
     * @return true if bike's detail is not broken otherwise - false
     */
    public boolean isPartNotBroken(BikeParts part) {
        return part.durability > 0;
    }

    /**
     * method check if bike still can ride
     *
     * @return false if at least one detail is broken, otherwise true
     */
    public boolean canRide() {
        return isPartNotBroken(handlebar) &&
                isPartNotBroken(saddle) &&
                isPartNotBroken(wheel) &&
                isPartNotBroken(gears) &&
                isPartNotBroken(frame);
    }

    /**
     * method goes till bike can ride.
     * every iteration bike meets random obstacle that causes random damage to the random detail
     */
    public void ride() {
        while (canRide()) {
            List<BikeParts> partsList = List.of(this.frame, this.gears, this.saddle, this.wheel, this.handlebar);
            BikeParts randomPart = partsList.get(random.nextInt(partsList.size()));
            Obstacle obstacle = Obstacle.values()[random.nextInt(Obstacle.values().length)];
            damaging(randomPart, obstacle.getDamage());

            System.out.printf(
                    "Упс, вы наехали на %s. Часть '%s' получила %d единиц урона. Осталось %d единиц прочности",
                    obstacle.name(),
                    randomPart.getClass().getSimpleName(),
                    obstacle.getDamage(),
                    randomPart.durability
            );
        }
    }
}

