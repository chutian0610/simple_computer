package info.victorchu.computer.simulation.circuit.encoder;

import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potentials;

public class LogicalEncoder extends DynamicSimpleCircuitComponent {

    public LogicalEncoder(int ways) {
        super(ways);
        init();
    }

    @Override
    public void update() {
       int index = -1; 
       for (int i = 0; i < input.length; i++) {
            if (input[i].isHigh()) {
                index = i;
                break;
            }
       }
       if(index >-1){
          // found
          Potentials.fillArray(state,Potentials.fromUnsignedInt(index));
       }else{
          Potentials.fillArray(state);
       }
    }

    @Override
    public int inputLength() {
        return (int)Math.pow(2,ways);
    }

    @Override
    public int outputLength() {
        return ways;
    }
}
