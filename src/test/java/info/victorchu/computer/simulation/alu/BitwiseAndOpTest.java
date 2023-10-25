//package info.victorchu.simplecomputer.alu;
//
//import info.victorchu.simplecomputer.circuit.ANDGate;
//import info.victorchu.simplecomputer.circuit.Potential;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * @author zebra
// * @date 2022.08.25
// */
//public class BitwiseAndOpTest {
//    static BitwiseAndOp op;
//
//    @BeforeAll
//    static void init() {
//        op = new BitwiseAndOp((byte) 4, new ANDGate());
//    }
//
//    @Test
//    void bitLength() {
//        assertEquals((byte) 4, op.bitLength());
//    }
//
//    /**
//     * 0101 (decimal 5)
//     * AND 0011 (decimal 3)
//     * =   0001 (decimal 1)
//     */
//    @Test
//    void input1() {
//        Potential[] in1 = new Potential[]{
//                Potential.high(),
//                Potential.low(),
//                Potential.high(),
//                Potential.low()
//        };
//        Potential[] in2 = new Potential[]{
//                Potential.high(),
//                Potential.high(),
//                Potential.low(),
//                Potential.low()
//        };
//        op.and(in1, in2);
//        // result: [0, 0, 0, 1]
//        assertEquals(Potential.high().output(), op.output()[0].output());
//        assertEquals(Potential.low().output(), op.output()[1].output());
//        assertEquals(Potential.low().output(), op.output()[2].output());
//        assertEquals(Potential.low().output(), op.output()[3].output());
//    }
//
//    /**
//     * 0011 (decimal 3)
//     * AND 0010 (decimal 2)
//     * =   0010 (decimal 2)
//     */
//    @Test
//    void input2() {
//        Potential[] in1 = new Potential[]{
//                Potential.high(),
//                Potential.high(),
//                Potential.low(),
//                Potential.low()
//        };
//        Potential[] in2 = new Potential[]{
//                Potential.low(),
//                Potential.high(),
//                Potential.low(),
//                Potential.low()
//        };
//        op.and(in1, in2);
//        // result: [0, 0, 1, 0]
//        assertEquals(Potential.low().output(), op.output()[0].output());
//        assertEquals(Potential.high().output(), op.output()[1].output());
//        assertEquals(Potential.low().output(), op.output()[2].output());
//        assertEquals(Potential.low().output(), op.output()[3].output());
//    }
//
//    /**
//     * 0110 (decimal 6)
//     * AND 1011 (decimal 11)
//     * =   0010 (decimal 2)
//     */
//    @Test
//    void input3() {
//        Potential[] in1 = new Potential[]{
//                Potential.low(),
//                Potential.high(),
//                Potential.high(),
//                Potential.low()
//        };
//        Potential[] in2 = new Potential[]{
//                Potential.high(),
//                Potential.high(),
//                Potential.low(),
//                Potential.high()
//        };
//        op.and(in1, in2);
//        // result: [0, 0, 1, 0]
//        assertEquals(Potential.low().output(), op.output()[0].output());
//        assertEquals(Potential.high().output(), op.output()[1].output());
//        assertEquals(Potential.low().output(), op.output()[2].output());
//        assertEquals(Potential.low().output(), op.output()[3].output());
//    }
//
//    /**
//     * 0110 (decimal 6)
//     * AND 0001 (decimal 1)
//     * =   0000 (decimal 0)
//     */
//    @Test
//    void input4() {
//        Potential[] in1 = new Potential[]{
//                Potential.low(),
//                Potential.high(),
//                Potential.high(),
//                Potential.low()
//        };
//        Potential[] in2 = new Potential[]{
//                Potential.high(),
//                Potential.low(),
//                Potential.low(),
//                Potential.low()
//        };
//        op.and(in1, in2);
//        // result: [0, 0, 0, 0]
//        assertEquals(Potential.low().output(), op.output()[0].output());
//        assertEquals(Potential.low().output(), op.output()[1].output());
//        assertEquals(Potential.low().output(), op.output()[2].output());
//        assertEquals(Potential.low().output(), op.output()[3].output());
//    }
//}
