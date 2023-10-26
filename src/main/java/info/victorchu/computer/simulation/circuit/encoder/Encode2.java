package info.victorchu.computer.simulation.circuit.encoder;

import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;

/**
 * 4-2 编码器
 * <pre>
 *   0 0 0 1 -> 0 0
 *   0 0 1 0 -> 0 1 
 *   0 1 0 0 -> 1 0
 *   1 0 0 0 -> 1 1
 * </pre>
 * @author victorchu
 */
public class Encode2 extends SimpleCircuitComponent {

    @Override
    public void update() {
    }

    @Override
    public int inputLength() {
        return 4;
    }

    @Override
    public int outputLength() {
        return 2;
    }
}
