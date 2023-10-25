package info.victorchu.computer.simulation.circuit.adder;

import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author victorchu
 */
public class LogicalAdder extends DynamicSimpleCircuitComponent {
    public LogicalAdder(int ways) {
        super(ways);
        init();
    }

    @Override
    public void update() {
        Pair<Potential[],Potential> re = Potentials.add(Potentials.of(input,0,ways),Potentials.of(input,ways,2*ways),input[2*ways]);
        int length = ways+1;
        state[0].input(re.getRight());
        for (int i = 1; i < length; i++) {
            state[i].input(re.getLeft()[i-1]);
        }
    }

    @Override
    public int inputLength() {
        return 2 * getWays() + 1;
    }

    @Override
    public int outputLength() {
        return getWays() + 1;
    }
}
