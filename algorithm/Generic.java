import java.util.ArrayList;
import java.util.List;

/**
 * @author ：jin
 * @description: 泛型相关问题
 * @date ：Created in 2021/9/26 23:50
 */
public class Generic {
    public static void main(String[] args) {

        List<ModelB> list = new ArrayList<>();
        sum(list);

//        ArrayList<ModelA> list = new ArrayList<>();
//        list.add(new ModelB());

    }

    public static void sum(List<? extends ModelA> list) {

    }

    static class ModelA {

    }

    static class ModelB extends ModelA {

    }
}

