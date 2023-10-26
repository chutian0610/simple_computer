package info.victorchu.computer.simulation.circuit;

import org.apache.commons.lang3.Validate;

/**
 * 简单电路组件抽象.
 * <pre>
 * 1. 有一个input buffer
 * 2. 有一个组件 state buffer
 * </pre>

 * @author victorchu
 */
public abstract class SimpleCircuitComponent implements CircuitComponent{

    protected Potential[] input;
    protected Potential[] state;

    @Override
    public void reset() {
        Potentials.fillArray(input);
        Potentials.fillArray(state);
    }

    protected SimpleCircuitComponent() {

    }

    /**
     * 初始化输入buffer和状态.
     * 子类需要在构造方法中调用init方法.
     */
    protected void init(){
        this.input= new Potential[inputLength()];
        this.state= new Potential[outputLength()];
        Potentials.fillArray(input);
        Potentials.fillArray(state);
    }

    @Override
    public void input(int i, Potential p) {
        validateInput(i,p);
        input0(i,p);

    }

    /**
     * 需要默认的input方法
     * @param i
     * @param p
     */
    protected void input0(int i, Potential p){
        Validate.isTrue(input != null && input[i] !=null,"CircuitComponent 未初始化，请先init()");
        input[i].input(p);
    }

    @Override
    public Potential output(int i) {
        validateOutput(i);
        return output0(i);
    }

    /**
     * 默认的output方法
     * @param i
     * @return
     */
    protected Potential output0(int i){
        Validate.isTrue(state != null && state[i] !=null,"CircuitComponent 未初始化，请先init()");
        return state[i].output();
    }
}
