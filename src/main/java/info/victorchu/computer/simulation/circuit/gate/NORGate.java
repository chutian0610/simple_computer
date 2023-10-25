package info.victorchu.computer.simulation.circuit.gate;


import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;

/**
 * 或非门. Y=(A+B)'
 * <pre>
 * 真值表:
 * input1 input2 output
 *  0     0       1
 *  0     1       0
 *  1     0       0
 *  1     1       0
 * </pre>
 *
 * @author victorchu
 */
public class NORGate extends SimpleCircuitComponent {
    public NORGate() {
      super();
      init();
    }

    @Override
    public void update() {
        state[0].input(Potential.not(Potential.or(input[0], input[1])));
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