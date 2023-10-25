package info.victorchu.computer.simulation.circuit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author victorchu
 * @date 2022/8/27 21:14
 */
class PotentialTest {
    @Test
    void testPotentialEquals(){
        Potential potential1 = Potential.high();
        Potential potential2 = Potential.high();
        assertEquals(potential1,potential2);
        Potential potential3 = Potential.low();
        Potential potential4 = Potential.low();
        assertEquals(potential3,potential4);
    }

    @Test
    void testPotentialArrayEquals(){
        Potential[] potential1 = new Potential[]{
                Potential.high(),Potential.low(),
                Potential.high(),Potential.low()
        };
        Potential[] potential2 = new Potential[]{
                Potential.high(),Potential.low(),
                Potential.high(),Potential.low()
        };
        assertArrayEquals(potential1,potential2);
    }

    @Test
    void testPotential2Text(){
        // 0111
        Potential[] array = new Potential[]{
                Potential.high(),Potential.high(),
                Potential.high(),Potential.low()
        };
        assertEquals("1110",Potentials.toText(array));
    }

//    @Test
//    void buildPotentialArrayFromText1(){
//        Potential[] potentials = Potential.buildPotentialArrayFromText("01",true);
//        assertTrue(!potentials[0].isHigh());
//    }
//
//    @Test
//    void buildPotentialArrayFromText2(){
//        Potential[] potentials = Potential.buildPotentialArrayFromText("01",false);
//        Assertions.assertTrue(potentials[0].isHigh());
//    }
//    @Test
//    void toPrettyBitStr42_b() {
//        Potential[] potentials = new Potential[]{
//                Potential.low(),Potential.low(),Potential.high(),Potential.high()
//        };
//        String str= Potential.toBitString(potentials,2," ",false);
//        Assertions.assertEquals(str,"11 00");
//    }
//    @Test
//    void toPrettyBitStr42_s() {
//        Potential[] potentials = new Potential[]{
//                Potential.low(),Potential.low(),Potential.high(),Potential.high()
//        };
//        String str= Potential.toBitString(potentials,2," ",true);
//        Assertions.assertEquals("00 11",str);
//    }
//    @Test
//    void toPrettyBitStr43_b() {
//        Potential[] potentials = new Potential[]{
//                Potential.low(),Potential.low(),Potential.high(),Potential.high()
//        };
//        String str= Potential.toBitString(potentials,3," ",true);
//        Assertions.assertEquals("000 011",str);
//    }
//    @Test
//    void toPrettyBitStr43_s() {
//        Potential[] potentials = new Potential[]{
//                Potential.low(),Potential.low(),Potential.high(),Potential.high()
//        };
//        String str= Potential.toBitString(potentials,3," ",false);
//        Assertions.assertEquals("001 100",str);
//    }
//    @Test
//    void toPrettyBitStr3() {
//        Potential[] potentials = new Potential[]{
//                Potential.low(),Potential.low(),Potential.high(),Potential.high(),
//                Potential.high(),Potential.high(),Potential.low(),Potential.high()
//        };
//        String str= Potential.toBitString(potentials,3," ",false);
//        Assertions.assertEquals("010 111 100",str);
//    }
//    @Test
//    void toPrettyBitStr4() {
//        Potential[] potentials = new Potential[]{
//                Potential.low(),Potential.low(),Potential.high(),Potential.high(),
//                Potential.high(),Potential.high(),Potential.low(),Potential.high()
//        };
//        String str= Potential.toBitString(potentials,3," ",true);
//        Assertions.assertEquals("000 111 101",str);
//    }
//    @Test
//    void toPrettyBitStr5() {
//        Potential[] potentials = new Potential[]{
//                Potential.low(),Potential.low(),Potential.high(),Potential.high(),
//                Potential.high(),Potential.low(),Potential.high()
//        };
//        String str= Potential.toBitString(potentials,4," ",false);
//        Assertions.assertEquals(str,"0101 1100");
//    }
//
//    @Test
//    void toPrettyBitStr7() {
//        Potential[] potentials = new Potential[]{
//                Potential.low(),Potential.low(),Potential.high(),Potential.high()
//        };
//        String str= Potential.toBitString(potentials,0," ",false);
//        Assertions.assertEquals(str,"1100");
//    }

}