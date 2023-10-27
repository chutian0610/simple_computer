package info.victorchu.computer.simulation.circuit;

import org.apache.commons.lang3.Validate;

/**
 * @author victorchu
 */
public class CircuitComponentUtils {

    /**
     * 输入&输出
     * @param c
     * @param potentials
     * @return
     */
    public static Potential[] compute(CircuitComponent c, Potential... potentials){
        Validate.isTrue(c != null);
        Validate.isTrue(Potentials.notEmptyArray(potentials) && potentials.length ==c.inputLength());
        for (int i = 0; i < potentials.length; i++) {
            c.input(i,potentials[i]);
        }
        c.update();
        Potential[] result = new Potential[c.outputLength()];
        for (int i = 0; i < c.outputLength(); i++) {
            result[i] = c.output(i);
        }
        return result;
    }

    /**
     * 输入
     * @param c
     * @param potentials
     */
    public static void fire(CircuitComponent c, Potential... potentials){
        Validate.isTrue(Potentials.notEmptyArray(potentials)  && potentials.length ==c.inputLength());
        for (int i = 0; i < potentials.length; i++) {
            c.input(i,potentials[i]);
        }
        c.update();
    }


    /**
     * 输出
     * @param c
     * @return
     */
    public static Potential[] emits(CircuitComponent... components){
        int length = 0;
        Validate.isTrue(components != null);
        for (CircuitComponent circuitComponent : components) {
            Validate.isTrue(circuitComponent != null);
            length = length+ circuitComponent.outputLength();
        }
        Potential[] result = new Potential[length];
        int index=0;
        for (CircuitComponent circuitComponent : components) {
            int sublength = circuitComponent.outputLength();
            for (int i = 0; i < sublength; i++) {
                result[index] = circuitComponent.output(i);
                index++;
            }
        }
        return result;
    }

    /**
     * 输出
     * @param c
     * @return
     */
    public static Potential[] emit(CircuitComponent c){
        return emit(c,null);
    }

    /**
     * 输出
     * @param c 组件
     * @param pins 管脚映射
     * @return
     */
    public static Potential[] emit(CircuitComponent c, int[] pins){
        Validate.isTrue(c != null);
        Potential[] result;
        if(pins == null){
            result = new Potential[c.outputLength()];
            for (int i = 0; i < result.length; i++) {
                result[i] = c.output(i);
            }
        }else {
            result = new Potential[pins.length];
            for (int i = 0; i < pins.length; i++) {
                result[i] = c.output(pins[i]);
            }
        }
        return result;
    }

}
