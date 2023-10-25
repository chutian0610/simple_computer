//package info.victorchu.computer.simulation.component;
//
//import info.victorchu.computer.simulation.circuit.Potential;
//import info.victorchu.computer.simulation.utils.ImplementType;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.stream.Stream;
//
//import static info.victorchu.computer.simulation.circuit.Potential.buildPotentialArrayFromText;
//import static info.victorchu.computer.simulation.circuit.Potential.toBitString;
//
///**
// * @Description:
// * @Date:2022/11/7 10:37
// * @Author:victorchutian
// */
//class MultiBitsDecoderTest {
//
//    static Stream<Arguments> multiBitsFullAdderProviderFor2_4(){
//        return Stream.of(
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,2),
//                        "00",
//                        "1000"
//                        ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,2),
//                        "01",
//                        "0010"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,2),
//                        "11",
//                        "0001"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,2),
//                        "10",
//                        "0100"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,2),
//                        "00",
//                        "1000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,2),
//                        "01",
//                        "0010"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,2),
//                        "11",
//                        "0001"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,2),
//                        "10",
//                        "0100"
//                )
//        );
//    }
//
//
//    @ParameterizedTest
//    @MethodSource("multiBitsFullAdderProviderFor2_4")
//    public void testMultiBitsDecoderFor2_4(MultiBitsDecoder decoder,String input,String result){
//        System.out.println("decoder:"+decoder.getClass());
//        System.out.println("input:"+input);
//        Potential[] potentials = buildPotentialArrayFromText(input,true);
//        decoder.input(potentials);
//        Potential[] output= decoder.output();
//        System.out.println("output:"+toBitString(output));
//        Assertions.assertTrue(result.equals(toBitString(output)));
//    }
//
//    static Stream<Arguments> multiBitsFullAdderProviderFor3_8(){
//        return Stream.of(
//                Arguments.of(
//                        new CombinationDecoder3_8(),
//                        "000",
//                        "10000000"
//                ),
//                Arguments.of(
//                        new CombinationDecoder3_8(),
//                        "001",
//                        "00001000"
//                ),
//                Arguments.of(
//                        new CombinationDecoder3_8(),
//                        "010",
//                        "00100000"
//                ),
//                Arguments.of(
//                        new CombinationDecoder3_8(),
//                        "011",
//                        "00000010"
//                ),
//                Arguments.of(
//                        new CombinationDecoder3_8(),
//                        "100",
//                        "01000000"
//                ),
//                Arguments.of(
//                        new CombinationDecoder3_8(),
//                        "101",
//                        "00000100"
//                ),
//                Arguments.of(
//                        new CombinationDecoder3_8(),
//                        "110",
//                        "00010000"
//                ),
//                Arguments.of(
//                        new CombinationDecoder3_8(),
//                        "111",
//                        "00000001"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,3),
//                        "000",
//                        "10000000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,3),
//                        "001",
//                        "00001000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,3),
//                        "010",
//                        "00100000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,3),
//                        "011",
//                        "00000010"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,3),
//                        "100",
//                        "01000000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,3),
//                        "101",
//                        "00000100"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,3),
//                        "110",
//                        "00010000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Logic,3),
//                        "111",
//                        "00000001"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,3),
//                        "000",
//                        "10000000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,3),
//                        "001",
//                        "00001000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,3),
//                        "010",
//                        "00100000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,3),
//                        "011",
//                        "00000010"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,3),
//                        "100",
//                        "01000000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,3),
//                        "101",
//                        "00000100"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,3),
//                        "110",
//                        "00010000"
//                ),
//                Arguments.of(
//                        MultiBitsDecoder.get(ImplementType.Circuit,3),
//                        "111",
//                        "00000001"
//                )
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("multiBitsFullAdderProviderFor3_8")
//    public void testMultiBitsDecoderFor3_8(MultiBitsDecoder decoder,String input,String result){
//        System.out.println("decoder:"+decoder.getClass());
//        System.out.println("input:"+input);
//        Potential[] potentials = buildPotentialArrayFromText(input,true);
//        decoder.input(potentials);
//        Potential[] output= decoder.output();
//        System.out.println("output:"+toBitString(output));
//        Assertions.assertTrue(result.equals(toBitString(output)));
//    }
//
//
//}