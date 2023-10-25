package info.victorchu.computer.simulation.utils;

import info.victorchu.computer.simulation.circuit.CircuitComponent;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;
import org.apache.commons.lang3.Validate;

/**
 * @author victorchu
 */
public class CircuitUtils {

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
