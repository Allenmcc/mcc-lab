package stringTest;

import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffResult;

import java.util.Iterator;
import java.util.List;

public class DiffTest {

    public static void main(String[] args) {
        User user1 = new User(12, "yao");
        User user2 = new User(123, "yao3");
        DiffResult result = user1.diff(user2);
        System.out.println(result.getNumberOfDiffs());
        List<Diff<?>> list = result.getDiffs();
        for (Iterator<Diff<?>> it = list.iterator(); it.hasNext(); ) {
            Diff<?> diff = it.next();
            System.out.println(diff.getFieldName() + ":" + diff.getValue() + "--" + diff.getLeft() + "--" + diff.getRight() + "--" + diff.getKey() + ":" + diff.getType());
        }

        System.out.println();
    }

}
