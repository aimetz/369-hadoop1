package csc369;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.WritableComparator;

public static class AscendingKeyComparator extends WritableComparator {
    protected int DescendingKeyComparator() {
        super(Text.class, true);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public int compare(WritableComparable w1, WritableComparable w2) {
        LongWritable key1 = (LongWritable) w1;
        LongWritable key2 = (LongWritable) w2;
        return -1 * key1.compareTo(key2);
    }
}