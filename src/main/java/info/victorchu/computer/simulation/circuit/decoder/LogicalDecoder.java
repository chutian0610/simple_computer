package info.victorchu.computer.simulation.circuit.decoder;

import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

/**
 * N-2^N 解码器
 * @author victorchu
 */
public class LogicalDecoder extends DynamicSimpleCircuitComponent {
    public LogicalDecoder(int ways) {
        super(ways);
        init();
    }

    @Override
    public void update() {
        int value = Potentials.toUnsignedInt(input);
        Potentials.fillArray(state);
        state[outputLength()-1-value].input(Potential.high());
    }

    /**
     * N
     * @return
     */
    @Override
    public int inputLength() {
        return ways;
    }

    /**
     * 2^N
     * @return
     */
    @Override
    public int outputLength() {
        return (int)Math.pow(2,ways);
    }
}
