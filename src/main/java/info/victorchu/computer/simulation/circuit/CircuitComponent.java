package info.victorchu.computer.simulation.circuit;

import org.apache.commons.lang3.Validate;
/**
 * 电路组件.
 * <pre>
 * 电路组件的特征:
 * 1. 可以设置输入管脚
 * 2. 可以设置输出管脚
 * 3. 根据输入电位更新自身状态，并输出
 * </pre>

 * @author victorchutian
 */
public interface CircuitComponent {
    /**
     * 输入位置i的电位
     * @param p 输入电位
     * @param i 输入位置
     */
    void input(int i, Potential p);

    /**
     * 输出位置i的电位
     * @return 电位
     */
    Potential output(int i);

    /**
     * 更新自身状态
     */
    void update();

    /**
     * 输入支持的长度
     * @return
     */
    int inputLength();

    /**
     * 输出支持的长度
     * @return
     */
    int outputLength();

    /**
     * 默认的输入参数验证方法
     * @param i 输入位置
     * @param p 输入电位
     */
    default void validateInput(int i,Potential p){
        Validate.isTrue(p != null, "输入电位不能为空");
        Validate.isTrue(i>=0 && i<inputLength(),"输入位置必须在[0,%d)之间",inputLength());
    }

    /**
     * 默认的输出参数验证方法
     * @param i 输出位置
     */
    default void validateOutput(int i){
        Validate.isTrue(i>=0 && i<outputLength(),"输出位置必须在[0,%d)之间",outputLength());
    }

    /**
     * 重置组件状态
     */
    void reset();
}
