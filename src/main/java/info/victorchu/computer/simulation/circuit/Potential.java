package info.victorchu.computer.simulation.circuit;

import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.tuple.Pair;

/**
 * 电位的抽象.
 * <pre>
 * 真值表:
 * input output
 *  0     0
 *  1     1
 * </pre>
 * @author victorchu
 */
@EqualsAndHashCode
public class Potential {
    public static final Character LOW = '0';
    public static final Character HIGH = '1';

    public static final String DEFAULT_GROUP_SPLIT_STR = " ";

    /**
     * 电位的值.
     * true 高电位
     * false 低电位
     */
    private boolean value;

    /**
     * 保护方法, 禁止外部无参构造。
     * 目的是所有初始化后的Potential，都会有value。
     */
    private Potential(){

    }
    private Potential(boolean value) {
        this.value = value;
    }

    /**
     * 根据输入Potential变更自身的电位
     * @param potential 电位
     */
    public void input(Potential potential) {
        this.value = potential.value;
    }

    /**
     * 输出Potential
     * @return
     */
    public Potential output() {
        return this.copy();
    }

    /**
     * 是否高电位
     * @return
     */
    public boolean isHigh(){
        return value;
    }

    /**
     * 创建电位副本
     * @return
     */
    public Potential copy(){
        return new Potential(this.value);
    }

    @Override
    public String toString() {
        return Potential.toText(this).toString();
    }

    // ======================== 工厂方法 ===============================

    /**
     * 基于 boolean 值构建 Potential
     * @param value
     * @return
     */
    public static Potential of(boolean value){
        return new Potential(value);
    }

    /**
     * 高电位
     * @return
     */
    public static Potential high(){
        return new Potential(true);
    }

    /**
     * 低电位
     * @return
     */
    public static Potential low(){
        return new Potential(false);
    }

    // ============================= 运算符 =================================

    /**
     * 电位「非」
     * @param a 输入电位
     * @return
     */
    public static Potential not(Potential a){
        Validate.notNull(a,"Potential not 参数不能为null");
        return Potential.of(!a.value);
    }

    /**
     * 电位「与」
     * @param a 输入电位
     * @param b 输入电位
     * @return
     */
    public static Potential and(Potential a ,Potential b){
        Validate.notNull(a,"Potential and 参数不能为null");
        Validate.notNull(b,"Potential and 参数不能为null");
        return Potential.of(a.value & b.value);
    }
    /**
     * 电位「或」
     * @param a 输入电位
     * @param b 输入电位
     * @return
     */
    public static Potential or(Potential a , Potential b){
        Validate.notNull(a,"Potential or 参数不能为null");
        Validate.notNull(b,"Potential or 参数不能为null");
        return Potential.of(a.value | b.value);
    }

    /**
     * 电位「异或」
     * @param a 输入电位
     * @param b 输入电位
     * @return
     */
    public static Potential xor(Potential a , Potential b){
        Validate.notNull(a,"Potential or 参数不能为null");
        Validate.notNull(b,"Potential or 参数不能为null");
        return or(
                and(a, not(b)),
                and(not(a), b));
    }

    /**
     * 半加
     * @param a 输入
     * @param b 输入
     * @return 输出(sum,carry)
     */
    public static Pair<Potential,Potential> halfAdd(Potential a , Potential b){
        return Pair.of(
                xor(a,b),
                and(a,b));
    }

    /**
     * 全加
     * @param a 输入
     * @param b 输入
     * @param c 进位
     * @return 输出(sum,carry)
     */
    public static Pair<Potential,Potential> fullAdd(Potential a , Potential b, Potential c){
        Pair<Potential,Potential> half1 = halfAdd(a,b);
        Pair<Potential,Potential> half2 = halfAdd(half1.getLeft(),c);
        return Pair.of(
                half2.getLeft(),
                or(half1.getRight(),half2.getRight()));
    }

    // ============================= 序列化方法 ==================================

    public static Potential fromText(Character c){
        if(HIGH.equals(c)){
            return Potential.high();
        }else if(LOW.equals(c)) {
            return Potential.low();
        }
        throw new IllegalArgumentException("无效的字符表示");
    }

    public static Character toText(Potential potential){
        if(potential.isHigh()){
            return HIGH;
        }
        return LOW;
    }
}
