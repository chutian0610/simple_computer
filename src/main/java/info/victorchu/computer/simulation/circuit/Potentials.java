package info.victorchu.computer.simulation.circuit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author victorchu
 */
public class Potentials {

    public static Potential[] single(Potential p){
        return new Potential[]{p};
    }

    /**
     * 构建 Potential Array
     * @param array
     * @return
     */
    public static Potential[] of(Potential... array){
        return Arrays.copyOfRange(array,0,array.length);
    }

    public static Potential[] of(Potential[] array,int from, int to){
        return Arrays.copyOfRange(array,from,to);
    }

    /**
     *  构建Potential Array 并使用默认值初始化
     * @param length 初始化长度
     * @return Potential Array
     */
    public static Potential[] array(int length){
        return array(length, integer -> Potential.low());
    }
    /**
     *  构建Potential Array 并使用默认值初始化
     * @param length 初始化长度
     * @param p 初始化值
     * @return Potential Array
     */
    public static Potential[] array(int length, Potential p){
        return array(length, integer -> p.copy());
    }
    /**
     * 构建Potential Array 并使用默认值初始化
     * @param length 初始化长度
     * @param valueSupplier 初始化值方法
     * @return Potential Array
     */
    public static Potential[] array(int length, Function<Integer,Potential> valueSupplier){
        Validate.isTrue(valueSupplier != null);
        Validate.isTrue(length>0,"array length must > 0");
        Potential[] potentials = new Potential[length];
        for (int i = 0; i < potentials.length; i++) {
            potentials[i] = valueSupplier.apply(i);
        }
        return potentials;
    }

    /**
     * 使用默认值设置Potential Array
     * @param array Potential Array
     */
    public static void fillArray(Potential[] array){
        fillArray(array, integer -> Potential.low());
    }

    /**
     * 使用数组设置Potential Array
     * @param array Potential Array
     */
    public static void fillArray(Potential[] array,Potential[] source){
        Validate.isTrue(notEmptyArray(array));        
        Validate.isTrue(notEmptyArray(source));
        Validate.isTrue(array.length>=source.length);
        int gap = array.length-source.length;
        fillArray(array,integer->{
            if(integer<gap){
                return Potential.low();
            }else{
                return source[integer-gap];
            }
        });
    

    }

    /**
     * 设置array的值
     * @param array 数组
     * @param valueSupplier 重置值
     */
    public static void fillArray(Potential[] array, Function<Integer,Potential> valueSupplier){
        if(array == null ||array.length ==0){
            return;
        }

        Validate.isTrue(valueSupplier != null);
        for (int i = 0; i < array.length; i++) {
            array[i] = valueSupplier.apply(i);
        }
    }

    public static void merge(Potential[] state, Object... potentials) {
        Validate.isTrue(potentials != null && potentials.length > 0);
        Validate.isTrue(notEmptyArray(state));

        int length = 0;
        for (Object component : potentials) {
            Validate.isTrue(component !=null);
            if(component instanceof Potential[]) {
                Validate.isTrue(notEmptyArray((Potential[]) component));
                length += ((Potential[]) component).length;
            }else if(component instanceof Potential){
                length += 1;
            }else {
                throw new IllegalArgumentException("只支持Potential[]和Potential");
            }
        }
        Validate.isTrue(state.length == length);

        int cursor = 0;
        for (Object component : potentials) {
            if(component instanceof Potential[]) {
                for (Potential potential : (Potential[]) component) {
                    state[cursor] = potential;
                    cursor++;
                }
            }else {
                state[cursor] = (Potential) component;
                cursor++;
            }
        }
    }

    public static Potential[] join(Object... potentials) {
        Validate.isTrue(potentials != null && potentials.length > 0);
        int length = 0;
        for (Object component : potentials) {
            Validate.isTrue(component !=null);
            if(component instanceof Potential[]) {
                Validate.isTrue(notEmptyArray((Potential[]) component));
                length += ((Potential[]) component).length;
            }else if(component instanceof Potential){
                length += 1;
            }else {
                throw new IllegalArgumentException("只支持Potential[]和Potential");
            }
        }
        Potential[] state = new Potential[length];
        int cursor = 0;
        for (Object component : potentials) {
            if(component instanceof Potential[]) {
                for (Potential potential : (Potential[]) component) {
                    state[cursor] = potential;
                    cursor++;
                }
            }else {
                state[cursor] = (Potential) component;
                cursor++;
            }
        }
        return state;
    }

    /**
     * 批量计算AND
     * @param a
     * @return
     */
    public static Potential and(Potential... a){
        Validate.isTrue(notEmptyArray(a),"Potential Array 不合法");
        Validate.isTrue(a.length>=2,"Potential Array的长度大于等于2");
        Potential init = null;
        for (int i = 0; i < a.length; i++) {
            if(init == null){
                init = a[i];
            }else {
                init = Potential.and(init.output(),a[i].output());
            }
        }
        return init;
    }
    /**
     * 批量计算or
     * @param a
     * @return
     */
    public static Potential or(Potential... a){
        Validate.isTrue(notEmptyArray(a),"Potential Array 不合法");
        Validate.isTrue(a.length>=2,"Potential Array的长度大于等于2");
        Potential init = null;
        for (int i = 0; i < a.length; i++) {
            if(init == null){
                init = a[i];
            }else {
                init = Potential.or(init.output(),a[i].output());
            }
        }
        return init;
    }

