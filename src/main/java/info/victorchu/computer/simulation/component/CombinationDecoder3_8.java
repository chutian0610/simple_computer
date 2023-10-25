//package info.victorchu.computer.simulation.component;
//
//import info.victorchu.computer.simulation.circuit.gates.NOTGate;
//import info.victorchu.computer.simulation.circuit.Potential;
//import info.victorchu.computer.simulation.utils.ImplementType;
//
///**
// * 使用两个2-4线的decoder组合成一个3-8线的decoder
// * @Description:
// * @Date:2022/11/7 11:36
// * @Author:victorchutian
// */
//public class CombinationDecoder3_8 implements MultiBitsDecoder{
//    private final NOTGate notGate;
//    private final Enabler<MultiBitsDecoder> decoder1;
//    private final Enabler<MultiBitsDecoder> decoder2;
//    private final Potential[] output;
//
//    public CombinationDecoder3_8() {
//        decoder1 = Enabler.get(ImplementType.Logic,MultiBitsDecoder.get(ImplementType.Logic,2));
//        decoder2 = Enabler.get(ImplementType.Logic,MultiBitsDecoder.get(ImplementType.Logic,2));
//        notGate = new NOTGate();
//        output = Potential.array(8);
//    }
//
//    @Override
//    public int inputLength() {
//        return 3;
//    }
//
//    @Override
//    public int outputLength() {
//        return 8;
//    }
//
//    @Override
//    public void input(Potential[] code) {
//        validateInput(code);
//        notGate.input(code[2]);
//        decoder1.input(code[0],code[1],notGate.output()[0]);
//        decoder2.input(code);
//        Potential[] result1 = decoder1.output();
//        Potential[] result2 = decoder2.output();
//        output[0] = result1[0];
//        output[1] = result1[1];
//        output[2] = result1[2];
//        output[3] = result1[3];
//        output[4] = result2[0];
//        output[5] = result2[1];
//        output[6] = result2[2];
//        output[7] = result2[3];
//    }
//
//    @Override
//    public Potential[] output() {
//        return Potential.copyArray(output);
//    }
//}
