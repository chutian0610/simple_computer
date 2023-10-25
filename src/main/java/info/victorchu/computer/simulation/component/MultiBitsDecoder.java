//package info.victorchu.computer.simulation.component;
//
//import info.victorchu.computer.simulation.circuit.CircuitComponent;
//import info.victorchu.computer.simulation.circuit.gates.ANDGate;
//import info.victorchu.computer.simulation.circuit.ANDGates;
//import info.victorchu.computer.simulation.circuit.gates.NOTGate;
//import info.victorchu.computer.simulation.circuit.Potential;
//import info.victorchu.computer.simulation.utils.ImplementType;
//import org.apache.commons.lang3.Validate;
//
///**
// * N路输入，2^N路输出的解码器
// * @Description:
// * @Date:2022/11/3 14:33
// * @Author:victorchutian
// */
//public interface MultiBitsDecoder extends CircuitComponent {
//    /**
//     * 输入
//     * @param code 输入数组 code
//     */
//    @Override
//    void input(Potential[] code);
//
//    /**
//     * 输出
//     * @return 输出数组
//     */
//    @Override
//    Potential[] output();
//
//    /**
//     * 工厂方法
//     * @param type
//     * @param length
//     * @return
//     */
//    static MultiBitsDecoder get(ImplementType type, int length){
//        // 这里希望限制输出不要超过Integer的最大值2^31-1，即希望可以用数组存储输出结果。
//        // 实际上不会有这么大，一般常见的是2-4，3-8，4-16，8-256
//        Validate.isTrue(length <31);
//        switch (type){
//            case Logic:
//                return new MultiBitsDecoder.LogicImpl(length);
//            case Circuit:
//                return lines(length);
//            default:
//                throw new UnsupportedOperationException();
//        }
//    }
//
//    /**
//     * 工厂方法.
//     * 生成特定N线解码器的电路实现.
//     * @param length
//     * @return
//     */
//    static MultiBitsDecoder lines(int length){
//        switch (length){
//            case 2: return new CircuitImpl_2_4();
//            case 3: return new CircuitImpl_3_8();
//            default:
//                throw new UnsupportedOperationException();
//        }
//    }
//
//    /**
//     * 2线-4线 解码器
//     */
//    class CircuitImpl_2_4 implements MultiBitsDecoder{
//        private final NOTGate[] notGates;
//        private final ANDGate[] andGates;
//        private final Potential[] output;
//
//        public CircuitImpl_2_4() {
//            notGates = NOTGate.array(2);
//            andGates = ANDGate.array(4);
//            output = Potential.array(4);
//        }
//
//        @Override
//        public void input(Potential[] code) {
//            validateInput(code);
//
//            notGates[0].input(code[0]);
//            notGates[1].input(code[1]);
//
//            andGates[0].input(notGates[1].output()[0],notGates[0].output()[0]);
//            andGates[1].input(notGates[1].output()[0],code[0]);
//            andGates[2].input(code[1],notGates[0].output()[0]);
//            andGates[3].input(code[1],code[0]);
//            output[0] = andGates[0].output()[0];
//            output[1] = andGates[1].output()[0];
//            output[2] = andGates[2].output()[0];
//            output[3] = andGates[3].output()[0];
//        }
//
//        @Override
//        public Potential[] output() {
//            return Potential.copyArray(output);
//        }
//
//        @Override
//        public int inputLength() {
//            return 2;
//        }
//
//        @Override
//        public int outputLength() {
//            return 4;
//        }
//    }
//    /**
//     * 3线-8线 解码器
//     */
//    class CircuitImpl_3_8 implements MultiBitsDecoder{
//        private final NOTGate[] notGates;
//        private final ANDGates[] andGates;
//        private final Potential[] output;
//
//        public CircuitImpl_3_8() {
//            notGates = NOTGate.array(3);
//            andGates = ANDGates.array(8,3);
//            output = Potential.array(8);
//        }
//
//        @Override
//        public void input(Potential[] code) {
//            validateInput(code);
//
//            notGates[0].input(code[0]);
//            notGates[1].input(code[1]);
//            notGates[2].input(code[2]);
//
//            andGates[0].input(notGates[2].output()[0],notGates[1].output()[0],notGates[0].output()[0]);
//            andGates[1].input(notGates[2].output()[0],notGates[1].output()[0],code[0]);
//            andGates[2].input(notGates[2].output()[0],code[1],notGates[0].output()[0]);
//            andGates[3].input(notGates[2].output()[0],code[1],code[0]);
//
//            andGates[4].input(code[2],notGates[1].output()[0],notGates[0].output()[0]);
//            andGates[5].input(code[2],notGates[1].output()[0],code[0]);
//            andGates[6].input(code[2],code[1],notGates[0].output()[0]);
//            andGates[7].input(code[2],code[1],code[0]);
//
//            output[0] = andGates[0].output()[0];
//            output[1] = andGates[1].output()[0];
//            output[2] = andGates[2].output()[0];
//            output[3] = andGates[3].output()[0];
//            output[4] = andGates[4].output()[0];
//            output[5] = andGates[5].output()[0];
//            output[6] = andGates[6].output()[0];
//            output[7] = andGates[7].output()[0];
//        }
//
//        @Override
//        public Potential[] output() {
//            return Potential.copyArray(output);
//        }
//
//        @Override
//        public int inputLength() {
//            return 3;
//        }
//
//        @Override
//        public int outputLength() {
//            return 8;
//        }
//    }
//
//    class LogicImpl implements MultiBitsDecoder{
//        private Integer inputCapacity;
//        private Integer outPutCapacity;
//        private Integer index;
//
//        public LogicImpl(int length) {
//            inputCapacity = length;
//            outPutCapacity = new Double(Math.pow(2,length)).intValue();
//        }
//
//        @Override
//        public void input(Potential[] code) {
//            validateInput(code);
//
//            int sum = 0;
//            for (int i = 0; i < inputCapacity; i++) {
//                if(code[i].isHigh()){
//                    sum = sum+(int)Math.pow(2,i);
//                }
//            }
//            index = sum;
//        }
//
//        @Override
//        public Potential[] output() {
//            return array(outPutCapacity,index);
//        }
//
//        @Override
//        public int inputLength() {
//            return inputCapacity;
//        }
//
//        @Override
//        public int outputLength() {
//            return outPutCapacity;
//        }
//
//        static Potential[]  array(int length,int index){
//            Potential[] arr = new Potential[length];
//            for (int i = 0; i < length; i++) {
//                if(i == index){
//                    arr[i] = Potential.high();
//                }else {
//                    arr[i] = Potential.low();
//                }
//            }
//            return arr;
//        }
//    }
//
//}
