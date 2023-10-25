package info.victorchu.computer.simulation.circuit;

import lombok.Getter;

/**
 * N-way电路组件.
 * @author victorchu
 */
public abstract class DynamicSimpleCircuitComponent extends SimpleCircuitComponent implements DynamicWay{
    public DynamicSimpleCircuitComponent(int ways) {
        super();
        this.ways = ways;
    }
    @Getter
    protected int ways;

    @Override
    protected void init() {
        super.init();
    }
}
