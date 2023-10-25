package info.victorchu.computer.simulation.circuit.adder;

import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.gate.ANDGate;
import info.victorchu.computer.simulation.circuit.gate.ORGate;
import info.victorchu.computer.simulation.circuit.gate.XORGate;
import info.victorchu.computer.simulation.utils.CircuitUtils;

/**
 * 超前进位加法器.
 * <pre>
 *    in:  a | b |carry
 *    out: carry| sum
 * </pre>
 * @author victorchu
 */
public class LookAheadCarryAdder extends DynamicSimpleCircuitComponent {
    private XORGate[] p;
    private ANDGate[] g;
    private XORGate[] s;

    private ANDGate[] ands;
    private ORGate[] ors;
    public LookAheadCarryAdder(int n) {
        super(n);
        init();
    }

    @Override
    protected void init() {
        super.init();
        int length = getWays();
        p = new XORGate[length];
        g = new ANDGate[length];
        s = new XORGate[length];
        for (int i = 0; i < length; i++) {
            p[i] = new XORGate();
            g[i] = new ANDGate();
            s[i] = new XORGate();
        }
        int gates = getWays()*(getWays()+1)/2;
        ands = new ANDGate[gates];
        ors = new ORGate[gates];
        for (int i = 0; i < gates; i++) {
            ands[i] = new ANDGate();
            ors[i] = new ORGate();
        }
    }

    @Override
    public void reset() {
        super.reset();
        int length = getWays();
        for (int i = 0; i < length; i++) {
            p[i].reset();
            g[i].reset();
            s[i].reset();
        }
        int gates = getWays()*(getWays()-1)/2;
        for (int i = 0; i < gates; i++) {
            ands[i].reset();
            ors[i].reset();
        }
    }
    @Override
    public void update() {
        int length = getWays();
        Potential carry = carry(0);
        for (int i = length-1; i >= 0; i--) {
            // pi =ai xor bi
            CircuitUtils.fire(p[i],input[i],input[i+length]);
            // gi = ai and bi
            CircuitUtils.fire(g[i],input[i],input[i+length]);
            // si
            CircuitUtils.fire(s[i],p[i].output(0),carry);
            // ci
            carry = carry(length-i);
            // set state
            state[i+1].input(s[i].output(0));
        }
        state[0].input(carry);

    }

    /**
     * 计算Carry
     * @param n
     * @return
     */
    private Potential carry(int n){
        if (n == 0) {
            return input[inputLength()-1];
        }
        return carry(n,n*(n-1)/2);
    }
    private Potential carry(int n ,int start){

        // c0
        Potential tmp = input[inputLength()-1];
        int length = getWays();
        for (int i = 0; i < n; i++) {
            // ci
            CircuitUtils.fire(ands[start+i],p[length-i-1].output(0),tmp);
            CircuitUtils.fire(ors[start+i],g[length-i-1].output(0),ands[start+i].output(0));
            tmp = ors[start+i].output(0);
        }
        return tmp;
    }

    @Override
    public int inputLength() {
        return 2*ways+1;
    }

    @Override
    public int outputLength() {
        return ways+1;
    }
}
