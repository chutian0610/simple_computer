package info.victorchu.computer.simulation.circuit.encoder;

import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potentials;

public class LogicalPriorityEncoder extends DynamicSimpleCircuitComponent {

    public LogicalPriorityEncoder(int ways) {
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
          index = inputLength()-1-index;
          Potentials.fillArray(state,Potentials.fromUnsignedInt(index));
       }else{
          // 异常情况，理论上encoder的输入中必须要有一个`1`
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
