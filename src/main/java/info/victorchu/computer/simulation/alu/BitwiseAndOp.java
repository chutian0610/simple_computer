//package info.victorchu.simplecomputer.alu;
//
//import info.victorchu.simplecomputer.circuit.ANDGate;
//import info.victorchu.simplecomputer.circuit.Potential;
//
///**
// * <pre>
// * Bitwise logic operations (intel 74181 4bit)
// * AND: the bitwise AND of A and B appears at Y.
// * </pre>
// *
// * @author zebra
// * @date 2022.08.24
// */
//public class BitwiseAndOp {
//    private final byte capacity;
//    private ANDGate andg;
//    private Potential[] out;
//
//    public BitwiseAndOp(byte capacity, ANDGate andg) {
//        this.capacity = capacity;
//        this.andg = andg;
//        this.out = new Potential[capacity];
//        for (int i = 0; i < capacity; i++) {
//            this.out[i] = Potential.of(false);
//        }
//    }
//
//    /**
//     * @param a 4 位电平数组
//     * @param b 4 位电平数组
//     */
//    public void and(Potential[] a, Potential[] b) {
//        assert (a.length == b.length);
//        for (int i = 0; i < a.length; i++) {
//            andg.input(a[i], b[i]);
//            out[i] = andg.output();
//        }
//    }
//
//    /**
//     * @return byte: 按位逻辑与支持的“位数”。
//     * 目前设定是 intel 74181, 4 bit。
//     */
//    public byte bitLength() {
//        return capacity;
//    }
//
//    public Potential[] output() {
//        return this.out;
//    }
//
//}
