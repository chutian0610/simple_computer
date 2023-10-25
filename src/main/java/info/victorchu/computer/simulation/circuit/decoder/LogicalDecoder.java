package info.victorchu.computer.simulation.circuit.decoder;

import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;

/**
 * @author victorchu
 */
public class LogicalDecoder extends DynamicSimpleCircuitComponent {
    public LogicalDecoder(int ways) {
        super(ways);
    }

    @Override
    public void update() {

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