    public static Pair<Potential[],Potential> add(Potential[] a, Potential[] b, Potential c) {
        Validate.isTrue(notEmptyArray(a),"Potential Array 不合法");
        Validate.isTrue(notEmptyArray(b),"Potential Array 不合法");
        Validate.isTrue(a.length>0 && a.length ==b.length,"Potential Array的长度需要相等，且大于0");
        Validate.isTrue(c != null,"carry 不能为空");

        Potential[] result = array(a.length);
        Potential tmp = c;
        for (int i = a.length-1; i>=0; i--) {
            Pair<Potential,Potential> re = Potential.fullAdd(a[i],b[i],tmp);
            result[i].input(re.getLeft());
            tmp = re.getRight();
        }
        return Pair.of(result,tmp);
    }

    // ============================= 转化方法 ===================================

    public static Potential[] fromText(String pStr){
        return fromText(pStr,true);
    }
    /**
     * 从文本构建 PotentialArray
     * @param pStr 文本表示的电位
     * @param bigEnd 是否大端序
     * @return Potential Array
     */
    public static Potential[] fromText(String pStr,boolean bigEnd){
        pStr = pStr.replaceAll(" ","");
        Validate.isTrue(StringUtils.isNotEmpty(pStr));
        int length= pStr.length();
        Potential[] array = new Potential[length];

        for (int i = 0; i < length; i++) {
            Potential po = Potential.fromText(pStr.charAt(i));
            if(bigEnd) {
                //  大端序(高位在低地址)
                array[i] = po;
            }else {
                // 小端序(高位在高地址)
                array[length-1-i] = po;
            }
        }
        return array;
    }
    /**
     * 将电位数组打印成比特字符串。不分组.
     * @param array 电位数组
     * @return
     */
    public static String toText(Potential[] array){
        return toText(array,0,null,true);
    }
    public static String toText(Potential[] array,int group){
        Validate.isTrue(group>=0);
        return toText(array,group,null,true);
    }
    /**
     * 将电位数组打印成比特字符串。
     * @param array 电位数组
     * @param group 位数分组，为0时不分组。
     * @param groupSplitStr 分组的分隔符，为null时使用默认分隔符
     * @param bigEnd 是否大端序
     * @return
     */
    public static String toText(Potential[] array, int group,String groupSplitStr,boolean bigEnd){
        Validate.isTrue(group>=0);
        Validate.isTrue(array != null && array.length>0);

        StringBuilder stringBuilder = new StringBuilder();
        int currentLength =array.length;
        int total = currentLength;
        int completeLength =0;
        if(group>0){
            int count =currentLength%group;
            completeLength = count==0?0:group-count ;
            // 补齐后的长度
            total = completeLength+currentLength;
        }
        if(total>currentLength){
            // 不足补0
            for (int i = 0; i < completeLength; i++) {
                stringBuilder.append(Potential.LOW);
            }
        }
        if (bigEnd){
            // 大端序(高位在低地址)
            for (int i =0; i < currentLength; i++) {
                stringBuilder.append(Potential.toText(array[i]));
                if(group>0 && (i+1+completeLength)%group==0 && i!=currentLength-1){
                    stringBuilder.append(groupSplitStr==null?Potential.DEFAULT_GROUP_SPLIT_STR:groupSplitStr);
                }
            }
        }else {
            // 小端序(高位在高地址)
            for (int i = currentLength-1; i>=0; i--) {
                stringBuilder.append(Potential.toText(array[i]));
                if(group>0 && (currentLength-i+completeLength)%group==0 && i!=0){
                    stringBuilder.append(groupSplitStr==null? Potential.DEFAULT_GROUP_SPLIT_STR:groupSplitStr);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static int toUnsignedInt(Potential[] potentials){
        Validate.isTrue(potentials != null && potentials.length>0 && potentials.length<32);
        int re = 0;
        // 大端序(高位在低地址)，从高地址开始遍历
        for (int i = potentials.length-1; i>=0;i--) {
            if(potentials[i].isHigh()){
                re = re + (int) Math.pow(2,potentials.length-1-i);
            }
        }
        return re;
    }

    public static Potential[] fromUnsignedInt(int value){
        if(value==0){
            return Potentials.array(1);
        }
        List<Integer> list = new ArrayList<>();
        while (value>0) {
            int num = value%2;
            list.add(num);
            value = value/2;
        }
        Collections.reverse(list);
        Potential[] potentials = Potentials.array(list.size());
        for (int i = 0; i < list.size(); i++) {
            potentials[i].input(Potential.of(list.get(i) == 1));
        }
        return potentials;
    }
    

    /**
     * 验证 Potential Array的合法性
     * @param array 输入数组
     */
    public static boolean notEmptyArray(Potential[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        for (Potential potential : array) {
            if (potential == null) {
                return false;
            }
        }
        return true;
    }
}
