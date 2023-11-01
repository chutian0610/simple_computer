package info.victorchu.computer.simulation.circuit.mux;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;
import info.victorchu.computer.simulation.circuit.decoder.LogicalDecoder;

/**
 * 多路复用器.
 * <pre>
 * input:
 *  data(2^N)| selector(N)
 * output:
 *  1
 * </pre>
 */
public class Multiplexer extends DynamicSimpleCircuitComponent{

    private LogicalDecoder decoder;

    public Multiplexer(int ways) {
        super(ways);
        init();
    }

     @Override
    protected void init() {
        super.init();
        decoder = new LogicalDecoder(ways);
    }

    @Override
    public void reset() {
        super.reset();
        decoder.reset();
    
    }

    @Override
    public void update() {
        CircuitComponentUtils.fire(decoder, Potentials.of(input, (int)Math.pow(2, ways)));
        Potential[] selector = CircuitComponentUtils.emit(decoder);
        for (int i = (selector.length-1); i>=0; i--) {
            if(selector[i].isHigh()){
                state[0].input(input[i]);
                break;
            }
           
        }
    }

    @Override
    public int inputLength() {
        return (int )Math.pow(2, ways) + ways;
    }

    @Override
    public int outputLength() {
        return 1;
    }
    
}
