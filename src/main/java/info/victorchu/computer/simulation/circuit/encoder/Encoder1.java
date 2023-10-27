package info.victorchu.computer.simulation.circuit.encoder;

import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;

/**
 * 2-1 编码器
 * <pre>
 *   0 1 -> 0
 *   1 0 -> 1
 * </pre>
 * @author victorchu
 */
public class Encoder1 extends SimpleCircuitComponent {

    public Encoder1() {
        super();
        init();
    }

    @Override
    public void update() {
        state[0].input(input[0].output());
    }

    @Override
    public int inputLength() {
        return 2;
    }

    @Override
    public int outputLength() {
        return 1;
    }
    
}
